package com.liao.sample.quartz.base.b01.Job;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Date;

/**
 * Author liao
 * C or U by 2016/5/23-22:42
 * 按天触发
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


        //任务详情
        JobDetail jobDetail= JobBuilder.newJob(SimpleJob.class)
                .withIdentity(JobKey.jobKey("simpleJob","simpleJobGroup"))
                .build()
                ;
        //触发
        Trigger trigger=TriggerBuilder.newTrigger()
                .withIdentity(TriggerKey.triggerKey("simleTrigger","simpleTriGroup"))
                .withSchedule(
                        DailyTimeIntervalScheduleBuilder.dailyTimeIntervalSchedule()
                        .onDaysOfTheWeek(DateBuilder.MONDAY, DateBuilder.TUESDAY) //星期一到星期二

                                .startingDailyAt(TimeOfDay.hourAndMinuteOfDay(23,24))//具体时间点开始
                                .withIntervalInSeconds(2)//设置间隔
                                .withRepeatCount(10) //设置次数 1+10
                                .endingDailyAfterCount(2)//每天的执行次数限制
                        )
                .startAt(new Date())
                .build();

        //调度
        scheduler.scheduleJob(jobDetail,trigger);
        scheduler.start();

    }

    public static void main(String[] args) throws Exception {
        new DailyTimeIntervalJobTest().execute();
    }

}