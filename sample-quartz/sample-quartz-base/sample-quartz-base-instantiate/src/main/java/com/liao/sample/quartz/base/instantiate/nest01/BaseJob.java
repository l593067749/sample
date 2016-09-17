package com.liao.sample.quartz.base.instantiate.nest01;

import com.liao.sample.quartz.base.instantiate.MyJob;
import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Author liao
 * C or U by 2016/5/31-22:59
 * sample
 */
public abstract class BaseJob implements Job {

    private static final Logger logger = Logger.getLogger(BaseJob.class);

    public abstract void doExecute(JobExecutionContext context) throws JobExecutionException;

    /**
     * 任务执行之前的操作
     */
    private void beForExecute(){
        /*logger.error("开始执行任务！");*/
    }

    /**
     * 任务执行结束的操作
     */
    private void endExecute(){
        /*logger.error("任务结束！");*/
    }

    @Override
    public void execute(JobExecutionContext context) {
        beForExecute();
        try {
            doExecute(context);
        } catch (JobExecutionException e) {
            //这里可以做一些操作，把异常插入表里
            logger.error(e);
        }
        endExecute();
    }
}
