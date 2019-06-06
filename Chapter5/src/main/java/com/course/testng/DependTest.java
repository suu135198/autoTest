package com.course.testng;

import org.testng.annotations.Test;

public class DependTest {
    /*
    * 依赖方法关键字dependsOnMethods={方法1,方法2},值为依赖的方法名,可以传多个方法，
    * 被依赖方法异常时，依赖方法忽略
    * */
    @Test
    public void  test1(){
        System.out.println("test1 run");
        throw new RuntimeException();//抛出运行时异常，依赖方法test2忽略
    }

    @Test(dependsOnMethods = {"test1"})//test2方法依赖于test1 依赖关键字:dependsOnMethods ={"依赖方法名"}
    public void  test2(){
        System.out.println("test2 run");
    }
}
