package com.webDemo.controller;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.LoginInfo;
import com.webDemo.pojo.Result;
import com.webDemo.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LoginController {

    @Autowired
    private EmpService empService;

    @PostMapping("/login")
    public Result login(@RequestBody Emp emp) {
       LoginInfo info = empService.Login(emp);
       if(info != null){
           return Result.success(info);
       }
       return Result.error("用户名或密码错误");
    }
}
