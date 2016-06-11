package com.liao.sample.jms.activemq.pubsub;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.MessageConsumer;
import javax.jms.Session;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消息【订阅者1】
 *
 * @author wangzhipeng
 *
 */
public class JMSConsumer {
	private static final String USERNAME = ActiveMQConnection.DEFAULT_USER; // 默认的连接用户名
	private static final String PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD; // 默认的连接密码
	private static final String BROKEURL = ActiveMQConnection.DEFAULT_BROKER_URL; // 默认的连接地址

	public static void main(String[] args) {
		ConnectionFactory connectionFactory; // 连接工厂
		Connection connection = null; // 连接
		Session session; // 会话 接受或者发送消息的线程
		Destination destination; // 消息的目的地
		MessageConsumer messageConsumer;// 消息消费者

		// 实例化连接工厂
		connectionFactory = new ActiveMQConnectionFactory(JMSConsumer.USERNAME, JMSConsumer.PASSWORD, JMSConsumer.BROKEURL);

		try {
			connection = connectionFactory.createConnection();// 通过工厂获取连接
			connection.start();// 启动连接
			session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);// 第一个参数为是否开启事务
			// destination = session.createQueue("FirstQueue1");// 创建消息队列
			destination = session.createTopic("FirstTopic");// 创建消息主题
			messageConsumer = session.createConsumer(destination);// 创建消息消费者
			/*
			 * 注册一个监听
			 */
			messageConsumer.setMessageListener(new Listener());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
