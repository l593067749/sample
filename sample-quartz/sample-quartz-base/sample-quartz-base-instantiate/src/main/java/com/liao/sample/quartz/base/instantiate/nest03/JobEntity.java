package com.liao.sample.quartz.base.instantiate.nest03;

/**
 * Author liao
 * C or U by 2016/6/7-22:54
 * sample
 */

/*
CREATE TABLE `qrtz_jobs` (
        `id` int(11) NOT NULL AUTO_INCREMENT,
        `className` varchar(200) DEFAULT NULL,
        `cron` varchar(255) DEFAULT NULL,
        PRIMARY KEY (`id`)
        ) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
*/

public class JobEntity {
    private Integer id;
    private String className;
    private String cron;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getCron() {
        return cron;
    }

    public void setCron(String cron) {
        this.cron = cron;
    }
}
