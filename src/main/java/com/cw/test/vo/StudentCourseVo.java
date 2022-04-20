package com.cw.test.vo;

import com.cw.test.entity.Course;
import lombok.Data;

import java.util.List;

@Data
public class StudentCourseVo {

    private Integer id;//学生id

    private String studName;//学生姓名

    private Integer sex;//性别

    private Integer grade;//学生年级

    private List<Course> courseList=null;
}
