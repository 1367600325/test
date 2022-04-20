package com.cw.test.controller;

import com.cw.test.entity.Course;
import com.cw.test.entity.Student;
import com.cw.test.entity.StudentCourse;
import com.cw.test.service.CourseService;
import com.cw.test.service.StudentCourseService;
import com.cw.test.service.StudentService;
import com.cw.test.vo.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(tags = "测试")
@RestController
public class TestController {

    @Resource
    private StudentService studentService;

    @Resource
    private CourseService courseService;

    @Resource
    private StudentCourseService studentCourseService;

    @GetMapping("/hello")
    public String Test(){
        return "hello";
    }

    @GetMapping("/sudentall")
    public R StudentAll(){
        List<Student> students=studentService.list();
        return R.ok().data("students",students);
    }

    @GetMapping("/courseall")
    public R CourseAll(){
        List<Course> courses=courseService.list();
        return R.ok().data("courses",courses);
    }

    @GetMapping("/all")
    public R All(){
        List<StudentCourse> studentCourses=studentCourseService.list();
        return R.ok().data("studentCourses",studentCourses);
    }

}
