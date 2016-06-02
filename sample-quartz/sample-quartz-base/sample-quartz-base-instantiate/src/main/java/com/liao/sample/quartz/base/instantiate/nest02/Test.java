package com.liao.sample.quartz.base.instantiate.nest02;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Author liao
 * C or U by 2016/5/31-23:25
 * sample
 */
public class Test {
    public static void main(String[] args) throws Exception {
        QuartzManager quartzManager = QuartzManager.getInstance();
        JobKey oneJobKey=new JobKey("job1_11","jGroup1");
        JobKey twoJobKey=new JobKey("job1_12","jGroup1");
        TriggerKey triggerKey=new TriggerKey("trigger1", "tGroup1");
        TriggerKey triggerKey2=new TriggerKey("trigger12", "tGroup1");
        //删除
        quartzManager.deleteJob(oneJobKey);
        quartzManager.deleteJob(twoJobKey);
        //增加
        quartzManager.addSchedule(MyJob.class, oneJobKey,triggerKey,"0/2  * * * * ?");
        quartzManager.addSchedule(MyJob.class, oneJobKey,triggerKey2,"0/3  * * * * ?");
        //一个Trigger只能绑定多个任务
        // quartzManager.addSchedule(MyJob2.class, twoJobKey,triggerKey,"0/2  * * * * ?");

       /* //暂停
        Thread.sleep(10000);
        quartzManager.pauseJob(oneJobKey);
        //恢复
        Thread.sleep(8000);
        quartzManager.resumeJob(oneJobKey);
        //修改
        quartzManager.modiftyJob(triggerKey,"0/3  * * * * ?");
        quartzManager.resumeJob(oneJobKey);*/




    }
}
