package com.course.testng;

import org.testng.annotations.Test;

public class ExpectedException {
    /*
    * 什么时候会用到异常测试
    * 在我们的期望结果为某一个异常的时候
    * 比如：我们传入了某些不合法的的参数, 程序抛出了异常
    * 也就是说我的语气结果就是个异常
    * */

    @Test(expectedExceptions = RuntimeException.class)//把用例注释为异常状态，运行会失败
    public  void  runTimeExceptionFailed(){
        System.out.println("这是一个失败的异常从测试");
    }

    @Test(expectedExceptions =  RuntimeException.class)//把用例注释为异常状态，抛出异常,运行成功
    public void  runTimeExceptionSuccess(){
        System.out.println("这是我的异常测试");
        throw new RuntimeException();

    }
}
