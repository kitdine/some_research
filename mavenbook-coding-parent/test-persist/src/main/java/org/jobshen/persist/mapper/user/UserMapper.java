package org.jobshen.persist.mapper.user;

import java.util.List;

import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.jobshen.model.user.User;
import org.jobshen.persist.provider.user.UserProvider;

public interface UserMapper {

	@InsertProvider(type=UserProvider.class,method="insertUser")
	@Options(useGeneratedKeys=true,keyProperty="id")
	@SelectKey(statement="SELECT LAST_INSERT_ID() AS ID", keyProperty="id", before=false, resultType=long.class)
	long insertUser(User user);
	
	@SelectProvider(type=UserProvider.class,method="selectUserById")
	@Results({
        @Result(id=true, column="id", property="id"),
        @Result(column="name", property="name"),
        @Result(column="age", property="age"),
        @Result(column="birthday", property="birthday"),
        @Result(column="mobile", property="mobile"),
        @Result(column="remark", property="remark"),
        @Result(column="sex", property="sex", typeHandler=org.jobshen.commons.mybatis.typehandler.handlers.SexHandler.class)
     })
	User selectUserById(long id);
	
	@SelectProvider(type=UserProvider.class,method="selectUsers")
	@Results({
        @Result(id=true, column="id", property="id"),
        @Result(column="name", property="name"),
        @Result(column="age", property="age"),
        @Result(column="birthday", property="birthday"),
        @Result(column="mobile", property="mobile"),
        @Result(column="remark", property="remark"),
        @Result(column="sex", property="sex", typeHandler=org.jobshen.commons.mybatis.typehandler.handlers.SexHandler.class)
     })
	List<User> selectUsers();
	
}
