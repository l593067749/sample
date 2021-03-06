package com.liao.sample.quartz.base.b01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Author liao
 * C or U by 2016/5/23-22:42
 * 按天触发
 */
public class SimpleTimeIntervalJobTest {

    public void execute() throws Exception {
        SchedulerFactory factory=new StdSchedulerFactory();
        Scheduler scheduler=factory.getScheduler();

        new Thread(new Runnable() {
            public void run() {
                int i=0;
                while (i<20){
                    try {
                        Thread.currentThread().sleep(1000);
                        System.out.println("——————1秒过去了————————");
                        i++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Thread.currentThread().interrupt();
            }
        }).start();


        //任务详情
        JobDetail jobDetail= JobBuilder.newJob(SimpleJob.class)
                .withIdentity(JobKey.jobKey("simpleJob","simpleJobGroup"))
                .build()
                ;
        //触发
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("simleTrigger","simpleTriGroup"))
                .withSchedule(
                        SimpleScheduleBuilder.repeatSecondlyForTotalCount(3,2)
                )
                .build();

        //调度
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new SimpleTimeIntervalJobTest().execute();
    }

}