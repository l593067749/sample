package com.liao.sample.jms.activemq.p2p;

import javax.jms.JMSException;
import javax.jms.Message;  
import javax.jms.MessageListener;  
import javax.jms.TextMessage;  
  
/** 
 * 消息监听 
 *  
 * @author zhipeng 
 *  
 */  
public class Listener implements MessageListener {  
  
    @Override  
    public void onMessage(Message message) {  
        // TODO Auto-generated method stub  
        try {  
            System.out.println("[监听]-收到的消息：" + ((TextMessage) message).getText());
        } catch (JMSException e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
    }  
  
}  