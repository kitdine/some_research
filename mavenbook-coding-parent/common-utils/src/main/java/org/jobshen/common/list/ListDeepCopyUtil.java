/** 
 * Filename ListDeepCopyUtil.java
 * Create on 2015年6月3日
 * Copyright 2015 jobshen All Rights Reserved.
 */
package org.jobshen.common.list;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

import org.apache.log4j.Logger;


/**
 * Description: List类型深层复制
 * 
 * @author <a href="mailto:jobshen@outlook.com">Job Shen</a>
 * @since version1.0
 */
public class ListDeepCopyUtil {
    
    public static Logger logger = Logger.getLogger(ListDeepCopyUtil.class);

    /**
     * 将一个list的数据复制到另一个list，两个list无任何相关性
     * @param src 源list
     * @return
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static <T> List<T> deepCopy(List<T> src) {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        try {
            ObjectOutputStream out = new ObjectOutputStream(byteOut);
            out.writeObject(src);
            
            ObjectInputStream in = new ObjectInputStream(byteIn);
            List<T> dest = (List<T>) in.readObject();
            return dest;
        } catch (IOException ioe) {
            if(logger.isDebugEnabled()) {
                logger.debug(ioe.getStackTrace());
            }
        } catch (ClassNotFoundException cnfe) {
            if(logger.isDebugEnabled()) {
                logger.debug(cnfe.getStackTrace());
            }
        }
        return null;
    }

    public static Object deepCopyObj(Object src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        try {
            out.writeObject(src);
            
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream in = new ObjectInputStream(byteIn);
            @SuppressWarnings("unchecked")
            Object dest = in.readObject();
            return dest;
        } catch (IOException ioe) {
            if(logger.isDebugEnabled()) {
                logger.debug(ioe.getStackTrace());
            }
        } catch (ClassNotFoundException cnfe) {
            if(logger.isDebugEnabled()) {
                logger.debug(cnfe.getStackTrace());
            }
        }
        return null;
    }
}
