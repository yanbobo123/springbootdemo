package com.yanbobo.demo.controller;

import com.yanbobo.demo.entity.Student;
import com.yanbobo.demo.service.StudentService;
import com.yanbobo.demo.servlet.configuration.StudentsProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/15 15:11
 */
@Controller
public class HelloController {

    private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

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

        request.setAttribute("date", "2019-03-22 15:07:00");
        return "index";
    }

    @Autowired
    private StudentService studentService;

    /**
     * spring-boot查询测试
     *
     * @param request
     * @return
     */
    @RequestMapping("/students")
    @ResponseBody
    public List<Student> findStudentList(HttpServletRequest request) {
        List<Student> students = studentService.selectStudentList();
        return students;
    }

    /**
     * spring-boot事务测试
     *
     * @param request
     * @return
     */
    @RequestMapping("/insert")
    @ResponseBody
    public String insertStudent(HttpServletRequest request) {
        try {
            List<Student> students = new ArrayList<>();
            Student student = new Student(1, "One");
            Student student1 = new Student(2, "Two");
            Student student2 = new Student(3, "Three");
            students.add(student);
            students.add(student1);
            students.add(student2);
            studentService.insertBachStudent(students);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "success";
    }

    /**
     * Freemarker视图
     */
    @RequestMapping("/freemarker")
    public String freemarker(HttpServletRequest request) {
        request.setAttribute("ftl", "ftl");
        return "freemarker";
    }

    /**
     * requestURL
     */
    @RequestMapping("/url")
    @ResponseBody
    public Map<String, Object> url(HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("getRequestURI", request.getRequestURI());
        map.put("getRequestURL", request.getRequestURL());
        return map;
    }

    @RequestMapping("/log/debug")
    public void debugLog(HttpServletResponse response, HttpServletRequest request) {
        logger.debug(new Exception("debug日志").getMessage(),new Exception());

    }

    @RequestMapping("/log/info")
    public void infoLog(HttpServletResponse response, HttpServletRequest request) {
        logger.info(new Exception("info日志").getMessage());

    }


    @RequestMapping("/log/warn")
    public void warnLog(HttpServletResponse response, HttpServletRequest request) {
        Exception e = new Exception("warn日志");
        logger.warn(new Exception("warn日志").getMessage(), e);

    }

    @RequestMapping("/log/error")
    public void errorLog(HttpServletResponse response, HttpServletRequest request) {
        Exception e = new Exception("error日志");
        logger.error(e.getMessage(), e);

    }
}
