package com.webDemo.mapper;

import com.webDemo.pojo.Emp;
import com.webDemo.pojo.EmpExpr;
import com.webDemo.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {

    @Select("select count(*) from emp e,dept d where d.id = e.dept_id;")
    public Long count();

//    @Select("select e.*,d.name dept_name from dept d,emp e where d.id = e.dept_id order by e.update_time desc limit #{start},#{pageSize} ;")
//    public List<Emp> selectAll(Integer start,Integer pageSize);

    @Select("select e.*,d.name dept_name from dept d,emp e where d.id = e.dept_id order by e.update_time desc")
    public List<Emp> selectAll();


    public List<Emp> selectAllByOther(EmpQueryParam empQueryParam);

    @Options(useGeneratedKeys = true, keyProperty = "id")
    @Insert("insert emp (username, password, name, gender, phone, job, salary, image, entry_date, create_time, update_time, dept_id)\n" +
            "       values (#{username}, #{password}, #{name}, #{gender}, #{phone}, #{job}, #{salary}, #{image}, #{entryDate}, #{createTime}, #{updateTime}, #{deptId});")
    void addEmp(Emp emp);



}
