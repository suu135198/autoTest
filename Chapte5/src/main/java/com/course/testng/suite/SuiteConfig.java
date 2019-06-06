package com.course.testng.suite;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class SuiteConfig {
    /*
    * suite套件类,通过xml文件执行套件类和测试类
    *
    * */
    @BeforeSuite
    public void  beforeSuite(){
        System.out.println("before suite 运行啦");
    }
    @AfterSuite
    public  void afterSuite(){
        System.out.println("after suite运行啦");
    }

    @BeforeTest
    public void befoTest(){
        System.out.println("beforeTest");
    }

    @AfterTest
    public void  afterTest(){
        System.out.println("afterTest");
    }

}
