/**
 * Filename MutliProducerTest.java Create on 2015年6月25日 Copyright 2015 ddsoucai All Rights Reserved.
 */
package org.jobshen.producers.demo;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.common.message.Message;

/**
 * Description:
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
public class MutliProducerTest {

    public static final Logger logger = Logger.getLogger(MutliProducerTest.class);

    public static void main(String[] args) {
        /**
         * 一个应用创建一个Producer，由应用来维护此对象，可以设置为全局对象或者单例 注意：ProducerGroupName需要由应用来保证唯一
         * ProducerGroup这个概念发送普通的消息时，作用不大，但是发送分布式事务消息时，比较关键， 因为服务器会回查这个Group下的任意一个Producer
         */
        DefaultMQProducer producer = new DefaultMQProducer("ProducerGroupName");
        producer.setNamesrvAddr("192.168.3.71:9876");
        producer.setInstanceName("Producer");

        try {
            /**
             * Producer对象在使用之前必须要调用start初始化，初始化一次即可<br>
             * 注意：切记不可以在每次发送消息时，都调用start方法
             */
            producer.start();

            Message msg = new Message("PushTopic",              // topic
                                      "push",                   // tag
                                      "1",                      // key
                                      "Just a test.".getBytes() // body
            );
            SendResult result = producer.send(msg);
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }

            msg = new Message("PushTopic", "pull", "2", "Just a test.".getBytes());
            result = producer.send(msg);
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }

            msg = new Message("PullTopic", "push", "3", "Just a test.".getBytes());
            result = producer.send(msg);
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("id:" + result.getMsgId() + ",result:" + result.getSendStatus());
            }
            
            /**
             * 应用退出时，要调用shutdown来清理资源，关闭网络连接，从MetaQ服务器上注销自己
             * 注意：我们建议应用在JBOSS、Tomcat等容器的退出钩子里调用shutdown方法
             */
//            producer.shutdown();
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("something wrong when send mq!");
                logger.info(e.getMessage());
            }
        }
    }

}
