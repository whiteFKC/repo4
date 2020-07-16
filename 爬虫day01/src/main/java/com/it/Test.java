package com.it;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Test {
    public static void main(String[] args) throws  Exception{
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("http://www.itcast.cn/");
        CloseableHttpResponse execute = httpclient.execute(httpGet);
        if(execute.getStatusLine().getStatusCode()==200){
            HttpEntity entity = execute.getEntity();
            String string = EntityUtils.toString(entity, "utf8");
            System.out.println(string);
        }

    }
}
