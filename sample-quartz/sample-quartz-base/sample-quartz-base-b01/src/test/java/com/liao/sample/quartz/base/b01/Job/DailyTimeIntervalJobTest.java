package com.liao.sample.quartz.base.b01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Author liao
 * C or U by 2016/5/23-22:42
 * sample
 */
public class DailyTimeIntervalJobTest {

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


        JobDetail jobDetail= JobBuilder.newJob(SimpleJob.class)
                .withIdentity(JobKey.jobKey("simpleJob","simpleJobGroup"))
                .build()
                ;
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("simleTrigger","simpleTriGroup"))
                .withSchedule(
                        DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                        .onDaysOfTheWeek(DateBuilder.MONDAY, DateBuilder.TUESDAY) //星期一到星期二

                                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(00,16))//具体时间点开始
                                .withIntervalInSeconds(2)
                                .withRepeatCount(10)
                                .endingDailyAfterCount(2)
                        )
                .startAt(new Date())
                .build();

        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new DailyTimeIntervalJobTest().execute();
    }

}