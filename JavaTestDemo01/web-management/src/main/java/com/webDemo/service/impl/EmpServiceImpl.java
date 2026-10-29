package com.webDemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.webDemo.mapper.EmpExprMapper;
import com.webDemo.mapper.EmpLogMapper;
import com.webDemo.mapper.EmpMapper;
import com.webDemo.pojo.*;
import com.webDemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogMapper empLogMapper;


//
//    public PageResult<Emp> page (Integer page,Integer size){
//
//        long total = empMapper.count();
//
//        Integer start = (page - 1) * size;
//        List<Emp> rows = empMapper.selectAll(start,size);
//        return new PageResult<Emp>(total,rows);
//    }

    @Override
    public PageResult<Emp> page (EmpQueryParam empQueryParam){
        PageHelper.startPage(empQueryParam.getPage(), empQueryParam.getPageSize());
        List<Emp> emps = empMapper.selectAllByOther(empQueryParam);

        Page<Emp> p = (Page<Emp>) emps;

        return new PageResult<Emp>(p.getTotal(),p.getResult());

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addEmp(Emp emp) {
        try {
            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.addEmp(emp);

            List<EmpExpr> empExprList = emp.getEmpExprList();
            if(!empExprList.isEmpty()){
                empExprList.forEach(empExpr -> empExpr.setEmpId(emp.getId()));

                empExprMapper.addEmpExpr(empExprList);
            }
        } finally {
            empLogMapper.insertEmpLog(new EmpLog(
                    null,LocalDateTime.now(), "添加员工：" + emp
            ));
        }


    }



}

