package com.cw.test.controller;

import com.cw.test.entity.Course;
import com.cw.test.entity.Pages;
import com.cw.test.service.CourseService;
import com.cw.test.vo.CourseVo;
import com.cw.test.vo.R;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@Api(tags = "课程")
@RequestMapping("course")
public class CourseController {

    @Resource
    private CourseService courseService;

    /**
     * 课程名：模糊查询 课程删除时，需要判断是否已有学生在使用
     */
    @GetMapping("/{courseName}")
    public R query(@PathVariable String courseName, Pages pages){
       CourseVo courseVo = courseService.findByName(courseName,pages);
        return R.ok().data("courser",courseVo.getCourselist());
    }

    /**
     * 课程删除时，需要判断是否已有学生在使用
     *
     */
    @DeleteMapping("/{ids}")
    public R delete(@PathVariable Integer id){
       int result= courseService.deleteById(id);
       if (result==0){
           return R.error().setMessage("删除失败");
       }
        return R.ok().setMessage("删除成功");
    }

    //增加
    @PostMapping()
    public R add(@RequestBody Course course){
        int result= courseService.addCourse(course);
        if (result==0){
            return R.error().setMessage("添加失败");
        }
        return R.ok().setMessage("添加成功");
    }

    //更新
    @PutMapping()
    public R update(@RequestBody Course course){
        boolean result = courseService.updateById(course);
        if (result){
            return R.error().setMessage("修改失败");
        }
        return R.ok().setMessage("修改成功");
    }
}
