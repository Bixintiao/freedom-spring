package utils.taskScheduler;

import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ScheduledFuture;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/23 16:53
 * @Description version 1.0
 */
public class TaskSchedulerUtil {


    private static int poolSize = 20;
    private static int awaitTerminationSeconds = 180;
    private static ThreadPoolTaskScheduler threadPoolTaskScheduler;
    private static Map<String,ScheduledFuture<?>> taskMap;
    static {
        threadPoolTaskScheduler = getThreadPool();
        taskMap = taskMap == null ? new HashMap<>() : taskMap;
    }


    public static ScheduledFuture<?> startScheduled(String taskId, Task task, String corn) throws Exception{
        return startScheduled(taskId, task, corn, null);
    }

    //开启定时任务
    public static ScheduledFuture<?> startScheduled(String taskId, Task task, String corn, Object param) throws Exception
    {
        if (null != taskMap && taskMap.containsKey(taskId)) {
            throw new Exception("duplicate task Id. already exist.");
        }
        ScheduledFuture<?> schedule = threadPoolTaskScheduler.schedule(()->{
            task.executeTask(param);
        }, new CronTrigger(corn));
        taskMap.put(taskId, schedule);
        return schedule;
    }


    //关闭定时任务
    public static void cancelScheduled(String taskId) throws Exception {
        if (null != taskMap && taskMap.containsKey(taskId)){
            ScheduledFuture<?> future = taskMap.get(taskId);
            future.cancel(true);
            taskMap.remove(taskId);
        } else {
            throw new Exception("no task found for taskId ["+taskId+"] .");
        }
    }


    //获取线程
    private static ThreadPoolTaskScheduler getThreadPool(){
        if (null == threadPoolTaskScheduler){
            threadPoolTaskScheduler = new ThreadPoolTaskScheduler();
            threadPoolTaskScheduler.initialize();
            threadPoolTaskScheduler.setPoolSize(poolSize);
            threadPoolTaskScheduler.setAwaitTerminationSeconds(awaitTerminationSeconds);
            threadPoolTaskScheduler.setThreadNamePrefix("scheduler-task-");
        }
        return threadPoolTaskScheduler;
    }



}
