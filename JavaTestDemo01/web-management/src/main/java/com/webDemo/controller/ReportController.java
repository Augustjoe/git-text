package com.webDemo.controller;

import com.webDemo.pojo.Result;
import com.webDemo.service.EmpService;
import com.webDemo.service.ReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/report")
public class ReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/empReport")
    public Result empReport() {
        return Result.success(reportService.empReport());
    }

    @RequestMapping("/empGenderReport")
    public Result empGenderReport() {
        return Result.success(reportService.empGenderReport());
    }

}
