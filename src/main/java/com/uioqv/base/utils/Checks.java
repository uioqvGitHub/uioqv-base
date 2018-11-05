package com.uioqv.base.utils;

import com.uioqv.base.exception.check.NotNullException;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
public class Checks {
    /**
     * 断言对象不能为空
     * @param obj
     */
    public static void isNotNull(Object obj) {
        if (obj == null) {
            throw new NotNullException()
                    .logger()
                    .log();
        }
    }
}
