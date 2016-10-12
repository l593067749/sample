package com.liao.sample.quartz.base.instantiate.nest01;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob extends BaseJob{
	private static int i=0;
	private static final Logger logger = Logger.getLogger(MyJob.class);

	public void doExecute(JobExecutionContext context) {
		logger.error("Hello quzrtz  "+i+"-"+Thread.currentThread().getName()+"****");
	}
}