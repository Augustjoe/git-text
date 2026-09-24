package com.webDemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.webDemo.pojo.Dept;
import com.webDemo.pojo.Result;
import com.webDemo.service.DeptService;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @RequestMapping("/depts")
    public Result list() {
       System.out.println("查询全部数据");
        List<Dept> list = deptService.findAll();
        return Result.success(list);

    }
}
