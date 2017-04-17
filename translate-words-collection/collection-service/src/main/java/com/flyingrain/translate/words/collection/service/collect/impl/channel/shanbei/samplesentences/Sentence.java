package com.flyingrain.translate.words.collection.service.collect.impl.channel.shanbei.samplesentences;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by wally on 4/17/17.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Sentence {

    private String vocabulary_id;

    private String word;

    private String id;

    private String last;

    private String translation;

    private String annotation;

    private String first;

    public String getVocabulary_id() {
        return vocabulary_id;
    }

    public void setVocabulary_id(String vocabulary_id) {
        this.vocabulary_id = vocabulary_id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getAnnotation() {
        return annotation;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    @Override
    public String toString() {
        return "Sentence{" +
                "vocabulary_id='" + vocabulary_id + '\'' +
                ", word='" + word + '\'' +
                ", id='" + id + '\'' +
                ", last='" + last + '\'' +
                ", translation='" + translation + '\'' +
                ", annotation='" + annotation + '\'' +
                ", first='" + first + '\'' +
                '}';
    }
}
