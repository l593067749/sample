package com.liao.sample.jms.activemq.p2p.next;

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more contributor license agreements. See the NOTICE
 * file distributed with this work for additional information regarding copyright ownership. The ASF licenses this file
 * to You under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0 Unless required by
 * applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
import org.apache.activemq.ActiveMQConnectionFactory;
import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TemporaryQueue;

/**
 * The Retailer orders computers from the Vendor by sending a message via
 * the VendorOrderQueue. It then syncronously receives the reponse message
 * and reports if the order was successful or not.
 */
public class Retailer implements Runnable
{
  private String url;
  private String user;
  private String password;

  public Retailer(String url, String user, String password)
  {
    this.url = url;
    this.user = user;
    this.password = password;
  }

  /**
   * Retailer没有使用事务.该类向VendorOrderQueue队列发送Map类型的订单消息.
   并创建了一个临时消息目的地用来接收Vendor类处理VendorOrderQueue队列中
   订单消息之后发送的反馈.
   发送5个订单之后,发送一个空消息来结束当前线程.
   当一个订单消息发送之后,Retailer类使用replyConsumer.receive();方法同步接收
   Vendor的反馈,当订单正常处理完成后,Vendor类发送反馈给Retailer,Retailer收到
   反馈后,才发送下一个订单消息.
   */
  public void run()
  {
    ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
    try
    {
      Connection connection = connectionFactory.createConnection();

      // The Retailer's session is non-trasacted.
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
      Destination vendorOrderQueue = session.createQueue("VendorOrderQueue");
      TemporaryQueue retailerConfirmQueue = session.createTemporaryQueue();

      MessageProducer producer = session.createProducer(vendorOrderQueue);
      MessageConsumer replyConsumer = session.createConsumer(retailerConfirmQueue);

      connection.start();

      for (int i = 0; i < 5; i++)
      {
        //System.out.println("预定: " + i);
        
        MapMessage message = session.createMapMessage();
        message.setString("Item", "Computer(s)");
        int quantity = (int) (Math.random() * 4) + 1;
        message.setInt("Quantity", quantity);
        message.setJMSReplyTo(retailerConfirmQueue);
        producer.send(message);
        System.out.println("Retailer: Ordered " + quantity + " computers.");

        MapMessage reply = (MapMessage) replyConsumer.receive();
        if (reply.getBoolean("OrderAccepted"))
        {
          System.out.println("Retailer: Order Filled");
        }
        else
        {
          System.out.println("Retailer: Order Not Filled");
        }
      }

      // Send a non-MapMessage to signal the end
      producer.send(session.createMessage());

      replyConsumer.close();
      connection.close();

    }
    catch (JMSException e)
    {
      e.printStackTrace();
    }
  }

  public static void main(String[] args)
  {
    String url = "tcp://localhost:61616";
    String user = null;
    String password = null;

    if (args.length >= 1)
    {
      url = args[0];
    }

    if (args.length >= 2)
    {
      user = args[1];
    }

    if (args.length >= 3)
    {
      password = args[2];
    }

    Retailer r = new Retailer(url, user, password);

    new Thread(r, "Retailer").start();
  }
}