/**
 * Project Name:test-rocketmq-client File Name:UserServiceTest.java Package Name:org.jobshen.test.services
 * Date:2015年7月6日下午3:55:22 Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 */

package org.jobshen.test.services;

import java.util.Date;

import org.jobshen.model.enums.Sex;
import org.jobshen.model.user.User;
import org.jobshen.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ClassName:UserServiceTest Function: TODO ADD FUNCTION. Reason: TODO ADD REASON. Date: 2015年7月6日 下午3:55:22
 * 
 * @author <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version
 * @since JDK 1.6
 * @see
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:/spring/smvc-mvc.xml")
public class UserServiceTest {

    @Autowired
    private UserService userService;
    
    @Test
    public void testSelectUserById() {
        User user = new User();
        user.setAge(25);
        user.setBirthday(new Date());
        user.setMobile("13738075717");
        user.setName("Job Shen");
        user.setSex(Sex.MALE);
        long id = userService.insertUser(user);
        System.out.println(userService.getUserById(id));
    }
}
