package com.flyingrain.translate.words.collection.service.dao.model;

/**
 * Created by wally on 4/17/17.
 */
public class WordSentence {
    private String id;

    private String sentence;

    private String transaction;

    private int like;

    private int unlike;

    private int word_id;

    private int channel_id;

    private String first;

    private String last;

    private String word;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSentence() {
        return sentence;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getUnlike() {
        return unlike;
    }

    public void setUnlike(int unlike) {
        this.unlike = unlike;
    }

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public int getChannel_id() {
        return channel_id;
    }

    public void setChannel_id(int channel_id) {
        this.channel_id = channel_id;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    @Override
    public String toString() {
        return "WordSentence{" +
                "id='" + id + '\'' +
                ", sentence='" + sentence + '\'' +
                ", transaction='" + transaction + '\'' +
                ", like=" + like +
                ", unlike=" + unlike +
                ", word_id=" + word_id +
                ", channel_id=" + channel_id +
                ", first='" + first + '\'' +
                ", last='" + last + '\'' +
                ", word='" + word + '\'' +
                '}';
    }
}
