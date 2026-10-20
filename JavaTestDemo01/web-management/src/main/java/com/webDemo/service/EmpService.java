package com.webDemo.service;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.PageResult;
import org.springframework.stereotype.Service;


public interface EmpService {

    PageResult<Emp> page(Integer page, Integer size);
}
