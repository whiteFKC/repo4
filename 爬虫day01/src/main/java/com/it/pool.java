package com.it;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class pool {
    public static void main(String[] args) throws IOException {
        PoolingHttpClientConnectionManager cm=new PoolingHttpClientConnectionManager();
        //    设置最大连接数
        cm.setMaxTotal(200);
        //    设置每个主机的并发数
        cm.setDefaultMaxPerRoute(20);
        doGet(cm);
        doGet(cm);
    }

    private static void doGet(PoolingHttpClientConnectionManager cm) throws IOException {
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(cm).build();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        CloseableHttpResponse response = httpClient.execute(httpGet);
        if(response.getStatusLine().getStatusCode()==200){
            String string = EntityUtils.toString(response.getEntity(), "utf8");
            System.out.println(string.length());
        }
    }
}
