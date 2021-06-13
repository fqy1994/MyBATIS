package com.fqy.mybatis.dao;

import com.fqy.mybatis.bean.Department;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/13 17:56
 */
public interface DepartmentMapper {
    Department getDeptById(Integer id);
    Department getDeptByIdPlus(Integer id);

}
