package com.liao.sample.quartz.base.instantiate.nest01;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Author liao
 * C or U by 2016/5/31-23:25
 * sample
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        QuartzManager quartzManager = QuartzManager.getInstance();
        long curTime=System.currentTimeMillis();
        JobKey oneJobKey=new JobKey("job_"+curTime,"jGroup_"+curTime);
        TriggerKey triggerKey=new TriggerKey("trigger_"+curTime, "tGroup_"+curTime);
        quartzManager.cleanJobs();
        //增加一个
        quartzManager.addSchedule(MyJob.class, oneJobKey,triggerKey,"0/1  * * * * ?");
        Thread.sleep(4000);
        //暂停
        quartzManager.pauseJob(oneJobKey);
        Thread.sleep(4000);
        //恢复
        quartzManager.resumeJob(oneJobKey);
        Thread.sleep(4000);
        //修改
        quartzManager.modiftyJob(triggerKey,"0/3  * * * * ?");
        Thread.sleep(4000);
        //删除
        quartzManager.deleteJob(oneJobKey);
    }
}
