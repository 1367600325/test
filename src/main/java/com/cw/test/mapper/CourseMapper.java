package com.cw.test.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cw.test.entity.Course;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
