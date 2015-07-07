/**
 * Project Name:test-rocketmq-client File Name:UserTest.java Package Name:org.jobshen.test.model Date:2015年7月7日下午4:55:54
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 */

package org.jobshen.test.model;

import java.util.Date;

import org.jobshen.model.enums.Sex;
import org.jobshen.model.user.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * ClassName:UserTest Function: TODO ADD FUNCTION. Reason: TODO ADD REASON. Date: 2015年7月7日 下午4:55:54
 * 
 * @author <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version
 * @since JDK 1.6
 * @see
 */

@RunWith(JUnit4.class)
public class UserTest {

    @Test
    public void userTest() {
        User user = new User();
        user.setAge(25);
        user.setBirthday(new Date());
        user.setMobile("13738075717");
        user.setName("Job Shen");
        user.setSex(Sex.MALE);
        byte[] bytes = user.objectToBytes();
        Object obj = User.bytesToObject(bytes);
        if(obj instanceof User) {
            User u = (User)obj;
            System.out.println(u);
        }
    }
}
