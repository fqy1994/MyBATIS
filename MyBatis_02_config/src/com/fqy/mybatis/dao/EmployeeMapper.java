package com.fqy.mybatis.dao;

import com.fqy.mybatis.bean.Employee;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/12 21:44
 */
public interface EmployeeMapper {
     Employee getEmpById(Integer id);

}
