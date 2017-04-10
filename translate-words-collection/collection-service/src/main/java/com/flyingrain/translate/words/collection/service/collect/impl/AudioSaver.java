package com.flyingrain.translate.words.collection.service.collect.impl;

import org.springframework.stereotype.Component;

import java.io.InputStream;

/**
 * Created by wally on 4/10/17.
 */
@Component
public interface AudioSaver {

    String saveAudiobyUrl(String url);

    String saveAudiobyPath(String path);

    String saveAudio(InputStream inputStream);

}
