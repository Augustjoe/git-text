package com.webDemo.mapper;

import com.webDemo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    public void addEmpExpr(List<EmpExpr> empExprList);

    void deleteEmpExp(List<Integer> ids);

    @Select("select * from emp_expr where emp_id = #{id};")
    public List<EmpExpr> getEmpExprList(Integer id);
}
