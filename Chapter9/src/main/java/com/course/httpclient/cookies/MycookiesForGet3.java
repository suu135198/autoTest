package com.course.httpclient.cookies;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

public class MycookiesForGet3 {
    private String url;
    private ResourceBundle bundle;
    private CookieStore cookieStore;

    @BeforeTest
    public void beforeTest() {
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies() throws IOException {
        String result;
        RequestConfig globalConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
        // 创建cookie store的本地实例
        cookieStore = new BasicCookieStore();
        // 创建HttpClient上下文
        HttpClientContext context = HttpClientContext.create();
        context.setCookieStore(cookieStore);


        String uri = bundle.getString("getCookies.url");
        String testUrl = this.url + uri;
        HttpGet get = new HttpGet(testUrl);
        CloseableHttpClient client = HttpClients.custom().setDefaultRequestConfig(globalConfig).
                setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity, "UTF-8");
        System.out.println(result);
        for (Cookie c: cookieStore.getCookies()){
            System.out.println(c.getName() + ": " + c.getValue());
        }
    }

    @Test(dependsOnMethods = {"testGetCookies"})
    public void testWithCookies() throws IOException {
        String result;

        String uri = bundle.getString("test.get.with.cookies");
        String testurl = this.url+uri;
        HttpGet get = new HttpGet(testurl);
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(cookieStore).build();
        CloseableHttpResponse response = client.execute(get);
        HttpEntity entity = response.getEntity();
        result = EntityUtils.toString(entity,"UTF-8");
        System.out.println(result);
    }
}
