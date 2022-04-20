package com.cw.test.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cw.test.entity.StudentCourse;
import com.cw.test.mapper.StudentCourseMapper;
import com.cw.test.service.StudentCourseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class StudentCourseServiceImpl extends ServiceImpl<StudentCourseMapper, StudentCourse> implements StudentCourseService {
}
