/**
 * Project Name:test-rocketmq-client File Name:InsertUserController.java Package Name:org.jobshen.controllers
 * Date:2015年7月7日下午5:04:31 Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 */

package org.jobshen.controllers;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Level;
import org.jobshen.controllers.base.BaseController;
import org.jobshen.model.enums.ResultCode;
import org.jobshen.model.enums.Sex;
import org.jobshen.model.user.User;
import org.jobshen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * ClassName:InsertUserController Function: TODO ADD FUNCTION. Reason: TODO ADD REASON. Date: 2015年7月7日 下午5:04:31
 * 
 * @author <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version
 * @since JDK 1.6
 * @see
 */
@Controller
public class InsertUserController extends BaseController {

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = "/result", method = RequestMethod.POST)
    public @ResponseBody JSONObject returnJsonData() {
        JSONObject result = new JSONObject();
        List<User> list = userService.getUsers();
        result.put("list", list);
        getResultJson(result, ResultCode.SUCCESS);
        return result;
    }

    @RequestMapping(value = "/insertUser", method = RequestMethod.POST)
    public @ResponseBody JSONObject insertUser(String name, Integer age,
                                               @DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday, String mobile,
                                               String sex) {
        JSONObject result = new JSONObject();
        User user = new User();
        user.setAge(age);
        user.setBirthday(birthday);
        user.setMobile(mobile);
        user.setName(name);
        user.setSex(Sex.valueOfEnumByName(sex));
        try {
            long id = userService.insertUser(user);
            result.put("userid", user.getId());
            getResultJson(result, ResultCode.SUCCESS);
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.ERROR)) {
                logger.error("insert failure!");
                logger.error(e.getMessage());
            }
            getResultJson(result, ResultCode.FAILURE);
        }
        return result;
    }
}
