package com.liao.sample.quartz.base.instantiate.nest01;

import org.apache.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob extends BaseJob{
	private static final Logger logger = Logger.getLogger(MyJob.class);

	public void doExecute(JobExecutionContext context) {
		logger.error("Hello quzrtz  "+
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
	}
}