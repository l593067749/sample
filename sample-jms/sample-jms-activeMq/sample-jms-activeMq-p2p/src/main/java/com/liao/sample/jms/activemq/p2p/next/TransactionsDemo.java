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
public class TransactionsDemo
{
/**
 * 說明
 * http://jackyin5918.iteye.com/blog/2012323?utm_source=tuicool&utm_medium=referral
 */

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
    /**
     * 该示例程序模拟了一个电脑采购的过程:零售商(Retailer)向中间商(Vendor)下订单订购电脑,中间商收到订单后,
     * 向供应商(Supplier)订购电脑配件(存储硬件和显示器).
     */
    Retailer r = new Retailer(url, user, password);
    Vendor v = new Vendor(url, user, password);
    Supplier s1 = new Supplier("HardDrive", "StorageOrderQueue", url, user, password);
    Supplier s2 = new Supplier("Monitor", "MonitorOrderQueue", url, user, password);

    new Thread(r, "Retailer").start();
    new Thread(v, "Vendor").start();
    new Thread(s1, "Supplier 1").start();
    new Thread(s2, "Supplier 2").start();
  }

}