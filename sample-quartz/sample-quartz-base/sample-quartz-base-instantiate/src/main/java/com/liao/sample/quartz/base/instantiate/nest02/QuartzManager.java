package com.liao.sample.quartz.base.instantiate.nest02;

import org.apache.log4j.Logger;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Author liao
 * C or U by 2016/5/31-23:13
 * sample
 */
public class QuartzManager {
    private static Logger log= Logger.getLogger(QuartzManager.class);
    private SchedulerFactory sf;
    private QuartzManager(){
        sf=new StdSchedulerFactory();
    }

    private static QuartzManager quartzManager;

    public static QuartzManager getInstance() throws SchedulerException {
        if(quartzManager==null){
            quartzManager=new QuartzManager();
            quartzManager.addListener(quartzManager.sf.getScheduler());
        }
        return quartzManager;
    }
    public void addListener(Scheduler sd) {
        ListenerManager listenerManager= null;
        try {
            listenerManager = sd.getListenerManager();
            listenerManager.addJobListener(new MyJobListener());
            listenerManager.addTriggerListener(new MyTriggerListener());
           listenerManager.addSchedulerListener(new MySchedulerListener());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

    }

    public  void addSchedule(Class t,JobKey jobKey,TriggerKey triggerKey,String cronExpression){

        // 3、创建Scheduler
        Scheduler scheduler = null;
        try {
            // 1、创建一个JobDetail实例，指定Quartz
            JobDetail jobDetail = JobBuilder.newJob(t)
                    // 任务执行类
                    .withIdentity(jobKey)
                    // 任务名，任务组
                    .build();
            CronScheduleBuilder builder=CronScheduleBuilder.cronSchedule(cronExpression);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey).startNow()
                    .withSchedule(builder).build();
            scheduler = sf.getScheduler();
            log.error("this.name:"+scheduler.getSchedulerName());
            // 4、调度执行
            scheduler.scheduleJob(jobDetail, trigger);
            if(scheduler.checkExists(jobKey)){//如果jobkey已存在,不行
                scheduler.scheduleJob(trigger);
            }
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public void modiftyJob(TriggerKey triggerKey,String cronExpression){

        Scheduler scheduler= null;
        try {
            scheduler = sf.getScheduler();
            //拿到旧的
            CronTrigger cronTrigger=(CronTrigger)scheduler.getTrigger(triggerKey);
            log.error("修改前："+cronTrigger.getCronExpression());
            //构建新的
            CronScheduleBuilder builder=CronScheduleBuilder.cronSchedule(cronExpression);
            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity(triggerKey).startNow()
                    .withSchedule(builder).build();
            scheduler.rescheduleJob(triggerKey,trigger);
            log.error("修改后："+((CronTrigger) scheduler.getTrigger(trigger.getKey())).getCronExpression());
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public void deleteJob(JobKey jobkey){
        Scheduler scheduler= null;
        try {
            scheduler = sf.getScheduler();
            scheduler.deleteJob(jobkey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public void pauseJob(JobKey jobKey){
        Scheduler scheduler= null;
        try {
            scheduler = sf.getScheduler();
            scheduler.pauseJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
    public void resumeJob(JobKey jobKey){
        Scheduler scheduler= null;
        try {
            scheduler = sf.getScheduler();
            scheduler.resumeJob(jobKey);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }


}
