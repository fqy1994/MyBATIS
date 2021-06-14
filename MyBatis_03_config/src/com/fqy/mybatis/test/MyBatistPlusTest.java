package com.fqy.mybatis.test;

import com.fqy.mybatis.bean.Department;
import com.fqy.mybatis.bean.Employee;
import com.fqy.mybatis.dao.DepartmentMapper;
import com.fqy.mybatis.dao.EmployeeMapperDynamicSQL;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/14 9:24
 */
public class MyBatistPlusTest {
    @Test
    public void DynamicSqlTest() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%o%", null, null);
            List<Employee> emps = mapper.getEmpsByConditionIf(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }

    @Test
    public void DynamicSql1Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, "%o%", null, null);
            List<Employee> emps = mapper.getEmpsByConditionTrim(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }

    @Test
    public void DynamicSql2Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(null, null, null, null);
            List<Employee> emps = mapper.getEmpsByConditionChoose(employee);
            for (Employee emp : emps) {
                System.out.println(emp);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void DynamicSql3Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            Employee employee = new Employee(1, "Admin", null, null);
            mapper.updateEmp(employee);
            sqlSession.commit();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void DynamicSql4Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);

            List<Employee> emps = mapper.getEmpsByConditionForeach(Arrays.asList(1, 2, 3));
            for (Employee emp : emps) {
                System.out.println("emp = " + emp);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }

    @Test
    public void DynamicSql5Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> emps = new ArrayList<>();
            emps.add(new Employee(null, "smith", "ewr@dsf", "1", new Department(1)));
            emps.add(new Employee(null, "allen", "se@sf", "0", new Department(2)));
            mapper.addEmps(emps);
            sqlSession.commit();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
    @Test
    public void DynamicSql6Test() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperDynamicSQL mapper = sqlSession.getMapper(EmployeeMapperDynamicSQL.class);
            List<Employee> list = mapper.getEmpsTestInnerParameter(null);
            for (Employee employee : list){
                System.out.println("employee = " + employee);
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }
    }
}
