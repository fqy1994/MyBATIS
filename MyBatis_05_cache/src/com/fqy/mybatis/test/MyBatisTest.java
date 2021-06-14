package com.fqy.mybatis.test;

import com.fqy.mybatis.bean.Department;
import com.fqy.mybatis.bean.Employee;
import com.fqy.mybatis.dao.DepartmentMapper;
import com.fqy.mybatis.dao.EmployeeMapper;
import com.fqy.mybatis.dao.EmployeeMapperAnnotation;
import com.fqy.mybatis.dao.EmployeeMapperPlus;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author fan_jennifer
 * @create 2021-06-2021/6/12 18:40
 */
public class MyBatisTest {
    @Test
    public void test() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory =
                new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession openSession = sqlSessionFactory.openSession();
        Employee employee = openSession.selectOne("com.fqy.mybatis.EmployeeMapper.selectEmp", 1);
        System.out.println("employee = " + employee);
        

    }

    @Test
    public void test1()  {
        SqlSession sqlSession = null;
        try {
            //获取sqlsessionfactory对象
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);

            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper.getClass());//class com.sun.proxy.$Proxy6,为接口自动创建代理对象
            System.out.println("employee = " + employee);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }




    }

    @Test
    public void test3() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapperAnnotation mapper = sqlSession.getMapper(EmployeeMapperAnnotation.class);

            Employee empById = mapper.getEmpById(1);
            System.out.println("empById = " + empById);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            sqlSession.close();
        }




    }
    @Test
    public void test4() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee jane = new Employee(null, "jane", "12@com", "0");
            boolean b = mapper.addEmp(jane);
            sqlSession.commit();
            System.out.println("b = " + b);
            System.out.println("jane = " + jane.getId());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
    @Test
    public void test5() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            EmployeeMapperPlus mapper = sqlSession.getMapper(EmployeeMapperPlus.class);
            Employee empByIdStep = mapper.getEmpByIdStep(1);
            System.out.println("empByIdStep = " + empByIdStep);
            System.out.println("empByIdStep.getDept() = " + empByIdStep.getDept());

            

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }


    }
    @Test
    public void test6() {
        SqlSession sqlSession = null;
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory =
                    new SqlSessionFactoryBuilder().build(inputStream);
            sqlSession = sqlSessionFactory.openSession();

            DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
            Department empByIdStep = mapper.getDeptByIdPlus(1);
            System.out.println("empByIdStep = " + empByIdStep);
            System.out.println("empByIdStep.getDept() = " + empByIdStep.getEmps());



        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            sqlSession.close();
        }

    }
}
