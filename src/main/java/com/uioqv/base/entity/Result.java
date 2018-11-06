package com.uioqv.base.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author LiuGuoQing
 * @since 2018-10-25
 */
@Getter
@Setter
@ToString
public class Result<T> {
    private int     status;
    private String  message;
    private T       data;

    public static final int ERROR_CODE = 500;
    public static final int SUCCESS_CODE = 200;
    public static final String SUCCESS_MESSAGE = "成功";




    public static <R> Result<R> success(R data) {
        Result<R> result = new Result<R>();
        result.setStatus(SUCCESS_CODE);
        result.setData(data);
        result.setMessage(SUCCESS_MESSAGE);
        return result;
    }

    public static Result<Void> failure(String message) {
        Result<Void> result = new Result<Void>();
        result.setMessage(message);
        result.setStatus(ERROR_CODE);
        return result;
    }

}
