package com.yanbobo.demo.controller;

import com.yanbobo.demo.entity.Student;
import com.yanbobo.demo.service.StudentService;
import com.yanbobo.demo.servlet.configuration.StudentsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/15 15:11
 */
@Controller
public class HelloController {

/*    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;*/

    @Autowired
    private StudentsProperties studentsProperties;


    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(HttpServletRequest request) {
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        System.out.println("nishishui");
        return "Hello World" + studentsProperties.getName() + studentsProperties.getAge();
    }

    @RequestMapping("/hello2")
    public String sayHello2(HttpServletRequest request) {

        request.setAttribute("date","2019-03-22 15:07:00");
        return "index";
    }

    @Autowired
    private StudentService studentService;
    @RequestMapping("/students")
    @ResponseBody
    public List<Student> findStudentList(HttpServletRequest request){
        List<Student> students = studentService.selectStudentList();
        return students;
    }
}
