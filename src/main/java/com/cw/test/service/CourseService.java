package com.cw.test.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cw.test.entity.Course;
import com.cw.test.entity.Pages;
import com.cw.test.vo.CourseVo;

import java.util.List;

public interface CourseService extends IService<Course> {
    CourseVo findByName(String courseName, Pages pages);

    int deleteById(Integer id);

    int addCourse(Course course);
}
