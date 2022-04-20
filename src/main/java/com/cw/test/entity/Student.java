package com.cw.test.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@TableName("student")
public class Student {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;//学生id

    private String studName;//学生姓名

    private Integer sex;//性别

    private Integer grade;//学生年级


}
