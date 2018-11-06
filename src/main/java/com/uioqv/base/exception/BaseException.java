package com.uioqv.base.exception;

import com.google.gson.Gson;
import com.uioqv.base.entity.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
@Slf4j
public class BaseException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "系统错误";

    private final Log<BaseException> logger;

    public BaseException(Throwable cause) {
        this(DEFAULT_MESSAGE, cause);
    }

    public BaseException() {
        this(DEFAULT_MESSAGE, null);
    }

    public BaseException(String message) {
        this(message, null);
    }

    public BaseException(String message, Throwable cause) {
        super(message, cause);
        logger = new Log<>(this)
                .message(this.getMessage());
    }

    public Log<BaseException> logger() {
        return logger;
    }










}
