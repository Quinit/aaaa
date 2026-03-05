package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {

    void addEmpExpr(List<EmpExpr> exprList);

    void deleteEmpExprByEmpIds(List<Integer> empIds);
}
