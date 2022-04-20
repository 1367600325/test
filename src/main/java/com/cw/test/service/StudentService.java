package com.cw.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cw.test.entity.Pages;
import com.cw.test.entity.Student;
import com.cw.test.vo.StudentCourseVo;
import com.cw.test.vo.StudentVo;

import java.util.List;

public interface StudentService extends IService<Student> {


    StudentVo find(Student student, Pages page);

    int deleteById(Integer id);

    int updateStudent(Student student);

    List<StudentCourseVo> queryStudentCourse(Integer stuId);
}
