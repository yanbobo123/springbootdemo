package com.yanbobo.demo.service.impl;

import com.yanbobo.demo.dao.StudentDao;
import com.yanbobo.demo.entity.Student;
import com.yanbobo.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @describe:
 * @author: yanbobo
 * @createdate: 2019/3/22 17:14
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Transactional(readOnly = true, rollbackFor = Exception.class)
    @Override
    public List<Student> selectStudentList() {
        return studentDao.selectStudentList();
    }

    @Transactional(readOnly = false,value = "txManager2",rollbackFor = Exception.class)
    @Override
    public int insertStudent(Student student) {
        return 0;
    }

    @Transactional(readOnly = false,value = "txManager",rollbackFor = Exception.class)
    @Override
    public int updateStudent(Student student) {
        return 0;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int delStudent(Integer id) {
        return 0;
    }

    @Transactional(readOnly = false,value = "txManager2",rollbackFor = Exception.class)
    @Override
    public int insertBachStudent(List<Student> students) throws Exception {
        for (int i = 0 ; i < students.size(); i++){
            /*if (i == 2){
                throw new Exception();
            }*/
            studentDao.insertStudent(students.get(i));
        }
        return 1;
    }
}
