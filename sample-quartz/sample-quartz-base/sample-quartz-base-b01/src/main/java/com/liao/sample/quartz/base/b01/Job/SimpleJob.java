package com.liao.sample.quartz.base.b01.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Author liao
 * C or U by 2016/5/23-22:33
 * sample
 */
public class SimpleJob implements Job {

     private static  int i=0;
    //private int i=0; //这样不行
    public void execute(JobExecutionContext context) throws JobExecutionException {
        i++;
        System.out.println("[job] welcome  to Quartz:"+i);
    }
}
