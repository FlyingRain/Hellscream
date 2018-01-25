package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

/**
 * Created by wally on 6/29/17.
 */
public class EncryptTest {

    @Test
    public void testMD5Encrypt(){
        String ss = "{\"phone\":\"17626189012\",\"password\":\"z6QG2amzQLoSbZFnWW2L+2YtjN/1PCojn/Z/ugg/bjYuLSsdF8pHmpOSI3tglLkj2Lx+r2J/EeQoECMpacX3mwN1AEbE3a7gUU7sQfd7XCxPcbAzx3vC7kRaPNKdAiJiw/KSb2UcSF7ITJGhtrFz7eblJui/W3hEgjZRKI8RtXY=\"}";
        String a = "{\"phone\":\"17626189012\":\"password\":\"123456\"}";
        String msg ="{\"phone\":\"18635232287\",\"password\":\"123321\"}null";
        String encryptMsg = EncryptUtil.encryptWithMD5(msg);
        System.out.println(encryptMsg);
    }


    @Test
    public void testRSAEncrypt(){
        String privateKeyPath = "/home/wally/workspace/github/flyingrain/Hellscream/certs/flyingrain_pkcs8_private.pem";
        String publicKeyPath = "/home/wally/workspace/github/flyingrain/Hellscream/certs/flyingrain_pub.pem";
        String msg = "123456";
        String encryptMsg = EncryptUtil.encryptWithRSA(msg,privateKeyPath,true);
        System.out.println(encryptMsg);
        String encryptMsg2 = EncryptUtil.encryptWithRSA(msg,publicKeyPath,false);
        System.out.println(encryptMsg2);

        encryptMsg="+WQFxghV6DAh09aD9Hmxla/eLfdNAAepAqYDhIFbNTcvQzJ8p9PIChXRmVYnGve/oT6IDGOWTb2B5qOIwPnXQaE3PJ4z5hrYrjb+f/4eAxCzAOUVUjEuvulIQlUnkKUsnCMJxvQvDWscU1qb6wazZwrfI87PMKBDM6Ktzq4LPWg=";

//        String plainMsg = EncryptUtil.decryptMsgWithRSA(encryptMsg,publicKeyPath,false);
//        System.out.println(plainMsg);
        String plainMsg2 = EncryptUtil.decryptMsgWithRSA(encryptMsg,privateKeyPath,true);
        System.out.println(plainMsg2);

    }
}
