package com.liao.sample.quartz.base.instantiate.nest03;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Author liao
 * C or U by 2016/6/7-22:48
 * sample
 */
public class JobsDao {
    public List<JobEntity> getJobs() throws SQLException {
        List<JobEntity> jobs=new ArrayList<JobEntity>();
        String sql="select id,className,cron from qrtz_jobs";
        Connection connection= DBUtils.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ps= connection.prepareStatement(sql);
        rs= ps.executeQuery();
        while (rs.next()){
            JobEntity entity=new JobEntity();
            Integer id= rs.getInt("id");
            String className=rs.getString("className");
            String cron=rs.getString("cron");
            entity.setClassName(className);
            entity.setId(id);
            entity.setCron(cron);
            jobs.add(entity);
        }
        DBUtils.closeResources(connection,ps,rs);
        return jobs;
    }
}
