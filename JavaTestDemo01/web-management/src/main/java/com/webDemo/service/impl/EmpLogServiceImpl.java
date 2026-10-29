package com.webDemo.service.impl;

import com.webDemo.mapper.EmpLogMapper;
import com.webDemo.pojo.EmpLog;
import com.webDemo.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmpLogServiceImpl implements EmpLogService {

    @Autowired
    private EmpLogMapper empLogMapper;

    @Transactional(propagation = Propagation.REQUIRES_NEW) // 创建一新的事务，在新的事务中运行
    @Override
    public void insertEmpLog(EmpLog empLog) {
        empLogMapper.insertEmpLog(empLog);
    }
}
