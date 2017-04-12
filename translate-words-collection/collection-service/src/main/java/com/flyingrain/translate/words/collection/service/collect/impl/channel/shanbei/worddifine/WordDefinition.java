package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.worddifine;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * 查询结果单词映射
 * Created by wally on 4/10/17.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class WordDefinition {

    /**
     * 发音
     */
    private Pronunciation pronunciations;
    /**
     * 英文含义
     */
    private EnMean en_definitions;
    /**
     * 语音信息
     */
    private AudioAddress audio_addresses;
    /**
     * 中文含义
     */
    private String definition;
    /**
     *
     */
    private int num_sense;
    /**
     * 单词Id
     */
    private int id;
    /**
     * 是否有语音
     */
    private boolean has_audio;

    /**
     * 单词
     */
    private String content;

    private String audio;

    private String us_audio;

    private String uk_audio;

    private String pronunciation;

    public Pronunciation getPronunciations() {
        return pronunciations;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUk_audio() {
        return uk_audio;
    }

    public void setUk_audio(String uk_audio) {
        this.uk_audio = uk_audio;
    }

    public void setPronunciations(Pronunciation pronunciations) {
        this.pronunciations = pronunciations;
    }

    public EnMean getEn_definitions() {
        return en_definitions;
    }

    public void setEn_definitions(EnMean en_definitions) {
        this.en_definitions = en_definitions;
    }

    public AudioAddress getAudio_addresses() {
        return audio_addresses;
    }

    public void setAudio_addresses(AudioAddress audio_addresses) {
        this.audio_addresses = audio_addresses;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public int getNum_sense() {
        return num_sense;
    }

    public void setNum_sense(int num_sense) {
        this.num_sense = num_sense;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isHas_audio() {
        return has_audio;
    }

    public void setHas_audio(boolean has_audio) {
        this.has_audio = has_audio;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }

    public String getUs_audio() {
        return us_audio;
    }

    public void setUs_audio(String us_audio) {
        this.us_audio = us_audio;
    }

    public String getPronunciation() {
        return pronunciation;
    }

    public void setPronunciation(String pronunciation) {
        this.pronunciation = pronunciation;
    }
}
