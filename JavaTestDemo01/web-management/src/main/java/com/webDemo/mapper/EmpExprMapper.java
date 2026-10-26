package com.webDemo.mapper;

import com.webDemo.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    public void addEmpExpr(List<EmpExpr> empExprList);

}
