package com.webDemo.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.webDemo.pojo.Dept;
import com.webDemo.pojo.Result;
import com.webDemo.service.DeptService;
import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @GetMapping
    public Result list() {
       System.out.println("查询全部数据");
        List<Dept> list = deptService.findAll();
        return Result.success(list);

    }
    /*
        删除部门的方法
     */
    @DeleteMapping
    /*
    * RequestParam 是可以省略的，但要求前端传递的参数名和后端一致
    * */
    public Result delete(Integer id) {
        System.out.println("删除部门：" + id);
        deptService.delete(id);
        return Result.success();
    }

    /*
    * 一旦使用了@RequestParam，就表示这个参数是必须的
    * */
    /*
    方式2  使用@RequestParam
    public Result delete(@RequestParam(value = "id", required = false) Integer id) {
        System.out.println("删除部门：" + id);
        return Result.success();
    }*/

/*  方式1
    public Result delete(HttpServletRequest request ) {
        String idStr = request.getParameter("id");
        Integer id = Integer.parseInt(idStr);
        System.out.println("删除部门：" + id);
        return Result.success();
    }*/

    @PostMapping
    public Result add(@RequestBody Dept dept) {
        System.out.println("添加部门：" + dept);
        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id) {
        System.out.println("查询部门：" + id);
        Dept dept = deptService.get(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        System.out.println("修改部门：" + dept);
        deptService.update(dept);
        return Result.success();
    }

}
