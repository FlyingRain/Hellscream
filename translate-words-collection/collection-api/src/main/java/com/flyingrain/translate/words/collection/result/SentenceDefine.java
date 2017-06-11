package com.flyingrain.translate.words.collection.result;

import java.util.List;

/**
 * Created by wally on 4/17/17.
 */
public class SentenceDefine {

    private String word;

    private int wordId;

    private List<Mysentence> mysentences;

    public class Mysentence{
        private String first;

        private String last;

        private String translation;

        private int like;

        private int unlike;

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

        public String getTranslation() {
            return translation;
        }

        public void setTranslation(String translation) {
            this.translation = translation;
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
    }

    public Mysentence getMySentenceInstance(){
        return new Mysentence();
    }


    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getWordId() {
        return wordId;
    }

    public void setWordId(int wordId) {
        this.wordId = wordId;
    }


    public List<Mysentence> getMysentences() {
        return mysentences;
    }

    public void setMysentences(List<Mysentence> mysentences) {
        this.mysentences = mysentences;
    }

    @Override
    public String toString() {
        return "SentenceDefine{" +
                ", word='" + word + '\'' +
                ", wordId=" + wordId +
                ", mysentences=" + mysentences +
                '}';
    }
}
