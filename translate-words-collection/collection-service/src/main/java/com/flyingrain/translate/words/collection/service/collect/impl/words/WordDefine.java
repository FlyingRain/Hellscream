package com.flyingrain.translate.words.collection.service.collect.impl.words;

import com.flyingrain.translate.words.collection.model.WordType;

import java.util.List;

/**
 * Created by wally on 4/11/17.
 */
public class WordDefine {
    private String id;
    /**
     * 单词
     */
    private String content;
    /**
     * 英式发音
     */
    private String uk_pronunciation;
    /**
     * 美式发音
     */
    private String us_pronunciation;
    /**
     * 是否有录音
     */
    private boolean has_audio = true;
    /**
     * 英式录音
     */
    private List<String> uk_audio_address;
    /**
     * 美式录音
     */
    private List<String> us_audio_address;
    /**
     * 渠道Id
     */
    private String channel_word_id;
    /**
     * 渠道
     */
    private String channel_code;
    /**
     * 中文翻译
     */
    private String means;
    /**
     * 类型
     *
     * @see WordType
     */
    private int type;
    /**
     * 名词含义
     */
    private List<String> en_n;
    /**
     * 动词含义
     */
    private List<String> en_v;
    /**
     * 形容词含义
     */
    private List<String> en_adj;
    /**
     * 副词含义
     */
    private List<String> en_adv;
    /**
     * 不及物动词含义
     */
    private List<String> en_vi;
    /**
     * 及物动词含义
     */
    private List<String> en_vt;


    public WordDefine() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUk_pronunciation() {
        return uk_pronunciation;
    }

    public void setUk_pronunciation(String uk_pronunciation) {
        this.uk_pronunciation = uk_pronunciation;
    }

    public String getUs_pronunciation() {
        return us_pronunciation;
    }

    public void setUs_pronunciation(String us_pronunciation) {
        this.us_pronunciation = us_pronunciation;
    }

    public boolean isHas_audio() {
        return has_audio;
    }

    public void setHas_audio(boolean has_audio) {
        this.has_audio = has_audio;
    }

    public String getChannel_word_id() {
        return channel_word_id;
    }

    public List<String> getUk_audio_address() {
        return uk_audio_address;
    }

    public void setUk_audio_address(List<String> uk_audio_address) {
        this.uk_audio_address = uk_audio_address;
    }

    public List<String> getUs_audio_address() {
        return us_audio_address;
    }

    public void setUs_audio_address(List<String> us_audio_address) {
        this.us_audio_address = us_audio_address;
    }

    public void setChannel_word_id(String channel_word_id) {
        this.channel_word_id = channel_word_id;
    }

    public String getChannel_code() {
        return channel_code;
    }

    public void setChannel_code(String channel_code) {
        this.channel_code = channel_code;
    }

    public String getMeans() {
        return means;
    }

    public void setMeans(String means) {
        this.means = means;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public List<String> getEn_n() {
        return en_n;
    }

    public void setEn_n(List<String> en_n) {
        this.en_n = en_n;
    }

    public List<String> getEn_v() {
        return en_v;
    }

    public void setEn_v(List<String> en_v) {
        this.en_v = en_v;
    }

    public List<String> getEn_adj() {
        return en_adj;
    }

    public void setEn_adj(List<String> en_adj) {
        this.en_adj = en_adj;
    }

    public List<String> getEn_adv() {
        return en_adv;
    }

    public void setEn_adv(List<String> en_adv) {
        this.en_adv = en_adv;
    }

    public List<String> getEn_vi() {
        return en_vi;
    }

    public void setEn_vi(List<String> en_vi) {
        this.en_vi = en_vi;
    }

    public List<String> getEn_vt() {
        return en_vt;
    }

    public void setEn_vt(List<String> en_vt) {
        this.en_vt = en_vt;
    }

    @Override
    public String toString() {
        return "WordDefine{" +
                "id='" + id + '\'' +
                ", content='" + content + '\'' +
                ", uk_pronunciation='" + uk_pronunciation + '\'' +
                ", us_pronunciation='" + us_pronunciation + '\'' +
                ", has_audio=" + has_audio +
                ", uk_audio_address=" + uk_audio_address +
                ", us_audio_address=" + us_audio_address +
                ", channel_word_id='" + channel_word_id + '\'' +
                ", channel_code='" + channel_code + '\'' +
                ", means='" + means + '\'' +
                ", type=" + type +
                ", en_n=" + en_n +
                ", en_v=" + en_v +
                ", en_adj=" + en_adj +
                ", en_adv=" + en_adv +
                ", en_vi=" + en_vi +
                ", en_vt=" + en_vt +
                '}';
    }
}
