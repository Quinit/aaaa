package com.quinit.aaaa.mapper;

import com.quinit.aaaa.pojo.queryparam.ClassQueryParam;
import com.quinit.aaaa.pojo.Clazz;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassMapper {

    List<Clazz> getALLClassInfo();

    Clazz getClassById(Integer id);

    List<Clazz> getClassList(ClassQueryParam classQueryParam);

    void deleteClass(Integer id);

    void addClass(Clazz clazz);

    void upDateClass(Clazz clazz);
}
