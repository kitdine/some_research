/**
 * Filename Base.java Create on 2015年6月4日 Copyright 2015 jobshen All Rights Reserved.
 */
package org.jobshen.model.base;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

/**
 * Description: 基础类
 * 
 * @author <a href="mailto:jobshen@outlook.com">Job Shen</a>
 * @since version1.0
 */
public class BaseEntity<T> implements Serializable {

    private static final Logger logger = Logger.getLogger(BaseEntity.class);

    private long   id;
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

    public byte[] objectToBytes() {
        byte[] bytes;
        try {
            // object to bytearray
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(this);

            bytes = bo.toByteArray();

            bo.close();
            oo.close();
            return (bytes);
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.ERROR)) {
                logger.error("Serialize the object to bytes failed!");
                logger.error(e.getMessage());
            }
        }
        return new byte[1024];
    }

    public static Object bytesToObject(byte[] bytes) {
        Object obj = new Object();
        try {
            // bytearray to object
            ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
            ObjectInputStream oi = new ObjectInputStream(bi);

            obj = oi.readObject();

            bi.close();
            oi.close();
        } catch (Exception e) {
            if (logger.isEnabledFor(Level.ERROR)) {
                logger.error("Serialize the object to bytes failed!");
                logger.error(e.getMessage());
            }
        }
        return obj;
    }

}
