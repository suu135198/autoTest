package com.course.testng.paramter;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderTest {
    /*
    * Test(dataProvider = "")，测试类读取@DataProvider注释方法中的值,@DataProvider定义name属性时，
    * @Test测试类使用dataProvider = name,name为DataProvider注释中的name值,如果DataProvider没有定义name属性时
    * @Test测试类使用dataProvider =method,method为DataProvider注释的方法名
    *
    * Method method方法中的method.getName()可以获取测试类的方法名, 然后.equals()判断传进来的方法是否为具体的值
    * */
    @Test(dataProvider = "data")
    public void testDataProvider(String name, int age){
        System.out.println("name =" + name +"; age=" +age);
    }

    @DataProvider(name="data")
    public Object [][] providerData(){
        Object [] []  o = new Object[][]{
                {"zhangsan", 10},
                {"lisi", 20},
                {"wangwu", 30}
        };
        return o;
    }

    @Test(dataProvider = "methodData")
    public void  test1(String name, int age){
        System.out.println("test111方法 name =" + name+"; age"+ age);
    }


    @Test(dataProvider = "methodData")
    public void  test2(String name, int age){
        System.out.println("test222方法 name =" + name+"; age"+age);
    }

    @DataProvider(name = "methodData")
    public Object[][] methodDataTest(Method method){
        Object[][] result = null;
        if(method.getName().equals("test1")){
            result = new Object[][]{
                    {"zhangsan", 20},
                    {"lisi", 25}
            };
        }
        else if (method.getName().equals("test2")){
            result = new  Object[][]{
                    {"zhaoliu", 30},
                    {"wangwu",35}
            };
        }
        return result;
    }
}
