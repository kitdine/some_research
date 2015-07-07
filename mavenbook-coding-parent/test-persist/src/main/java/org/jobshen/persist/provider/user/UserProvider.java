package org.jobshen.persist.provider.user;

import org.apache.ibatis.jdbc.SQL;
import org.jobshen.model.user.User;

public class UserProvider {

    public String insertUser(final User user) {
        return new SQL() {

            {
                INSERT_INTO("user");
                if (user.getAge() != null) {
                    VALUES("age", "#{age}");
                }
                if (user.getBirthday() != null) {
                    VALUES("birthday", "#{birthday}");
                }
                if (user.getMobile() != null) {
                    VALUES("mobile", "#{mobile}");
                }
                if (user.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (user.getRemark() != null) {
                    VALUES("remark", "#{remark}");
                }
                if (user.getSex() != null) {
                    VALUES("sex", "#{sex, typeHandler=org.jobshen.commons.mybatis.typehandler.handlers.SexHandler}");
                }
            }
        }.toString();
    }

    public String selectUserById() {
        return new SQL() {

            {
                SELECT("id, name, age, sex, birthday, mobile, remark");
                FROM("user");
                WHERE("id = #{id}");
            }

        }.toString();
    }

}
