package com.flyingrain.translate.words.collection.service.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/12/17.
 */
public class Audio {
    private int id;
    private int word_id;
    private String channel_audio_address;
    private String audio_address;
    private String audio_type;
    private Date data_added;
    private Date last_modified;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public String getChannel_audio_address() {
        return channel_audio_address;
    }

    public void setChannel_audio_address(String channel_audio_address) {
        this.channel_audio_address = channel_audio_address;
    }

    public String getAudio_address() {
        return audio_address;
    }

    public void setAudio_address(String audio_address) {
        this.audio_address = audio_address;
    }

    public String getAudio_type() {
        return audio_type;
    }

    public void setAudio_type(String audio_type) {
        this.audio_type = audio_type;
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
        return "Audio{" +
                "id=" + id +
                ", word_id=" + word_id +
                ", channel_audio_address='" + channel_audio_address + '\'' +
                ", audio_address='" + audio_address + '\'' +
                ", audio_type='" + audio_type + '\'' +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
