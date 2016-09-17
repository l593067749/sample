package com.liao.sample.quartz.base.instantiate;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class QuartzTest {
	public static void main(String[] args) throws Exception,
			ParseException {
		QuartzTest qt=new QuartzTest();
		long curTime=System.currentTimeMillis();
		//开始一个调度
		qt.startSchedule(curTime);
		Thread.sleep(6000);
		//恢复调度
		System.out.println("恢复调度！");
		qt.resumeJob(curTime);
	}
	/**
	 * 开始一个simpleSchedule()调度
	 */
	public  void startSchedule(long curTime) {
		try {
			// 1、创建一个JobDetail实例，指定Quartz
			JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
			// 任务执行类
					.withIdentity("job_"+curTime, "jGroup_"+curTime)
					// 任务名，任务组
					.build();
			// 2、创建Trigger
			SimpleScheduleBuilder builder = SimpleScheduleBuilder
					.simpleSchedule()
					// 设置执行次数
				    .repeatSecondlyForTotalCount(10,1)
					;
			Trigger trigger = TriggerBuilder.newTrigger()
					.withIdentity("trigger_"+curTime, "tGroup1_"+curTime)
					.withSchedule(builder).startAt(new Date()).build();
			// 3、创建Scheduler
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.start();
			// 4、调度执行
			scheduler.scheduleJob(jobDetail, trigger);

			Thread.sleep(3000);
			scheduler.shutdown();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 从数据库中找到已经存在的job，并重新开户调度
	 */
	public  void resumeJob(long curTime) {
		try {

			SchedulerFactory schedulerFactory = new StdSchedulerFactory();
			Scheduler scheduler = schedulerFactory.getScheduler();
			// ①获取调度器中所有的触发器组
			List<String> triggerGroups = scheduler.getTriggerGroupNames();
			// ②重新恢复在tgroup1组中，名为trigger1_1触发器的运行
			for (int i = 0; i < triggerGroups.size(); i++) {
				List<String> triggers = scheduler.getTriggerGroupNames();
				for (int j = 0; j < triggers.size(); j++) {
					Trigger tg = scheduler.getTrigger(new TriggerKey(triggers
							.get(j), triggerGroups.get(i)));
					// ②-1:根据名称判断
					if (tg instanceof SimpleTrigger
							&& tg.getDescription().equals("tGroup1_"+curTime+"."+"trigger_"+curTime)) {
						// ②-1:恢复运行
						scheduler.resumeJob(new JobKey(triggers.get(j),
								triggerGroups.get(i)));
					}
				}

			}
			scheduler.start();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}
}