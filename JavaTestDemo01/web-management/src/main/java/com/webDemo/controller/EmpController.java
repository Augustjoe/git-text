package com.webDemo.controller;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.PageResult;
import com.webDemo.pojo.Result;
import com.webDemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result getEmp(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
        log.info("查询员工列表，页码：{}，每页大小：{}", page, pageSize);
        PageResult<Emp> pageResult = empService.page(page, pageSize);
        Result result = Result.success(pageResult);

        return  result;

    }
}
