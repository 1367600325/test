package com.cw.test.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cw.test.entity.Pages;
import com.cw.test.entity.Student;
import com.cw.test.entity.StudentCourse;
import com.cw.test.mapper.StudentMapper;
import com.cw.test.service.CourseService;
import com.cw.test.service.StudentCourseService;
import com.cw.test.service.StudentService;
import com.cw.test.vo.StudentCourseVo;
import com.cw.test.vo.StudentVo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Transactional
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService{

    @Resource
    private StudentMapper studentMapper;

    @Resource
    private StudentCourseService studentCourseService;

    //查询
    @Override
    public StudentVo find(Student student, Pages page) {
        StudentVo studentVo=new StudentVo();
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("sex",student.getSex()).eq("grade",student.getGrade()).like("stud_name",student.getStudName());
        IPage<Student> studentIPage=new Page<>(page.getCurrent(),page.getSize());
        studentMapper.selectPage(studentIPage, queryWrapper);
        studentVo.setCurrent(page.getCurrent());
        studentVo.setSize(page.getSize());
        studentVo.setTotal(studentIPage.getTotal());
        System.out.println(studentIPage.getRecords());
        studentVo.setStudentList(studentIPage.getRecords());
        return studentVo;
    }

    //删除
    @Override
    public int deleteById(Integer id) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",id);
        Student student = studentMapper.selectOne(queryWrapper);
        //判断是否有该用户
        if (student==null){
            return 0;
        }
        studentMapper.delete(queryWrapper);
        //删除对应的课表数据
        QueryWrapper<StudentCourse> wrapper=new QueryWrapper<>();
        studentCourseService.remove(wrapper.eq("student_id",id));
        return 1;
    }

    //更新
    @Override
    public int updateStudent(Student student) {
        QueryWrapper<Student> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("id",student.getId());
        if (studentMapper.selectOne(queryWrapper)==null){
            return 0;
        }
        int result = studentMapper.updateById(student);
        return result;
    }

    //查询学生和课程
    @Override
    public List<StudentCourseVo> queryStudentCourse(Integer stuId) {
        List<StudentCourseVo> students = studentMapper.queryStudentCourse(stuId);
        System.out.println(students);
        return students;
    }
}
