package com.flyingrain.translate.words.collection.service.collect.impl;

/**
 * Created by wally on 4/11/17.
 */
public class Counter {
    private static int nowCount=0;

    public static synchronized boolean isEnd(int maxLoad,int num){
        if(nowCount<num){
            nowCount+= maxLoad;
            return false;
        }else{
            return true;
        }
    }
    public static int getNowCount(){
        return nowCount;
    }
}
