package com.course.testng;

import org.testng.annotations.Test;

public class IgnoreTest {
    /*
    * 忽略测试用例,用关键字enabled enabled=true,执行用例,enabled=false,忽略测试用例
    * */
    @Test
    public void ignore1(){
        System.out.println("ignore1 执行");
    }
    @Test(enabled = false)//忽略执行
    public void ignore2(){
        System.out.println("ignore2执行");
    }

    @Test(enabled = true)//enabled默认为true,要执行测试，enabled一般不写
    public void ignore3(){
        System.out.println("ignore3执行");
    }
}
