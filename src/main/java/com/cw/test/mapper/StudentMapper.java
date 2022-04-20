package com.cw.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.test.entity.Student;
import com.cw.test.vo.StudentCourseVo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {

    List<StudentCourseVo> queryStudentCourse(Integer stuId);
}
