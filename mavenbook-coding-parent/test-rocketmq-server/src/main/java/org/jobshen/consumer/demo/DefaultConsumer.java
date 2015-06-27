/**
 * Filename DefaultConsumer.java Create on 2015年6月23日 Copyright 2015 ddsoucai All Rights Reserved.
 */
package org.jobshen.consumer.demo;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.alibaba.rocketmq.client.consumer.DefaultMQPushConsumer;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import com.alibaba.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import com.alibaba.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import com.alibaba.rocketmq.common.consumer.ConsumeFromWhere;
import com.alibaba.rocketmq.common.message.Message;
import com.alibaba.rocketmq.common.message.MessageExt;

/**
 * Description: 简单Consumer
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
public class DefaultConsumer {

    public static final Logger logger = Logger.getLogger(DefaultConsumer.class);

    public static void main(String[] args) {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("PushConsumer");
        consumer.setNamesrvAddr("192.168.3.71:9876");

        try {
            // 订阅PushTopic下Tag为push的消息
            consumer.subscribe("PushTopic", "push");
            // 程序第一次启动从消息队列头取数据
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                                ConsumeConcurrentlyContext Context) {
                    Message msg = list.get(0);
                    System.out.println(msg.toString());
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("something wrong when send mq!");
                logger.info(e.getMessage());
            }
        }
    }
}
