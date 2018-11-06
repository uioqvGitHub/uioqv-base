package com.uioqv.base.utils;

import com.uioqv.base.entity.Log;
import com.uioqv.base.exception.check.CheckException;
import org.apache.commons.lang3.StringUtils;


/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
public class Checks {
    private Log logger = new Log();
    private static final ThreadLocal<Checks> INSTANCE = new ThreadLocal<>();

    public static Checks init() {
        if(INSTANCE.get() == null) {
            INSTANCE.set(new Checks());
        }
        return INSTANCE.get();
    }

    public Checks data(Object data) {
        INSTANCE.get().logger.data(data);
        return INSTANCE.get();
    }
    public Checks message(String message) {
        INSTANCE.get().logger.message(message);
        return INSTANCE.get();
    }
    public Checks unique(String unique) {
        INSTANCE.get().logger.unique(unique);
        return INSTANCE.get();
    }




    private static Log exception(Object obj) {
        CheckException throwable = null;
        String message = INSTANCE.get().logger.getMessage();
        if(StringUtils.isBlank(message)) {
            throwable = new CheckException();
        } else {
            throwable = new CheckException(message);
        }
        throw throwable
                .logger()
                .unique(INSTANCE.get().logger.getUnique())
                .data(INSTANCE.get().logger.getData())
                .log();
    }

    /**
     * 断言对象不能为空
     * @param obj
     */
    public void isNotNull(Object obj) {
        if (obj != null) {
            return;
        }
        exception(obj);
    }

    /**
     * 断言字符串不为空
     * @param str
     */
    public void isNotBlank(String str) {
        if (StringUtils.isNotBlank(str)) {
            return;
        }
        exception(str);
    }

    /**
     * 断言真
     * @param bool
     */
    public void isTrue(boolean bool) {
        if (bool == true) {
            return;
        }
        exception(bool);
    }

    /**
     * 断言假
     */
    public void isFalse(boolean bool) {
       isTrue(!bool);
    }
}
