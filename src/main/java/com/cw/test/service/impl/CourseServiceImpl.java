package com.cw.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cw.test.entity.Course;
import com.cw.test.entity.Pages;
import com.cw.test.entity.StudentCourse;
import com.cw.test.mapper.CourseMapper;
import com.cw.test.service.CourseService;
import com.cw.test.service.StudentCourseService;
import com.cw.test.vo.CourseVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Resource
    private CourseMapper courseMapper;

    @Resource
    private StudentCourseService studentCourseService;

    //模糊查询
    @Override
    public CourseVo findByName(String courseName, Pages pages) {
        QueryWrapper<Course> queryWrapper=new QueryWrapper<>();
        queryWrapper.like("course_name",courseName);
        CourseVo courseVo=new CourseVo();
        IPage<Course> courseIPage=new Page<>(pages.getCurrent(),pages.getSize());
        courseMapper.selectPage(courseIPage,queryWrapper);
        courseVo.setCurrent(pages.getCurrent());
        courseVo.setSize(pages.getSize());
        courseVo.setTotal(courseIPage.getTotal());
        courseVo.setCourselist(courseIPage.getRecords());
        return courseVo;
    }

    //删除
    @Override
    public int deleteById(Integer id) {
        Course course = courseMapper.selectById(id);
        QueryWrapper<StudentCourse> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("course_id",id);
        StudentCourse studentCourse = studentCourseService.getOne(queryWrapper);
        if(course==null||studentCourse!=null){
            return 0;
        }
        int result = courseMapper.deleteById(id);
        return result;
    }

    //添加
    @Override
    public int addCourse(Course course) {
        Course oldCourse = courseMapper.selectById(course.getId());
        if(oldCourse!=null){
            return 0;
        }
        int result = courseMapper.insert(course);
        return result;
    }
}
