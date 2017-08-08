package com.flyingrain.translate.framework.lang.utils;

/**
 * Created by wally on 8/8/17.
 */

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by wally on 4/10/17.
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);


    /**
     * 发送GET请求
     *
     * @param url 请求地址
     * @return 返回
     */
    public static String sendGet(String url,Map<String,String> headers) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet(url);
            logger.info("start to send to [{}]",url);
            headers.forEach(httpGet::setHeader);
            try (CloseableHttpResponse response = httpClient.execute(httpGet)) {
                final HttpEntity httpEntity = response.getEntity();
                String result = EntityUtils.toString(httpEntity);
                EntityUtils.consume(httpEntity);
                return result;
            }

        } catch (IOException e) {
            logger.error("create httpClient failed!", e);
        }
        return null;
    }




    public static String sendPost(Map<String,String> params,Map<String,String>headers,String url){
        try(CloseableHttpClient httpClient = HttpClients.createDefault()){
            final HttpPost httpPost = new HttpPost(url);
            if(headers!=null&&headers.size()!=0){
                headers.forEach(httpPost::setHeader);
            }
            List<NameValuePair> paramList=new ArrayList<>();
            params.forEach((key,value)->{
                paramList.add(new BasicNameValuePair(key,value));
            });
            httppost.setEntity(new UrlEncodedFormEntity(params,HTTP.UTF_8));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

