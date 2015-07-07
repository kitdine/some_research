/**
 * Project Name:test-rocketmq-client
 * File Name:ProducerSendUtils.java
 * Package Name:org.jobshen.producers.utils
 * Date:2015年7月7日下午4:08:16
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 *
*/

package org.jobshen.producers.utils;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.jobshen.model.user.User;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.rocketmq.client.producer.DefaultMQProducer;
import com.alibaba.rocketmq.client.producer.SendResult;
import com.alibaba.rocketmq.client.producer.SendStatus;
import com.alibaba.rocketmq.common.message.Message;

/**
 * ClassName:ProducerSendUtils
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * Date:     2015年7月7日 下午4:08:16
 * @author   <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public class ProducerSendUtils {

   private static final Logger logger = Logger.getLogger(ProducerSendUtils.class);
    
    @Autowired
    private static DefaultMQProducer mutliProducer;
    
    public static void sendAddUser(User user) {
        Message msg = new Message("addUser",              // topic
                                  "insert",                   // tag
                                  user.hashCode()+"",                      // key
                                  user.objectToBytes() // body
        );
        send(msg);
    }
    
    private static void send(Message msg) {
        try {
            mutliProducer.send(msg);
        } catch (Exception e) {
            if(logger.isEnabledFor(Level.ERROR)) {
                logger.error("send message has failed!");
                logger.error(e.getMessage());
            }
        }
    }
}
