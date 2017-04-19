package com.flyingrain.translate.words.collection.model;

import java.util.List;

/**
 * Created by wally on 4/14/17.
 */
public class WordResult {

    private int wordId;

    private String word;

    private String mean;

    private List<String> v;

    private List<String> n;

    private List<String> adj;

    private List<String> adv;

    private String ukPronunciation;

    private String usPronunciation;

    private List<String> ukAudio;

    private List<String> usAudio;

    private String defaultAudio;

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public List<String> getV() {
        return v;
    }

    public void setV(List<String> v) {
        this.v = v;
    }

    public List<String> getN() {
        return n;
    }

    public void setN(List<String> n) {
        this.n = n;
    }

    public List<String> getAdj() {
        return adj;
    }

    public void setAdj(List<String> adj) {
        this.adj = adj;
    }

    public String getDefaultAudio() {
        return defaultAudio;
    }

    public void setDefaultAudio(String defaultAudio) {
        this.defaultAudio = defaultAudio;
    }

    public List<String> getAdv() {
        return adv;
    }

    public void setAdv(List<String> adv) {
        this.adv = adv;
    }

    public String getUkPronunciation() {
        return ukPronunciation;
    }

    public void setUkPronunciation(String ukPronunciation) {
        this.ukPronunciation = ukPronunciation;
    }

    public String getUsPronunciation() {
        return usPronunciation;
    }

    public void setUsPronunciation(String usPronunciation) {
        this.usPronunciation = usPronunciation;
    }

    public List<String> getUkAudio() {
        return ukAudio;
    }

    public void setUkAudio(List<String> ukAudio) {
        this.ukAudio = ukAudio;
    }

    public List<String> getUsAudio() {
        return usAudio;
    }

    public void setUsAudio(List<String> usAudio) {
        this.usAudio = usAudio;
    }

    @Override
    public String toString() {
        return "WordResult{" +
                "wordId=" + wordId +
                ", word='" + word + '\'' +
                ", mean='" + mean + '\'' +
                ", v=" + v +
                ", n=" + n +
                ", adj=" + adj +
                ", adv=" + adv +
                ", ukPronunciation='" + ukPronunciation + '\'' +
                ", usPronunciation='" + usPronunciation + '\'' +
                ", ukAudio=" + ukAudio +
                ", usAudio=" + usAudio +
                ", defaultAudio='" + defaultAudio + '\'' +
                '}';
    }
}
