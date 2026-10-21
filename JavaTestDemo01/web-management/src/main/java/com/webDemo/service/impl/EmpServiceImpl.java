package com.webDemo.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.webDemo.mapper.EmpMapper;
import com.webDemo.pojo.Emp;
import com.webDemo.pojo.PageResult;
import com.webDemo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpMapper empMapper;
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
    public PageResult<Emp> page (Integer page,Integer size){
        PageHelper.startPage(page, size);
        List<Emp> emps = empMapper.selectAll();

        Page<Emp> p = (Page<Emp>) emps;

        return new PageResult<Emp>(p.getTotal(),p.getResult());

    }

}

