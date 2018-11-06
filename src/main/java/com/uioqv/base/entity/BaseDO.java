package com.uioqv.base.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

/**
 * @author LiuGuoQing
 * @since 2018-10-23
 */
@Getter
@Setter
public class BaseDO {
    @Id
    private String  id;
    private Date    dateCreate;
    private String  creator;
    private Date    dateUpdate;
    private String  updater;
    private Integer isDelete;
}
