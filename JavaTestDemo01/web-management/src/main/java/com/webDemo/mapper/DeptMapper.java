package com.webDemo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.webDemo.pojo.Dept;
import java.util.List;

@Mapper
public interface DeptMapper {
    /*
    * 查询所有的部门数据
    * */
    @Select("select id, name, create_time, update_time from dept order by update_time desc;")
    List<Dept> findAll();
}
