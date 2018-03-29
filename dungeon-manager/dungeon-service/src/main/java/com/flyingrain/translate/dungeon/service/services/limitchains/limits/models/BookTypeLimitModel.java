package com.flyingrain.translate.dungeon.service.services.limitchains.limits.models;

/**
 * Created by wally on 10/31/17.
 */
public class BookTypeLimitModel extends AbstractLimitModel{

    private int bookType;


    public int getBookType() {
        return bookType;
    }

    public void setBookType(int bookType) {
        this.bookType = bookType;
    }

    @Override
    public String toString() {
        return "BookTypeLimitModel{" +
                "bookType=" + bookType +
                '}';
    }
}
