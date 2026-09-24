package com.webDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webDemo.mapper.DeptMapper;
import com.webDemo.pojo.Dept;
import com.webDemo.service.DeptService;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll () {
        return deptMapper.findAll();
    }
}
