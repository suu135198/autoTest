package com.course.httpclient.cookies;

import com.sun.javaws.security.Resource;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForPost {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void BeforTest(){
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        this.url = bundle.getString("test.url");
    }

    @Test
    public void testPostCookies() throws IOException {
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        // 创建cookie store的本地实例
        cookieStore = new BasicCookieStore();
        // 创建HttpClient上下文
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(cookieStore);

        String uri = bundle.getString("getCookies.url");
        String testUrl =this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(globalConfig).
                setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        String result = EntityUtils.toString(entity);
        for (Cookie c:cookieStore.getCookies()){
            System.out.println(c.getName() + ": " + c.getValue());
        }
    }

    @Test(dependsOnMethods = {"testPostCookies"})
    public void testWithPostCookies() throws IOException {
        String result;
        String uri = bundle.getString("test.post.with.cookies");
        String testUrl = this.url+uri;
        System.out.println(testUrl);

        //声明一个post方法
        HttpPost post =  new HttpPost(testUrl);
        //定义一个带cookie访问的client
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        //添加参数
        JSONObject param = new JSONObject();
        param.put("name","huhansan");
        param.put("age","18");

        //设置请求头信息,设置header
        post.setHeader("content-type","application/json");

        //将参数信息添加到方法中
        StringEntity entity = new StringEntity(param.toString(), "UTF-8");
        post.setEntity(entity);

        //执行post方法
        CloseableHttpResponse response = client.execute(post);

        //获取result实体内容
        HttpEntity entity2 = response.getEntity();
        result = EntityUtils.toString(entity2,"UTF-8");
        System.out.println(result);

        //转换结果为json
        JSONObject resultJson = new JSONObject(result);
        //获取key值
        String success = (String) resultJson.get("huhansan");
        //获取key值
        String status = (String) resultJson.get("status");

        //断言
        Assert.assertEquals("success", success);
        Assert.assertEquals("1", status);


    }
}
