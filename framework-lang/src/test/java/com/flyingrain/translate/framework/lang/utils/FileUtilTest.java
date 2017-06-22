package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

/**
 * Created by wally on 6/22/17.
 */
public class FileUtilTest {


    @Test
    public void testFileUtil(){
        String path = "/home/wally/Documents/plan/20170623";
        String filName = "test.txt";
        String content = "{\"test\":12}";
        FileUtil.saveFile(path,filName,content);
    }
}
