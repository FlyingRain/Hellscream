package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

/**
 * Created by wally on 6/29/17.
 */
public class EncryptTest {

    @Test
    public void testMD5Encrypt() {
        String ss = "{\"phone\":\"17626189012\",\"password\":\"z6QG2amzQLoSbZFnWW2L+2YtjN/1PCojn/Z/ugg/bjYuLSsdF8pHmpOSI3tglLkj2Lx+r2J/EeQoECMpacX3mwN1AEbE3a7gUU7sQfd7XCxPcbAzx3vC7kRaPNKdAiJiw/KSb2UcSF7ITJGhtrFz7eblJui/W3hEgjZRKI8RtXY=\"}";
        String a = "{\"phone\":\"17626189012\":\"password\":\"123456\"}";
        String msg = "{\"wxNo\":\"321123\",\"loginRequest\":{\"phone\":\"17626189012\",\"password\":\"123456\"}}123456";
        String encryptMsg = EncryptUtil.encryptWithMD5(msg);
        System.out.println(encryptMsg);
    }


    @Test
    public void test3DESEncrypt() {
        String keyPath = "/home/wally/workspace/myprojects/github/Hellscream/certs/3desKey.key";
        String target = "{\"sign\":\"FlF4WnLlTLNniRBOAapvw6GoFatLDpmIc7cILqws6oP0cFcyD1BOXknTzVtWxo259dZdm8r7QPgM47DR06o02Nk1M9PAYOHZUXojJ17dw5YJ/LhDbPBsvomTk+aKoof3PPTVkPDLAe6vIl/++5HYzY9DkCYxLYe7WNNkZqhDxLY=\",\"param\":\"{\\\"wxNo\\\":\\\"321123\\\",\\\"loginRequest\\\":{\\\"phone\\\":\\\"17626189012\\\",\\\"password\\\":\\\"123456\\\"}}\"}";
        String result = EncryptUtil.encryptBy3DES(keyPath, target);
        System.out.println("encrypt result is : " + result);
        String plainText = EncryptUtil.decryptBy3DES(keyPath, result);
        System.out.println("decrypt result is : " +  plainText);
    }

    @Test
    public void testRSAEncrypt() {
        String privateKeyPath = "/home/wally/workspace/myprojects/github/Hellscream/certs/flyingrain_pkcs8_private.pem";
        String publicKeyPath = "/home/wally/workspace/myprojects/github/Hellscream/certs/flyingrain_pub.pem";
        String msg = "123456";
        String encryptMsg = EncryptUtil.encryptWithRSA(msg, privateKeyPath, true);
        System.out.println(encryptMsg);
        String encryptMsg2 = EncryptUtil.encryptWithRSA(msg, publicKeyPath, false);
        System.out.println(encryptMsg2);

        encryptMsg = "+WQFxghV6DAh09aD9Hmxla/eLfdNAAepAqYDhIFbNTcvQzJ8p9PIChXRmVYnGve/oT6IDGOWTb2B5qOIwPnXQaE3PJ4z5hrYrjb+f/4eAxCzAOUVUjEuvulIQlUnkKUsnCMJxvQvDWscU1qb6wazZwrfI87PMKBDM6Ktzq4LPWg=";

//        String plainMsg = EncryptUtil.decryptMsgWithRSA(encryptMsg,publicKeyPath,false);
//        System.out.println(plainMsg);
        String plainMsg2 = EncryptUtil.decryptMsgWithRSA(encryptMsg, privateKeyPath, true);
        System.out.println(plainMsg2);

    }
}
