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
        JobKey oneJobKey=new JobKey("job2_11","jGroup2");
        TriggerKey triggerKey=new TriggerKey("trigger2_11", "tGroup2");
        //删除
        quartzManager.deleteJob(oneJobKey);
        quartzManager.addSchedule(MyJob.class, oneJobKey,triggerKey,"0/2  * * * * ?");

       /* Thread.sleep(10000);
        quartzManager.pauseJob(oneJobKey);
        Thread.sleep(8000);
        quartzManager.resumeJob(oneJobKey);*/
        Thread.sleep(4000);
        quartzManager.pauseJob(oneJobKey);
        quartzManager.modiftyJob(triggerKey,"0/3  * * * * ?");
        quartzManager.resumeJob(oneJobKey);




    }
}
