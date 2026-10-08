package com.webDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webDemo.mapper.DeptMapper;
import com.webDemo.pojo.Dept;
import com.webDemo.service.DeptService;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll () {
        return deptMapper.findAll();
    }

    @Override
    public void delete (Integer id) {
        deptMapper.deleteById(id);
    }

    public  void add (Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }

    public Dept get (Integer id) {
        return deptMapper.get(id);
    }

    public void update(Dept dept){
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.update(dept);
    }


}
