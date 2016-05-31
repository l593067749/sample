package com.liao.sample.quartz.base.instantiate.nest01;

import org.quartz.JobKey;
import org.quartz.TriggerKey;

/**
 * Author liao
 * C or U by 2016/5/31-23:25
 * sample
 */
public class Test {
    public static void main(String[] args) {
       QuartzManager quartzManager= QuartzManager.getInstance();
        quartzManager.addSchedule(MyJob.class,new JobKey("job1_11", "jGroup1"),new TriggerKey("trigger1_11", "tGroup1"));


    }
}
