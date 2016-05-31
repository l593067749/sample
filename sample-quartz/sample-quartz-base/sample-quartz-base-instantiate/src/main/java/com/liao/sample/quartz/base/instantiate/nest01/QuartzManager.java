package com.liao.sample.quartz.base.instantiate.nest01;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static javafx.scene.input.KeyCode.T;

/**
 * Author liao
 * C or U by 2016/5/31-23:13
 * sample
 */
public class QuartzManager {
    private SchedulerFactory sf;
    private QuartzManager(){
        sf=new StdSchedulerFactory();
    }

    private static  QuartzManager quartzManager;

    public static QuartzManager getInstance(){
        if(quartzManager==null){
            quartzManager=new QuartzManager();
        }
        return quartzManager;
    }

    public  void addSchedule(Class t,JobKey jobKey,TriggerKey triggerKey){

        // 3、创建Scheduler
        Scheduler scheduler = null;
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(t)
                    // 任务执行类
                    .withIdentity(jobKey)
                    // 任务名，任务组
                    .build();
            // 2、创建Trigger
            SimpleScheduleBuilder builder = SimpleScheduleBuilder
                    .simpleSchedule()
                    // 设置执行次数
                    .repeatSecondlyForTotalCount(100);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey).startNow()
                    .withSchedule(builder).build();
            scheduler = sf.getScheduler();
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
