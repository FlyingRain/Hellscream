package com.flyingrain.translate.words.collection.service.collect.impl.channel;

/**
 * Created by wally on 4/17/17.
 */
public class QueryRequest {

    private String id;

    private String word;

    private String channelWordId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChannelWordId() {
        return channelWordId;
    }

    public void setChannelWordId(String channelWordId) {
        this.channelWordId = channelWordId;
    }

    @Override
    public String toString() {
        return "QueryRequest{" +
                "id='" + id + '\'' +
                ", word='" + word + '\'' +
                ", channelWordId='" + channelWordId + '\'' +
                '}';
    }
}
