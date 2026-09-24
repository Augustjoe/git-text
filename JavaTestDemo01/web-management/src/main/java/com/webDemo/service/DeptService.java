package com.webDemo.service;


import com.webDemo.pojo.Dept;
import java.util.List;

public interface DeptService {

    /*
    * 查询所有的部门数据
    * */
    List<Dept> findAll();
}
