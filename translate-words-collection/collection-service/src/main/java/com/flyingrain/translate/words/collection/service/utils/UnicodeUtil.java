package com.flyingrain.translate.words.collection.service.utils;

/**
 * Created by wally on 4/10/17.
 */
public class UnicodeUtil {

    public static String unicodeToString(String unicode){
        StringBuilder sb = new StringBuilder();
        int i = -1;
        int pos = 0;

        while((i=unicode.indexOf("\\u", pos)) != -1){
            sb.append(unicode.substring(pos, i));
            if(i+5 < unicode.length()){
                pos = i+6;
                sb.append((char)Integer.parseInt(unicode.substring(i+2, i+6), 16));
            }
        }
        return sb.toString();
    }

}
