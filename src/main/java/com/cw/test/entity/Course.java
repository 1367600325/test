package com.cw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("course")
public class Course {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//课程id

    private String courseName;//课程名称

    private Float credit;//课程学分
}
