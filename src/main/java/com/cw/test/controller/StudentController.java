package com.cw.test.controller;

import com.cw.test.entity.Pages;
import com.cw.test.entity.Student;
import com.cw.test.service.StudentService;
import com.cw.test.vo.R;
import com.cw.test.vo.StudentCourseVo;
import com.cw.test.vo.StudentVo;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("student")
@Api(tags = "学生")
public class StudentController {

    @Resource
    private StudentService studentService;

    /**
     * 姓名：模糊查询
     * 性别：精确查询
     * 年级：精确查询 学生删除时，需要删除与课程的关联信息
     */
    @PostMapping("/query")
    public R findByName(@RequestBody Student student, Pages page){
        StudentVo studentVo= studentService.find(student,page);
        return R.ok().data("students",studentVo.getStudentList());
    }

    /**
     * 删除 需要删除与课程的关联信息
     */
    @DeleteMapping("/{id}")
    public R deleteById(@PathVariable Integer id){
        int result = studentService.deleteById(id);
        if (result==0){
            return R.error().setMessage("id错误");
        }
        return R.ok().setMessage("删除成功");
    }


    /**
     * 增加
     */
    @PostMapping()
    public R add(@RequestBody Student student){
        studentService.save(student);
        return R.ok().setMessage("增加成功");
    }

    /**
     * 更新
     */
    @PutMapping()
    public R updateStudent(@RequestBody Student student){
        int result = studentService.updateStudent(student);
        if (result==0){
            return R.error().setMessage("该用户不存在");
        }
        return R.ok().setMessage("更新成功");
    }

    /**
     *完成学生和课程的关联查询
     * 查询某个学生的信息以及所关联的课程信息。
     */
    @GetMapping("/queryAll/{stuId}")
    public R queryStudentCourse(@PathVariable Integer stuId){
        List<StudentCourseVo> students= studentService.queryStudentCourse(stuId);
       if (students==null){
           return R.error().setMessage("id错误");
       }
        return R.ok().data("students",students);
    }
}
