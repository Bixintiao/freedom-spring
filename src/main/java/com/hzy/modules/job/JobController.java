package com.hzy.modules.job;

import com.hzy.modules.job.jobs.Job1;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import utils.taskScheduler.Task;
import utils.taskScheduler.TaskSchedulerUtil;

/**
 * project freedom-spring
 * @Author hzy
 * @Date 2019/3/25 9:28
 * @Description version 1.0
 */
@RequestMapping("job")
@RestController
public class JobController {

    String corn = "0 0/2 * * * ?";

    @RequestMapping("startJob")
    public String startJob(String taskId) throws Exception {
        TaskSchedulerUtil.startScheduled(taskId, new Task() {
                @Override
                public void executeTask(Object t) {
                        System.out.println("["+taskId+"] I'm a test task [" + t +"]");
                    }
                }
                , corn
                , "just for test param . Aha"
        );
        System.out.println("start one job "+taskId);
        return "start success";
    }



    @RequestMapping("/cancelJob")
    public String cancelJob(String taskId) throws Exception {
        TaskSchedulerUtil.cancelScheduled(taskId);
        return "cancel success";
    }



    @RequestMapping("job1")
    public String startJob1() throws Exception {
        TaskSchedulerUtil.startScheduled("job1__", new Job1() ,corn ," test job1");
        System.out.println("start one job job1__");
        return "start success";
    }


}
