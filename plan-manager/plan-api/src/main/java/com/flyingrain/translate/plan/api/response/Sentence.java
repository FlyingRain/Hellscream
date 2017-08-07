package com.flyingrain.translate.plan.api.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by wally on 6/26/17.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Sentence {
    private String word;
    private int wordId;
    private List<Mysentence> mysentences;

    @JsonIgnore
    public Mysentence getMySentenceInstance() {
        return new Mysentence();
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordId() {
        return this.wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }

    public List<Mysentence> getMysentences() {
        return this.mysentences;
    }

    public void setMysentences(List<Mysentence> mysentences) {
        this.mysentences = mysentences;
    }

    public String toString() {
        return "SentenceDefine{, word=\'" + this.word + '\'' + ", wordId=" + this.wordId + ", mysentences=" + this.mysentences + '}';
    }

    public static class Mysentence {
        private String first;
        private String last;
        private String translation;
        private int like;
        private int unlike;

        public Mysentence() {
        }

        public String getFirst() {
            return this.first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getLast() {
            return this.last;
        }

        public void setLast(String last) {
            this.last = last;
        }

        public String getTranslation() {
            return this.translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
        }

        public int getLike() {
            return this.like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getUnlike() {
            return this.unlike;
        }

        public void setUnlike(int unlike) {
            this.unlike = unlike;
        }
    }
}
