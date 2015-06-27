/** 
 * Filename DefaultProducerTest.java
 * Create on 2015年6月23日
 * Copyright 2015 ddsoucai All Rights Reserved.
 */
package org.jobshen.producers.demo;


import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;


/**
 * Description: 创建一个简单Producer
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
public class DefaultProducerTest {
    
    public static final Logger logger = Logger.getLogger(DefaultProducerTest.class);
    
    public static void main(String[] args) {
        DefaultMQProducer producer = new DefaultMQProducer("Producer");
        producer.setNamesrvAddr("192.168.3.71:9876");
        
        try {
            producer.start();
            
            Message msg = new Message("PushTopic","push","1","Just a test.".getBytes());
            SendResult result = producer.send(msg);
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }
            
            msg = new Message("PushTopic","push","2","Just a test.".getBytes());
            result = producer.send(msg);
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }
            
            msg = new Message("PushTopic","push","3","Just a test.".getBytes());
            result = producer.send(msg);
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }
        } catch (Exception e) {
            if(logger.isEnabledFor(Level.INFO)) {
                logger.info("something wrong when send mq!");
                logger.info(e.getMessage());
            }
        }
    }
}
