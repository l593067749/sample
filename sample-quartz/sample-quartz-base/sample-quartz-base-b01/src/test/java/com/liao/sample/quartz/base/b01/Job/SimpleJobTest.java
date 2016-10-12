package com.liao.sample.quartz.base.b01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Author liao
 * C or U by 2016/5/23-22:42
 * 最简单的触发
 */
public class SimpleJobTest {

    public void execute() throws Exception {
        //调度工厂
        SchedulerFactory factory=new StdSchedulerFactory();
        //获取一个调度
        Scheduler scheduler=factory.getScheduler();

        //job实例
        JobDetail jobDetail= JobBuilder.newJob(SimpleJob.class)
                .withIdentity(JobKey.jobKey("simpleJob","simpleJobGroup"))
                .build()
                ;
        //触发器，每2秒运行一次，共10次，当前时间执行
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("simleTrigger","simpleTriGroup"))
                .withSchedule(SimpleScheduleBuilder
                        .repeatSecondlyForTotalCount(10,2)
                        )
                .startAt(new Date())
                .build();
        //绑定job实例和触发器
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new SimpleJobTest().execute();
    }

}