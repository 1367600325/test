package com.cw.test.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("student_course")
//学生课程表 用来关联学生和课程
public class StudentCourse {

    private Integer id;

    private Integer studentId;//学生id

    private Integer courseId;//课程id
}
