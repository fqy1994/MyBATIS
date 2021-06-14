package com.fqy.mybatis.dao;

import com.fqy.mybatis.bean.Employee;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/13 21:37
 */
public interface EmployeeMapperDynamicSQL {
    List<Employee> getEmpsByConditionIf(Employee employee);

    List<Employee> getEmpsByConditionTrim(Employee employee);

    List<Employee> getEmpsByConditionChoose(Employee employee);

    List<Employee> getEmpsByConditionForeach(List<Integer> ids);

    List<Employee> getEmpsTestInnerParameter(Employee employee);

    void addEmps(List<Employee> emps);


    void updateEmp(Employee employee);

    void updateEmpByTrim(Employee employee);

}
