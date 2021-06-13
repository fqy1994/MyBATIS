package com.fqy.mybatis.dao;

import com.fqy.mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/13 11:17
 */
public interface EmployeeMapperAnnotation {
    @Select("select * from tbl_employee where id = #{id}")
    Employee getEmpById(Integer id);
}
