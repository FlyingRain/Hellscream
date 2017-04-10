package com.flyingrain.translate.words.collection.service.collect.impl;


import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.springframework.stereotype.Component;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by wally on 4/10/17.
 */
@Component
public class AudioSaverImpl implements AudioSaver {

    @Override
    public String saveAudiobyUrl(String url) {
        try (CloseableHttpClient httpClient = HttpClients.createDefault();) {

            HttpGet httpGet = new HttpGet(url);
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
                 FileOutputStream fileOutputStream = new FileOutputStream("/home/wally/Music/ttt.mp3")) {
                HttpEntity entity = httpResponse.getEntity();
                InputStream inputStream = entity.getContent();
                byte temp [] = new byte[1024];
                int i;
                while((i=inputStream.read(temp))!=-1){
                    fileOutputStream.write(temp);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String saveAudiobyPath(String path) {
        return null;
    }

    @Override
    public String saveAudio(InputStream inputStream) {
        return null;
    }
}
