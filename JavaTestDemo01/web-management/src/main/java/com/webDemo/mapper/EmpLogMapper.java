package com.webDemo.mapper;

import com.webDemo.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EmpLogMapper {
    @Insert("INSERT INTO emp_log (operate_time, info) VALUES (#{operateTime}, #{info})")
    public void insertEmpLog(EmpLog empLog);
}
