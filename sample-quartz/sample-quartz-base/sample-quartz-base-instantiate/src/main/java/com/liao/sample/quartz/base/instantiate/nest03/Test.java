package com.liao.sample.quartz.base.instantiate.nest03;

import com.liao.sample.quartz.base.instantiate.nest01.QuartzManager;
import org.quartz.JobKey;
import org.quartz.TriggerKey;

import java.sql.SQLException;
import java.util.List;

/**
 * Author liao
 * C or U by 2016/6/7-23:00
 * sample
 */
public class Test {
    public static void main(String[] args) {
       new Test().addJobs();
    }
    public void addJobs(){
        JobKey oneJobKey=new JobKey("job1_11","jGroup1");
        TriggerKey triggerKey=new TriggerKey("trigger1", "tGroup1");
        QuartzManager.getInstance().deleteJob(oneJobKey);

        JobsDao jobsDao=new JobsDao();
        try {
            List<JobEntity> list=jobsDao.getJobs();
            for(JobEntity entity:list){
                QuartzManager.getInstance().addSchedule(Class.forName(entity.getClassName()) ,oneJobKey,triggerKey,entity.getCron());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
