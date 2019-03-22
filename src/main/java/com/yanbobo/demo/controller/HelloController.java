package com.yanbobo.demo.controller;

import com.yanbobo.demo.servlet.configuration.StudentsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/15 15:11
 */
@RestController()
public class HelloController {

/*    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;*/

    @Autowired
    private StudentsProperties studentsProperties;


    @RequestMapping("/hello.action")
    public String sayHello(HttpServletRequest request) {
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        return "Hello World" + studentsProperties.getName() + studentsProperties.getAge();
    }

}
