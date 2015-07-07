/**
 * Project Name:test-rocketmq-client File Name:BaseController.java Package Name:org.jobshen.controllers.base
 * Date:2015年7月7日下午5:30:14 Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 */

package org.jobshen.controllers.base;

import org.apache.log4j.Logger;
import org.jobshen.model.enums.ResultCode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * ClassName:BaseController Function: TODO ADD FUNCTION. Reason: TODO ADD REASON. Date: 2015年7月7日 下午5:30:14
 * 
 * @author <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version
 * @since JDK 1.6
 * @see
 */
public class BaseController {

    protected static final Logger logger = Logger.getLogger(BaseController.class);

    protected static SerializerFeature[] features = { SerializerFeature.WriteNullNumberAsZero,
                                                      SerializerFeature.WriteNullStringAsEmpty,
                                                      SerializerFeature.DisableCircularReferenceDetect,
                                                      SerializerFeature.WriteEnumUsingToString};

    protected static void getResultJson(JSONObject json, ResultCode resultCode) {
        json.put("returnCode", resultCode.getCode());
        json.put("returnMsg", resultCode.getName());
    }
}
