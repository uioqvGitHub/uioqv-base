package com.uioqv.base.entity;


import com.google.gson.Gson;
import com.uioqv.base.utils.Checks;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author LiuGuoQing
 * @since 2018-11-05
 */
@Getter
@Slf4j
public  class Log<T> {

    private String unique;
    private Object data;
    private String message;
    private T obj;



    public Log(T obj) {
        this.obj = obj;
    }

    public Log() {

    }


    public Log<T> unique(String unique) {
        if(unique != null) {
            this.unique = unique;
        }
        return this;
    }

    public Log<T> data(Object data) {
        if(data != null) {
            this.data = data;
        }
        return this;
    }

    public Log<T> message(String message) {
        if(message != null) {
            this.message = message;
        }
        return this;
    }

    public T log() {
        Checks.init()
                .message("日志为null不可打印日志")
                .isNotNull(obj);
        String[] value = new String[3];
        int index = 0;
        String methodName = Thread.currentThread().getStackTrace()[2].getMethodName();
        StringBuilder error = new StringBuilder();
        error.append(obj.getClass().getName())
                .append('-')
                .append(methodName)
                .append(" message:{}");
        value[index++] = getMessage();
        if(getUnique() != null) {
            error.append(", id:{}");
            value[index++] = getUnique();
        }
        if(getData() != null) {
            error.append(", data:{}");
            value[index++] = new Gson().toJson(getData());
        }
        log.error(error.toString(), value);
        return obj;
    }

}
