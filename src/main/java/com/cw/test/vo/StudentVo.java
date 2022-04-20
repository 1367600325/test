package com.cw.test.vo;

import com.cw.test.entity.Student;
import lombok.Data;

import java.util.List;

@Data
public class StudentVo {

    private Integer current;//当前页

    private Integer size;//每个页数

    private Long total;//总页数

    private List<Student> studentList;//学生
}
