package com.liao.sample.quartz.base.b01.Job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.log4j.Logger;

/**
 * Author liao
 * C or U by 2016/5/23-22:33
 * sample
 */
public class SimpleJob implements Job {

    private static final Logger logger = Logger.getLogger(SimpleJob.class);
    private static int i=0;
    public void execute(JobExecutionContext context)
            throws JobExecutionException {
        i++;
        logger.error("Hello quzrtz  "+i);

    }
}
