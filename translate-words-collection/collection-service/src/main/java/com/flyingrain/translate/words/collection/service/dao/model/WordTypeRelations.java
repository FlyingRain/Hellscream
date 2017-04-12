package com.flyingrain.translate.words.collection.service.dao.model;

import java.util.Date;

/**
 * Created by wally on 4/12/17.
 */
public class WordTypeRelations {
    private int word_id;

    private int type_code;

    private Date data_added;

    private Date last_modified;

    public int getWord_id() {
        return word_id;
    }

    public void setWord_id(int word_id) {
        this.word_id = word_id;
    }

    public int getType_code() {
        return type_code;
    }

    public void setType_code(int type_code) {
        this.type_code = type_code;
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
        return "WordTypeRelations{" +
                "word_id=" + word_id +
                ", type_code=" + type_code +
                ", data_added=" + data_added +
                ", last_modified=" + last_modified +
                '}';
    }
}
