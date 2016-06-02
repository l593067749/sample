package com.liao.sample.quartz.base.instantiate.nest02;

import org.apache.log4j.Logger;
import org.quartz.JobExecutionContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MyJob2 extends BaseJob {
	private static final Logger logger = Logger.getLogger(MyJob2.class);

	public void doExecute(JobExecutionContext context) {
		logger.error(MyJob2.class+"Hello quzrtz  "+
				new SimpleDateFormat("yyyy-MM-dd HH:mm:ss ").format(new Date()));
	}
}