package com.flyingrain.translate.words.collection.result;

/**
 * Created by wally on 4/21/17.
 */
public class Book {
    private int id;

    private String name;

    private int type;

    private int wordNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWordNumber() {
        return wordNumber;
    }

    public void setWordNumber(int wordNumber) {
        this.wordNumber = wordNumber;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", wordNumber=" + wordNumber +
                '}';
    }
}
