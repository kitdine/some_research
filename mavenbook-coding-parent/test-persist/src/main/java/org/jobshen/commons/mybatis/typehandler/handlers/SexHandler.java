/**
 * Project Name:test-persist
 * File Name:SexHandler.java
 * Package Name:org.jobshen.commons.mybatis.typehandler
 * Date:2015年7月7日下午2:15:38
 * Copyright (c) 2015, kitdnie@gmail.com All Rights Reserved.
 *
*/

package org.jobshen.commons.mybatis.typehandler.handlers;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;
import org.jobshen.commons.mybatis.typehandler.basic.GenericEnumNameHandler;
import org.jobshen.model.enums.Sex;

/**
 * ClassName:SexHandler
 * Function: TODO ADD FUNCTION.
 * Reason:	 TODO ADD REASON.
 * Date:     2015年7月7日 下午2:15:38
 * @author   <a href="mailto:kitdnie@gmail.com">shencb</a>
 * @version  
 * @since    JDK 1.6
 * @see 	 
 */

@MappedJdbcTypes(value = { JdbcType.VARCHAR })
@MappedTypes(value = Sex.class)
public class SexHandler extends GenericEnumNameHandler<Sex>{

    public SexHandler(Class<Sex> type){
        super(type);
    }

}
