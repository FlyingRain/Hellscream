package com.flyingrain.translate.words.collection.service.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * Created by wally on 4/10/17.
 */
public class HttpUtil {

    private static Logger logger = LoggerFactory.getLogger(HttpUtil.class);

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
     * 发送GET请求
     *
     * @param url 请求地址
     * @return 返回
     */
    public static String sendGet(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            final HttpGet httpGet = new HttpGet(url);
            httpGet.setHeader("User-Agent", "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/59.0.3063.4 Safari/537.36");
            logger.info("start to send to [{}]",url);
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
}
