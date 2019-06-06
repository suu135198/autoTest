package com.course.testng.groups;

import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Test;

public class Groups0nMethod {
    /*
    * @Test(groups="组名")声明测试类的分组 方法分组
    * */
    @Test(groups = "server")
    public  void  test1(){
        System.out.println("这是服务端组的测试方法1111");
    }

    @Test(groups = "server")
    public void test2(){
        System.out.println("这是服务端组的测试方法2222");
    }

    @Test(groups = "client")
    public void test3(){
        System.out.println("这是客户端组的测试方法3333");
    }
    @Test(groups = "client")
    public void test4(){
        System.out.println("这是客户端组的测试方法4444");
    }

    @BeforeGroups("server")
    public void  beforeGrounpsOnServer(){
        System.out.println("这是服务端组运行之前运行的方法");
    }

    @AfterGroups("server")
    public void  afterGrounpsOnServer(){
        System.out.println("这是服务端组运行之后运行的方法");
    }

    @BeforeGroups("client")
    public void  beforeGrounpsOnClient(){
        System.out.println("这是客户端组运行之前运行的方法");
    }

    @AfterGroups("client")
    public void  afterGrounpsOnClient(){
        System.out.println("这是客户端组运行之后运行的方法");
    }
}
