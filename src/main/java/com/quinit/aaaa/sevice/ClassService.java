package com.quinit.aaaa.sevice;

import com.quinit.aaaa.pojo.queryparam.ClassQueryParam;
import com.quinit.aaaa.pojo.Clazz;
import com.quinit.aaaa.pojo.PageResult;

import java.util.List;

public interface ClassService {
    PageResult<Clazz> getClassList(ClassQueryParam classQueryParam);

    void deleteClass(Integer id);

    void addClass(Clazz clazz);

    List<Clazz> getALLClassInfo();

    void upDateClass(Clazz clazz);

    Clazz getClassById(Integer id);
}
