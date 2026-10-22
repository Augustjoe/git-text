package com.webDemo.service;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;


public interface EmpService {

    PageResult<Emp> page(Integer page, Integer size,
                         String name, Integer gender,
                         LocalDate begin,
                         LocalDate end);
}
