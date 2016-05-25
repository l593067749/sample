package com.liao.sample.quartz.base.spring;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author liao
 * C or U by 2016/5/25-23:19
 * sample
 */

@Component
public class MySpringJob {
    @Scheduled(cron = "0/2 * * * * ?")
    public void work(){
        System.out.println("date:"+new Date());
    }
}
