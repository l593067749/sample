package com.liao.sample.quartz.base.instantiate;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyJob implements Job{
	private static final Logger logger = Logger.getLogger(MyJob.class);
	private static int i=0;
	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		i++;
		logger.error("Hello quzrtz  "+i+"-"+Thread.currentThread().getName()+"0****");

	}

}