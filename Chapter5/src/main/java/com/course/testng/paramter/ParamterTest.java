package com.course.testng.paramter;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParamterTest {

    /*通过Parameters关键字传参，运行xml文件传参
    *@关键字Parameters中的参数为xml文件中标签为parameters,name属性的值，获取到的是标签中属性为value的值
    *
    *
    * */
    @Test
    @Parameters({"name", "age"})
    public void  paramTest1(String name, int age){
        System.out.println("name = " + name + "; age =" + age);
    }
}
