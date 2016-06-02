package com.liao.sample.quartz.base.instantiate.nest02;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;

/**
 * Author liao
 * C or U by 2016/6/2-22:45
 * sample
 */
public class MyJobListener implements JobListener {
    Logger logger=Logger.getLogger(MyJobListener.class);
    @Override
    public String getName() {
        return "myJobListener";
    }

    @Override
    /**
     * 即将被执行
     */
    public void jobToBeExecuted(JobExecutionContext context) {
        logger.error("job即将被执行！");
    }

    /**
     * 执行但是被打断
     * @param context
     */
    public void jobExecutionVetoed(JobExecutionContext context) {
        logger.error("job被打断执行了！");
    }

    /**
     * 执行结束
     * @param context
     * @param jobException
     */
    public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
        logger.error("job执行结束！");
    }
}
