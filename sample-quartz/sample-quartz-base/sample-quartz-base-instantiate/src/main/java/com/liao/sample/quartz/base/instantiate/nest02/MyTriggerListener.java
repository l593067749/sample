package com.liao.sample.quartz.base.instantiate.nest02;

import org.apache.log4j.Logger;
import org.quartz.CronTrigger;
import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.TriggerListener;

/**
 * Author liao
 * C or U by 2016/6/2-23:01
 * sample
 */
public class MyTriggerListener implements TriggerListener{
    Logger logger=Logger.getLogger(MyTriggerListener.class);
    @Override
    public String getName() {
        return "myTrigerListener";
    }

    @Override
    /**
     * trigger 触发
     */
    public void triggerFired(Trigger trigger, JobExecutionContext context) {
        logger.error("trigger将被触发："+trigger.getJobDataMap().toString()+""+((CronTrigger)trigger ).getCronExpression());
    }

    @Override
    public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
        return false;
    }

    /**
     * 错过了
     * @param trigger
     */
    public void triggerMisfired(Trigger trigger) {
        logger.error("trigger错过了："+trigger.getJobDataMap().toString()+"");
    }

    @Override
    public void triggerComplete(Trigger trigger, JobExecutionContext context, Trigger.CompletedExecutionInstruction triggerInstructionCode) {
        logger.error("trigger触发完毕："+trigger.getJobDataMap().toString()+"");
    }
}
