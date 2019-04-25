package com.hzy.modules.job.jobs;

import utils.taskScheduler.Task;

/**
 * project freedom-spring
 *
 * @Author hzy
 * @Date 2019/3/25 9:30
 * @Description version 1.0
 */
public class Job1 implements Task {


    @Override
    public void executeTask(Object t) {
        System.out.println(" ::: executeTask   param -> " + t);
    }


}
