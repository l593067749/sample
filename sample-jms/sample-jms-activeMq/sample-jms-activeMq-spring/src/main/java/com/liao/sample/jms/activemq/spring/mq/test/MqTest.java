package com.liao.sample.jms.activemq.spring.mq.test;

import com.liao.sample.jms.activemq.spring.mq.producer.queue.QueueSender;
import com.liao.sample.jms.activemq.spring.mq.producer.topic.TopicSender;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author liao
 * C or U by 2016/6/13-23:54
 * sample
 */
public class MqTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        QueueSender queueSender= context.getBean("queueSender", QueueSender.class);
        queueSender.send("你好啊");

        TopicSender topicSender= context.getBean("topicSender", TopicSender.class);
        topicSender.send("test.topic","你好啊");

    }
}
