package com.webDemo.controller;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.EmpQueryParam;
import com.webDemo.pojo.PageResult;
import com.webDemo.pojo.Result;
import com.webDemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;
    @GetMapping
    public Result getEmp(
            EmpQueryParam empQueryParam
    ) {
        log.info("查询员工列表，页码：{}，每页大小：{}", empQueryParam.getPage(), empQueryParam.getPageSize());
        PageResult<Emp> pageResult = empService.page(empQueryParam);
        Result result = Result.success(pageResult);

        return  result;

    }

    @PostMapping
    public Result addEmp (@RequestBody Emp emp ){
        log.info("新增员工：{}", emp);
        empService.addEmp(emp);
        return Result.success();
    }
}
