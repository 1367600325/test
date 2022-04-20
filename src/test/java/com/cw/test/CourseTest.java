package com.cw.test;

import com.cw.test.entity.Course;
import com.cw.test.entity.Pages;
import com.cw.test.service.CourseService;
import com.cw.test.vo.CourseVo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseTest {

    @Autowired
    private CourseService courseService;

    //模糊查询
    @Test
    public void query(){
        Pages pages=new Pages();
        pages.setCurrent(1);
        pages.setSize(2);
        CourseVo coursevo = courseService.findByName("理", pages);
        List<Course> courselist = coursevo.getCourselist();
        System.out.println(courselist);

    }
    
    //删除
    @Test
    public void delete(){
        int result = courseService.deleteById(1);
        System.out.println(result);

    }

    //增加
    @Test
    public void add(){
        Course course=new Course();
        course.setCourseName("英语");
        course.setCredit(4f);
        int result = courseService.addCourse(course);
        System.out.println(result);

    }

    //更新
    @Test
    public void update(){
        Course course=new Course();
        course.setId(5);
        course.setCourseName("英语");
        course.setCredit(2f);
        boolean result = courseService.updateById(course);
        System.out.println(result);

    }
}
