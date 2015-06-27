/** 
 * Filename Base.java
 * Create on 2015年6月4日
 * Copyright 2015 jobshen All Rights Reserved.
 */
package org.jobshen.model.base;

import java.io.Serializable;


/**
 * Description: 基础类
 * 
 * @author <a href="mailto:jobshen@outlook.com">Job Shen</a>
 * @since version1.0
 */
public class BaseEntity implements Serializable{

    private static final long serialVersionUID = 6032571339544077700L;

    private long id;
    private String remark;
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    
    public String getRemark() {
        return remark;
    }
    
    public void setRemark(String remark) {
        this.remark = remark;
    }
    
}
