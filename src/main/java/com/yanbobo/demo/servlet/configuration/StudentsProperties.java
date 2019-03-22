package com.yanbobo.demo.servlet.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/15 17:28
 */
@Component
@PropertySource("classpath:application.yml")//指定配置文件
@ConfigurationProperties(prefix = "student")//表示获取前缀为 sutdent 的配置信息
public class StudentsProperties {

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
