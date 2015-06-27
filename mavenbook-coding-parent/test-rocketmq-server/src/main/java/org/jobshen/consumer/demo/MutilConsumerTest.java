/**
 * Filename MutilConsumerTest.java Create on 2015年6月25日 Copyright 2015 ddsoucai All Rights Reserved.
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
 * Description:
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
public class MutilConsumerTest {

    public static final Logger logger = Logger.getLogger(MutilConsumerTest.class);

    public static void main(String[] args) {
        /**
         * 当前例子是PushConsumer用法， 使用方式给用户感觉是消息从RocketMQ服务器推到了应用客户端。 但是实际PushConsumer内部是使用长轮询Pull方式从RocketMQ服务器拉消息，
         * 然后再回调用户Listener方法
         */
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("ConsumerGroupName");
        consumer.setNamesrvAddr("192.168.3.71:9876");
        consumer.setInstanceName("Consumer");

        try {
            /**
             * 订阅指定topic PushTopic下tags分别等于push或pull
             */
            consumer.subscribe("PushTopic", "push || pull");
            
            /**
             * 订阅指定topic PullTopic下所有消息<br>
             * 注意：一个consumer对象可以订阅多个topic
             */
            consumer.subscribe("PullTopic", "*");
            
            /**
             * 程序第一次启动从消息队列头取数据
             */
            consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_FIRST_OFFSET);
            
            consumer.registerMessageListener(new MessageListenerConcurrently() {

                public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list,
                                                                ConsumeConcurrentlyContext Context) {
                    Message msg = list.get(0);
                    if(msg.getTopic().equals("PushTopic")) {
                        logger.info("messgeId:" + msg.getBuyerId() + ",message topic:" + msg.getTopic());
                        if(msg.getTags() == "push") {
                            logger.info("messgeId:" + msg.getBuyerId() + ",message topic:" + msg.getTopic());
                        } else if(msg.getTags().equals("PullTopic")) {
                            logger.info("messgeId:" + msg.getBuyerId() + ",message topic:" + msg.getTopic());
                        } else {
                            
                        }
                    } else if(msg.getTopic().equals("PullTopic")) {
                        logger.info("messgeId:" + msg.getBuyerId() + ",message topic:" + msg.getTopic());
                        logger.info("messgeId:" + msg.getBuyerId() + ",message topic:" + msg.getTopic());
                    }
                    if(logger.isEnabledFor(Level.INFO)) {
                        logger.info("messgeId:" + msg.getBuyerId() + ",message content:" + new String(msg.getBody()));
                        logger.info("message body:" + msg.toString());
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                }
            });
            consumer.start();
            
//            consumer.shutdown();
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.INFO)) {
                logger.info("something wrong when send mq!");
                logger.info(e.getMessage());
            }
        }
    }

}
