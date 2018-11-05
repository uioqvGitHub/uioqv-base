package com.uioqv.base.exception.check;

import com.uioqv.base.exception.BaseException;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
public class CheckException extends BaseException {
    public static final String DEFAULT_MESSAGE = "未通过检查";

    public CheckException(Throwable cause) {
        this(DEFAULT_MESSAGE, cause);
    }

    public CheckException() {
        this(DEFAULT_MESSAGE, null);
    }

    public CheckException(String message) {
        this(message, null);
    }

    public CheckException(String message, Throwable cause) {
        super(message, cause);
    }
}
