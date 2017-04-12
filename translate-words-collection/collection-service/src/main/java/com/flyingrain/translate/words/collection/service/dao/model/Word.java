package com.flyingrain.translate.words.collection.service.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/12/17.
 */
public class Word {
    private int id;
    private String word;
    private String channel_word_id;
    private String uk_pronunciation;
    private String channel_code;
    private int has_audio;
    private String us_pronunciation;
    private String default_audio;
    private String mean;
    private Date data_added;
    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChannel_word_id() {
        return channel_word_id;
    }

    public void setChannel_word_id(String channel_word_id) {
        this.channel_word_id = channel_word_id;
    }

    public String getUk_pronunciation() {
        return uk_pronunciation;
    }

    public void setUk_pronunciation(String uk_pronunciation) {
        this.uk_pronunciation = uk_pronunciation;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public int getHas_audio() {
        return has_audio;
    }

    public void setHas_audio(int has_audio) {
        this.has_audio = has_audio;
    }

    public String getUs_pronunciation() {
        return us_pronunciation;
    }

    public void setUs_pronunciation(String us_pronunciation) {
        this.us_pronunciation = us_pronunciation;
    }

    public String getDefault_audio() {
        return default_audio;
    }

    public void setDefault_audio(String default_audio) {
        this.default_audio = default_audio;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Date getData_added() {
        return data_added;
    }

    public void setData_added(Date data_added) {
        this.data_added = data_added;
    }

    public Date getLast_modified() {
        return last_modified;
    }

    public void setLast_modified(Date last_modified) {
        this.last_modified = last_modified;
    }

    @Override
    public String toString() {
        return "Word{" +
                "id=" + id +
                ", word='" + word + '\'' +
                ", channel_word_id='" + channel_word_id + '\'' +
                ", uk_pronunciation='" + uk_pronunciation + '\'' +
                ", channel_code='" + channel_code + '\'' +
                ", has_audio=" + has_audio +
                ", us_pronunciation='" + us_pronunciation + '\'' +
                ", default_audio='" + default_audio + '\'' +
                ", mean='" + mean + '\'' +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
