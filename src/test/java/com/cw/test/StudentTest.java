package com.cw.test;

import com.cw.test.entity.Pages;
import com.cw.test.entity.Student;
import com.cw.test.service.StudentService;
import com.cw.test.vo.StudentCourseVo;
import com.cw.test.vo.StudentVo;
import io.swagger.annotations.Api;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class StudentTest {

    @Autowired
    private StudentService studentService;

    //学生表查询数据
    @Test
    public void studentQuery(){
        Student student=new Student();
        student.setSex(0);
        student.setGrade(5);
        student.setStudName("张");
        Pages pages=new Pages();
        pages.setCurrent(1);
        pages.setSize(2);
        StudentVo studentVo = studentService.find(student, pages);
        System.out.println(studentVo.getStudentList());
    }

    //查询某个学生的信息以及所关联的课程信息。
    @Test
    public void selectAll(){
        List<StudentCourseVo> studentCourseVos = studentService.queryStudentCourse(1);
        System.out.println(studentCourseVos);
    }

    //学生表增加
    @Test
    public void add(){
        Student student=new Student();
        student.setSex(0);
        student.setGrade(5);
        student.setStudName("成龙");
        boolean save = studentService.save(student);
        System.out.println(save);
    }

    //学生表删除
    @Test
    public void delete(){
        int result = studentService.deleteById(1);
        System.out.println(result);
    }

    //学生表修改
    @Test
    public void update(){
        Student student=new Student();
        student.setId(8);
        student.setSex(0);
        student.setGrade(1);
        student.setStudName("成龙");
        int result = studentService.updateStudent(student);
        System.out.println(result);

    }
}
