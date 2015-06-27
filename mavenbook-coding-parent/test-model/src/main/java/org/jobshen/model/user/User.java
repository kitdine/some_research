/**
 * Filename User.java Create on 2015年6月4日 Copyright 2015 ddsoucai All Rights Reserved.
 */
package org.jobshen.model.user;

import org.jobshen.common.hashcode.HashCodeUtil;
import org.jobshen.model.base.BaseEntity;

/**
 * Description:
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
public class User extends BaseEntity {

    private static final long serialVersionUID = 6206347086326365714L;
    
    public static Byte SEX_MALE   = 1;
    public static Byte SEX_FEMALE = 2;
    public static Byte SEX_OTHER  = 3;

    private String     name;
    private int        age;
    private long       mobile;
    private byte       sex;
    private long       workId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public byte getSex() {
        return sex;
    }

    public void setSex(byte sex) {
        this.sex = sex;
    }

    public long getWorkId() {
        return workId;
    }

    public void setWorkId(long workId) {
        this.workId = workId;
    }
    
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof User) {
            User user = (User)obj;
            return this.getName().equals(user.getName()) &&
                    Integer.valueOf(this.getAge()).equals(Integer.valueOf(user.getAge())) &&
                    Long.valueOf(this.getMobile()).equals(Long.valueOf(user.getMobile())) &&
                    Byte.valueOf(this.getSex()).equals(Byte.valueOf(user.getSex()));
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        int result = HashCodeUtil.SEED;
        result = HashCodeUtil.hash(result, this.getAge());
        result = HashCodeUtil.hash(result, this.getMobile());
        result = HashCodeUtil.hash(result, this.getName());
        result = HashCodeUtil.hash(result, this.getSex());
        return result;
    }

}
