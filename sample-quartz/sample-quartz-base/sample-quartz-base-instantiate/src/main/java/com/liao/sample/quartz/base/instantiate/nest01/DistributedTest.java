package com.liao.sample.quartz.base.instantiate.nest01;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Author liao
 * C or U by 2016/10/12-23:33
 * sample
 */
public class DistributedTest {
    public static void main(String[] args) {
       final QuartzManager quartzManager = QuartzManager.getInstance();
        long curTime=System.currentTimeMillis();
       final JobKey oneJobKey=new JobKey("job_"+curTime,"jGroup_"+curTime);
        TriggerKey triggerKey=new TriggerKey("trigger_"+curTime, "tGroup_"+curTime);
        quartzManager.cleanJobs();
        //增加一个
        quartzManager.addSchedule(MyJob.class, oneJobKey,triggerKey,"0/1  * * * * ?");
        quartzManager.pauseJob(oneJobKey);

        new Thread(new Runnable() {
            @Override
            public void run() {
                quartzManager.resumeJob(oneJobKey);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                quartzManager.resumeJob(oneJobKey);
            }
        }).start();


    }
}
