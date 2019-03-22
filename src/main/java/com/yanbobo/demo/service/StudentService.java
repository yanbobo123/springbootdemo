package com.yanbobo.demo.service;

import com.yanbobo.demo.entity.Student;

import java.util.List;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/22 17:12
 */
public interface StudentService {

    public abstract List<Student> selectStudentList();

    public abstract int insertStudent(Student student);

    public abstract int updateStudent(Student student);

    public abstract int delStudent(Integer id);

}
