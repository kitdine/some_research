/**
 * Project Name:test-rocketmq-client
 * File Name:UserServiceImpl.java
 * Package Name:org.jobshen.service.impl
 * Date:2015年7月6日下午3:53:26
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 *
*/

package org.jobshen.service.impl;

import org.jobshen.model.user.User;
import org.jobshen.persist.mapper.user.UserMapper;
import org.jobshen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * ClassName:UserServiceImpl
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * Date:     2015年7月6日 下午3:53:26
 * @author   <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserById(long id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public long insertUser(User user) {
        return userMapper.insertUser(user);
    }
    

}
