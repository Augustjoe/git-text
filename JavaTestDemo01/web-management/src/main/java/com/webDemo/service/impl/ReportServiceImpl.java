package com.webDemo.service.impl;

import com.webDemo.mapper.EmpMapper;
import com.webDemo.pojo.JobOption;
import com.webDemo.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption empReport() {
       List<Map<String,Object>> list = empMapper.reportEmpInfo();
       List<String> deptNames = list.stream().map(map -> (String) map.get("dept_name")).toList();
       List<Object> emp_counts = list.stream().map(map -> (Object) map.get("emp_count")).toList();
       return new JobOption(deptNames, emp_counts);
    }

    @Override
    public List<Map<String, Object>> empGenderReport() {
        return empMapper.reportEmpGender();
    }

}
