package com.uioqv.base.entity;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author LiuGuoQing
 * @since 2018-11-06
 */
@Getter
@Setter
public class BaseDTO {
    private String          id;
    private LocalDateTime   dateCreate;
    private String          creator;
    private LocalDateTime   dateUpdate;
    private String          updater;
    private Boolean         isDelete;
}
