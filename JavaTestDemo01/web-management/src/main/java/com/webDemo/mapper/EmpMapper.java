package com.webDemo.mapper;

import com.webDemo.pojo.Emp;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp e,dept d where d.id = e.dept_id;")
    public Long count();

    @Select("select e.*,d.name dept_name from dept d,emp e where d.id = e.dept_id order by e.update_time desc limit #{start},#{pageSize} ;")
    public List<Emp> selectAll(Integer start,Integer pageSize);
}
