package com.course.httpclient.demo;


import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpClient {

    @Test
    public void test1() throws IOException {
        String result;
        HttpGet get = new HttpGet("https://www.baidu.com");
        CloseableHttpClient httpclent = HttpClients.createDefault();
        CloseableHttpResponse response = httpclent.execute(get);
//        System.out.println(   get.getURI());
//        System.out.println(response.getStatusLine().getStatusCode());
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity);
        System.out.println(result);

    }
}
