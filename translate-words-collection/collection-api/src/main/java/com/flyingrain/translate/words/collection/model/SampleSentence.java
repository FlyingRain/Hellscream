package com.flyingrain.translate.words.collection.model;

import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
public class SampleSentence {

    private String id;

    private String wordId;

    private String word;

    private List<Sentence> sentences;


    class Sentence{
        private String sentence;

        private String transaction;

        private String first;

        private String last;

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

        @Override
        public String toString() {
            return "Sentence{" +
                    "sentence='" + sentence + '\'' +
                    ", transaction='" + transaction + '\'' +
                    ", first='" + first + '\'' +
                    ", last='" + last + '\'' +
                    '}';
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getWordId() {
        return wordId;
    }

    public void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    @Override
    public String toString() {
        return "SampleSentence{" +
                "id='" + id + '\'' +
                ", wordId='" + wordId + '\'' +
                ", word='" + word + '\'' +
                ", sentences=" + sentences +
                '}';
    }
}
