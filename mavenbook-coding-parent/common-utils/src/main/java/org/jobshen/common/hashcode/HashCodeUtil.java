/**
 * Filename HashCodeUtil.java Create on 2015年6月4日 Copyright 2015 jobshen All Rights Reserved.
 */
package org.jobshen.common.hashcode;

import java.lang.reflect.Array;

import org.apache.log4j.Logger;

/**
 * Description: 计算hashcode()工具类
 * 
 * @author <a href="mailto:jobshen@outlook.com">Job Shen</a>
 * @since version1.0
 */
public final class HashCodeUtil {

    public static Logger     logger            = Logger.getLogger(HashCodeUtil.class);

    public static final int  SEED              = 25;                                  // 基数

    private static final int FOOD_PRIME_NUMBER = 98;                                  // 权重

    /**
     * boolean
     * 
     * @param aSeed
     * @param aBoolean
     * @return
     */
    public static int hash(int aSeed, boolean aBoolean) {
        if (logger.isInfoEnabled()) {
            logger.info("boolean's hash");
        }
        return firstTerm(aSeed) + (aBoolean ? 1 : 0);
    }

    /**
     * char
     * 
     * @param aSeed
     * @param aChar
     * @return
     */
    public static int hash(int aSeed, char aChar) {
        if (logger.isInfoEnabled()) {
            logger.info("char's hash");
        }
        return firstTerm(aSeed) + (int) aChar;
    }

    /**
     * int
     * 
     * @param aSeed
     * @param aInt
     * @return
     */
    public static int hash(int aSeed, int aInt) {
        if (logger.isInfoEnabled()) {
            logger.info("int's hash");
        }
        return firstTerm(aSeed) + aInt;
    }

    /**
     * long
     * 
     * @param aSeed
     * @param aLong
     * @return
     */
    public static int hash(int aSeed, long aLong) {
        if (logger.isInfoEnabled()) {
            logger.info("long's hash");
        }
        return firstTerm(aSeed) + (int) (aLong ^ (aLong >>> 32));
    }

    /**
     * float
     * 
     * @param aSeed
     * @param aFloat
     * @return
     */
    public static int hash(int aSeed, float aFloat) {
        if (logger.isInfoEnabled()) {
            logger.info("float's hash");
        }
        return hash(aSeed, Float.floatToIntBits(aFloat));
    }

    /**
     * double
     * 
     * @param aSeed
     * @param aDouble
     * @return
     */
    public static int hash(int aSeed, double aDouble) {
        if (logger.isInfoEnabled()) {
            logger.info("double's hash");
        }
        return hash(aSeed, Double.doubleToLongBits(aDouble));
    }

    /**
     * object
     * @param aSeed
     * @param aObject
     * @return
     */
    public static int hash(int aSeed, Object aObject) {
        if (logger.isInfoEnabled()) {
            logger.info("double's hash");
        }
        int result = aSeed;
        if (aObject == null) {
            result = hash(result, 0);
        } else if (!isArray(aObject)) {
            result = hash(result, aObject.hashCode());
        } else {
            int length = Array.getLength(aObject);
            for (int idx = 0; idx < length; ++idx) {
                Object item = Array.get(aObject, idx);
                if (!(item == aObject))
                result = hash(result, item);
            }
        }
        return result;
    }

    private static int firstTerm(int aSeed) {
        return FOOD_PRIME_NUMBER * aSeed;
    }

    private static boolean isArray(Object aObject) {
        return aObject.getClass().isArray();
    }
}
