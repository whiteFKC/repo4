package com.it;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class getConfig {
    public static void main(String[] args) throws  Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        RequestConfig config=RequestConfig.custom().setConnectTimeout(1000).//设置创建连接的最长时间
                setConnectionRequestTimeout(500).//设置获取连接的最长时间
                setSocketTimeout(10*10000).//设置数据传输的最长时间
                build();
        httpGet.setConfig(config);
        CloseableHttpResponse execute = httpclient.execute(httpGet);
        if(execute.getStatusLine().getStatusCode()==200){
            HttpEntity entity = execute.getEntity();
            String string = EntityUtils.toString(entity, "utf8");
            System.out.println(string);
        }

    }
}
