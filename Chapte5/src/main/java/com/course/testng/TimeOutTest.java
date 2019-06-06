package com.course.testng;

import org.testng.annotations.Test;

public class TimeOutTest {

    @Test(timeOut = 3000)//单位为毫秒值//超时测试
    public void testSuccess() throws InterruptedException {
        Thread.sleep(2000);
    }

    @Test(timeOut = 2000)//单位为毫秒值//超时测试
    public void testFailed() throws InterruptedException {
        Thread.sleep(2000);
    }
}
