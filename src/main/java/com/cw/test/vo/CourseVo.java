package com.cw.test.vo;

import com.cw.test.entity.Course;

import lombok.Data;

import java.util.List;

@Data
public class CourseVo {
    private Integer current;//当前页

    private Integer size;//每个页数

    private Long total;//总页数

    private List<Course> Courselist;//学生
}
