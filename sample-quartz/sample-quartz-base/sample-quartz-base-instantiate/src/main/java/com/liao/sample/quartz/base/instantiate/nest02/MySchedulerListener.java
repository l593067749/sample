package com.liao.sample.quartz.base.instantiate.nest02;

import org.apache.log4j.Logger;
import org.quartz.*;

/**
 * Author liao
 * C or U by 2016/6/2-23:23
 * sample
 */
public class MySchedulerListener implements SchedulerListener {
    Logger logger=Logger.getLogger(MySchedulerListener.class);
    @Override
    public void jobScheduled(Trigger trigger) {

    }

    @Override
    public void jobUnscheduled(TriggerKey triggerKey) {
        logger.error("不按时间表执行");
    }

    @Override
    public void triggerFinalized(Trigger trigger) {

    }

    @Override
    public void triggerPaused(TriggerKey triggerKey) {

    }

    @Override
    public void triggersPaused(String triggerGroup) {

    }

    @Override
    public void triggerResumed(TriggerKey triggerKey) {

    }

    @Override
    public void triggersResumed(String triggerGroup) {

    }

    @Override
    public void jobAdded(JobDetail jobDetail) {
        logger.error("增加一个job："+jobDetail.getDescription());
    }

    @Override
    public void jobDeleted(JobKey jobKey) {
        logger.error("删除一个job："+jobKey.getName());
    }

    @Override
    public void jobPaused(JobKey jobKey) {
        logger.error("暂停一个job："+jobKey.getName());
    }

    @Override
    public void jobsPaused(String jobGroup) {

    }

    @Override
    public void jobResumed(JobKey jobKey) {
        logger.error("恢复一个job："+jobKey.getName());
    }

    @Override
    public void jobsResumed(String jobGroup) {

    }

    @Override
    public void schedulerError(String msg, SchedulerException cause) {

    }

    @Override
    //待机模式
    public void schedulerInStandbyMode() {

    }

    @Override
    public void schedulerStarted() {
        logger.error("scheduler启动了");
    }

    @Override
    public void schedulerStarting() {
        logger.error("scheduler即将启动了");
    }

    @Override
    public void schedulerShutdown() {
        logger.error("scheduler结束了");
    }

    @Override
    public void schedulerShuttingdown() {
        logger.error("scheduler即将要结束了");
    }

    @Override
    public void schedulingDataCleared() {

    }
}
