package com.uioqv.base.exception;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
@Slf4j
public class BaseException extends RuntimeException {
    public static final String DEFAULT_MESSAGE = "系统错误";

    private final Log logger = new Log();

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
    }

    public Log logger() {
        return logger;
    }

    public class Log {

        private String unique;
        private Object data;

        public Log unique(String unique) {
            this.unique = unique;
            return this;
        }

        public Log data(Object data) {
            this.data = data;
            return this;
        }

        public BaseException log() {
            String error = "Exception message:{}";
            if(unique != null) {
                error.concat(", id:{}");
            }
            String json = null;
            if(data != null) {
                error.concat(", data:{}");
                json = new Gson().toJson(data);
            }
            log.error(error, getMessage(), unique, json);
            return BaseException.this;
        }
    }









}
