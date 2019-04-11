package com.yanbobo.demo.dao;

import com.yanbobo.demo.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/22 17:15
 */
@Mapper
@Repository("studentDao")
public interface StudentDao {

    @Select("SELECT age,name FROM student")
    public abstract List<Student> selectStudentList();

    @Insert("INSERT INTO student (age,name) VALUES (#{age},#{name})")
    int insertStudent(Student student);
}
