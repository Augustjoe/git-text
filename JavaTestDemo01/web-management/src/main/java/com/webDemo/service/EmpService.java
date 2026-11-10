package com.webDemo.service;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.EmpQueryParam;
import com.webDemo.pojo.LoginInfo;
import com.webDemo.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


public interface EmpService {

    PageResult<Emp> page(EmpQueryParam empQueryParam);

    void addEmp(Emp emp);

    Emp getEmpById(Integer id);

    void updateEmp(Emp emp);

    LoginInfo Login(Emp emp);
}

