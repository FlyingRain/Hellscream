package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

/**
 * Created by wally on 6/29/17.
 */
public class EncryptTest {

    @Test
    public void testMD5Encrypt(){
        String ss = "{\"phone\":\"17626189012\",\"password\":\"+WQFxghV6DAh09aD9Hmxla/eLfdNAAepAqYDhIFbNTcvQzJ8p9PIChXRmVYnGve/oT6IDGOWTb2B5qOIwPnXQaE3PJ4z5hrYrjb+f/4eAxCzAOUVUjEuvulIQlUnkKUsnCMJxvQvDWscU1qb6wazZwrfI87PMKBDM6Ktzq4LPWg=\"}";
        String msg ="{\"phone\":\"18635232287\",\"password\":\"123321\"}null";
        String encryptMsg = EncryptUtil.encryptWithMD5(msg);
        System.out.println(encryptMsg);
    }


    public void testRSAEncrypt(){
        String privateKeyPath = "/home/wally/workspace/myprojects/github/Hellscream/certs/flyingrain_pkcs8_private.pem";
        String publicKeyPath = "/home/wally/workspace/myprojects/github/Hellscream/certs/flyingrain_pub.pem";
        String msg = "123456";
        String encryptMsg = EncryptUtil.encryptWithRSA(msg,privateKeyPath,true);
        System.out.println(encryptMsg);
        String encryptMsg2 = EncryptUtil.encryptWithRSA(msg,publicKeyPath,false);
        System.out.println(encryptMsg2);

        encryptMsg="g2201fcoSmg9kQTSncMshktkD4RpDVkJYdohUfSs1n6jCw+4e88ZoHZ0q5Wt/aEadPgBU/QEzkA34ZShho4K7HbnFMyHPIq7zsyYK8X8BqtjkU4ZpwRuUrKp3ZIq8l80vsb/gWIRvK8hezQGD9ydI7PguqbczShqiRwFG/AG4yQ=";

        String plainMsg = EncryptUtil.decryptMsgWithRSA(encryptMsg,publicKeyPath,false);
        System.out.println(plainMsg);
        String plainMsg2 = EncryptUtil.decryptMsgWithRSA(encryptMsg2,privateKeyPath,true);
        System.out.println(plainMsg2);

    }
}
