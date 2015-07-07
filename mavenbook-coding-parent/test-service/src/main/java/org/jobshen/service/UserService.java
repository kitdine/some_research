/**
 * Project Name:test-rocketmq-client
 * File Name:UserService.java
 * Package Name:org.jobshen.service
 * Date:2015年7月6日下午3:50:13
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 *
*/

package org.jobshen.service;

import java.util.List;

import org.jobshen.model.user.User;

/**
 * ClassName:UserService
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * Date:     2015年7月6日 下午3:50:13
 * @author   <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public interface UserService {
    
    User getUserById(long id);
    
    long insertUser(User user);
    
    List<User> getUsers();

}
