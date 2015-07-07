/**
 * Project Name:test-model
 * File Name:ResultCode.java
 * Package Name:org.jobshen.model.enums
 * Date:2015年7月7日下午5:33:59
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 *
*/

package org.jobshen.model.enums;

import java.io.Serializable;

import org.apache.commons.lang3.StringUtils;
import org.jobshen.common.interfaces.GenericEnum;

/**
 * ClassName:ResultCode
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * Date:     2015年7月7日 下午5:33:59
 * @author   <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */
public enum ResultCode implements GenericEnum, Serializable{

    SUCCESS(0, "success"), FAILURE(1, "failure");
    
    private int code;  
    
    private String name;
    
    private ResultCode(int _code, String _name) {
        this.code = _code;
        this.name = _name;
    }
    
    @Override
    public int getCode() {
        return this.code;
    }

    @Override
    public String getName() {
        return this.name;
    }
    
    public static ResultCode valueOfEnumByCode(int _code) {
        ResultCode[] ss = values();  
        for (ResultCode cs : ss) {  
            if (cs.getCode() == _code) {  
                return cs;  
            }  
        }  
        return null;  
    }
    
    public static ResultCode valueOfEnumByName(String _name) {
        ResultCode[] ss = values(); 
        if(StringUtils.isNotBlank(_name)) {
            for (ResultCode cs : ss) {  
                if (_name.equals(cs.getName())) {  
                    return cs;  
                }  
            }  
        }
        return null;  
    }
}
