package com.webDemo.controller;

import com.webDemo.mapper.EmpExprMapper;
import com.webDemo.mapper.EmpMapper;
import com.webDemo.pojo.Emp;
import com.webDemo.pojo.EmpQueryParam;
import com.webDemo.pojo.PageResult;
import com.webDemo.pojo.Result;
import com.webDemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/emp")
public class EmpController {

    @Autowired
    private EmpService empService;

    @Autowired
    private EmpExprMapper empExprMapper;

    @Autowired
    private EmpMapper empMapper;


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
//    删除员工
    @Transactional(rollbackFor = Exception.class)
    @DeleteMapping
    public Result deleteEmp(@RequestParam List<Integer> ids){
        log.info("删除员工：{}", ids);
        empMapper.deleteEmp(ids);
        empExprMapper.deleteEmpExp(ids);
        return Result.success();
    }
//    查询员工信息
    @GetMapping("/{id}")
    public Result getEmpById(@PathVariable("id") Integer id){
        log.info("查询员工信息：{}", id);
        Emp emp = empService.getEmpById(id);
        return Result.success(emp);

    }
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        log.info("修改员工信息：{}", emp);
        empService.updateEmp(emp);
        return Result.success();
    }
}
