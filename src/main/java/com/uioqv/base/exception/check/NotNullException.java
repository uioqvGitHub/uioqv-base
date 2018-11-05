package com.uioqv.base.exception.check;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
public class NotNullException extends CheckException {

    public static final String DEFAULT_MESSAGE = "未通过空值检查";

    public NotNullException(Throwable cause) {
        super(DEFAULT_MESSAGE, cause);
    }

    public NotNullException() {
        super(DEFAULT_MESSAGE);
    }

    public NotNullException(String message) {
        super(message);
    }

    public NotNullException(String message, Throwable cause) {
        super(message, cause);
    }

}
