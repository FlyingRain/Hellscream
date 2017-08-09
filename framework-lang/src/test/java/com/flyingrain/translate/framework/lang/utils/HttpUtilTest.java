package com.flyingrain.translate.framework.lang.utils;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wally on 17-8-8.
 */
public class HttpUtilTest {


    private Map<String,String> params;

    private Map<String,String> headers;

    @Before
    public void init(){
        params = new HashMap<>();
        params.put("token","asdf");
        params.put("url","asd");

        headers =new HashMap<>();
        headers.put("Content-Type","application/json");

    }


    @Test
    public void testHttpUtil(){

        String url = "http://localhost:8088/translate/auth/userAuth";
        String result = HttpUtil.sendPostForJson(params,headers,url);
        System.out.println(result);
    }

}
