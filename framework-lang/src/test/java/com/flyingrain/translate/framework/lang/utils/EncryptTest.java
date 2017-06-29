package com.flyingrain.translate.framework.lang.utils;

import org.junit.Test;

/**
 * Created by wally on 6/29/17.
 */
public class EncryptTest {

    @Test
    public void testMD5Encrypt(){
        String msg = "dfhiasihdioasdiuhpaspidufpoahsdfuhpaspduihasdflkasdjflasdfglgfasdfkgasdlfgasldfghalsfgolas";
        String encryptMsg = EncryptUtil.encryptWithMD5(msg);
        System.out.println(encryptMsg);
    }

    @Test
    public void testRSAEncrypt(){
        String privateKeyPath = "/home/wally/keys/java_private.key";
        String publicKeyPath = "/home/wally/keys/pub.key";
        String msg = "测试报文";
        String encryptMsg = EncryptUtil.encryptWithRSA(msg,privateKeyPath,true);
        System.out.println(encryptMsg);
        String encryptMsg2 = EncryptUtil.encryptWithRSA(msg,publicKeyPath,false);
        System.out.println(encryptMsg2);

        String plainMsg = EncryptUtil.decryptMsgWithRSA(encryptMsg,publicKeyPath,false);
        System.out.println(plainMsg);
        String plainMsg2 = EncryptUtil.decryptMsgWithRSA(encryptMsg2,privateKeyPath,true);
        System.out.println(plainMsg2);

    }
}
