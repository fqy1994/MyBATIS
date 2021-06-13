package com.fqy.mybatis.bean;

import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/13 16:18
 */
public class Department {
    private  int id;
    private  String departmentName;
    private List<Employee> emps;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmps() {
        return emps;
    }

    public void setEmps(List<Employee> emps) {
        this.emps = emps;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", departmentName='" + departmentName + '\'' +
                '}';
    }
}
