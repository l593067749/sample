package com.liao.sample.quartz.base.b01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;
import java.util.SimpleTimeZone;

/**
 * Author liao
 * C or U by 2016/5/24-23:35
 * 指定间隔时间 （数值）
 *和间隔的单位 （秒，分，小时，。。。）
 */
public class CalendarIntervalScheduleJobTest {
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
                        CalendarIntervalScheduleBuilder.calendarIntervalSchedule()
                                .withIntervalInSeconds(2)
                )
                .startAt(new Date())
                .build();

        //调度
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new CalendarIntervalScheduleJobTest().execute();
    }
}
