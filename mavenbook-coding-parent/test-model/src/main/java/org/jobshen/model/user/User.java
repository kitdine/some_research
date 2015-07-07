/**
 * Filename User.java Create on 2015年6月4日 Copyright 2015 ddsoucai All Rights Reserved.
 */
package org.jobshen.model.user;

import java.util.Date;

import org.apache.ibatis.type.Alias;
import org.jobshen.common.hashcode.HashCodeUtil;
import org.jobshen.model.base.BaseEntity;
import org.jobshen.model.enums.Sex;

/**
 * Description:用户信息类
 * 
 * @author <a href="mailto:shenchenbo@ddsoucai.cn">Job Shen</a>
 * @since version1.0
 */
@Alias("User")
public class User extends BaseEntity<User> {

    private static final long serialVersionUID = 6206347086326365714L;

    private String  name;
    private Sex     sex;
    private Integer age;
    private String  mobile;
    private Date    birthday;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof User) {
            User user = (User) obj;
            return this.getName().equals(user.getName())
                   && Integer.valueOf(this.getAge()).equals(Integer.valueOf(user.getAge()))
                   && this.getMobile().equals(user.getMobile())
                   && this.getSex().getName().equals(user.getSex().getName())
                   && this.getBirthday().equals(this.getBirthday());
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
        result = HashCodeUtil.hash(result, this.getBirthday());
        return result;
    }
    
    @Override
    public String toString() {
        return new StringBuffer().append("User--name:").append(this.getName()).append(", sex:")
                .append(this.getSex().getName()).append(", age:").append(this.getAge())
                .append(", mobile:").append(this.getMobile()).append(", birthday:").append(this.getBirthday().toString()).toString();
    }

}
