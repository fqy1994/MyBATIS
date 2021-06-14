package com.fqy.mybatis.dao;

import com.fqy.mybatis.bean.Employee;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/13 15:38
 */
public interface EmployeeMapperPlus {
    Employee getEmpById(Integer id);

    Employee getEmpAndDept(Integer id);

    Employee getEmpByIdStep(Integer id);

    List<Employee> getEmpsByDeptId(Integer deptId);
}
