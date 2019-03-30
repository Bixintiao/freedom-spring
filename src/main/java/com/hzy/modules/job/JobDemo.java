package com.hzy.modules.job;

import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hzy
 * @version Revision:v1.0,Date:2019年02月21日
 * @project freedom-spring
 * @description
 * @Modification Date:2019年02月21日 {填写修改说明}
 */

@Component
@PropertySource(value="classpath:cron.properties")
public class JobDemo {


    @Scheduled(cron = "${job.corn.common}")
    public void scheduledDemo(){
        System.out.println("        ---------------- scheduledDemo -----------------");
    }

}
