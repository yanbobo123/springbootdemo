package com.yanbobo.demo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/22 17:00
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = -5999074188921335406L;

    private Integer age;

    private String name;

}
