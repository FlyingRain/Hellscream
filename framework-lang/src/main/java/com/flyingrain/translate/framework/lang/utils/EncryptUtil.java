package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Decoder;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 加密解密工具
 * Created by wally on 6/29/17.
 */
public class EncryptUtil {

    private static Logger logger = LoggerFactory.getLogger(EncryptUtil.class);

    private static ConcurrentHashMap<String, PrivateKey> privateKeys = new ConcurrentHashMap<>();

    private static ConcurrentHashMap<String, PublicKey> publicKeys = new ConcurrentHashMap<>();

    private static BASE64Decoder base64Decoder = new BASE64Decoder();

    public static String encryptWithMD5(String msg) {
        try {
            logger.info("start to encrypt msg:[{}]", msg);
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte [] encryptByte = digest.digest(msg.getBytes("utf-8"));
            String result = bytesToHex(encryptByte);
            String enCodeMsg = Base64.getEncoder().encodeToString(result.getBytes());
            logger.info("encrypt msg is [{}]", enCodeMsg);
            return enCodeMsg;
        } catch (NoSuchAlgorithmException e) {
            logger.error("get encrypt algorithm failed!", e);
            throw new FlyException(FrameworkExceptionCode.ENCRYPTERROR.getCode(), FrameworkExceptionCode.ENCRYPTERROR.getMsg());
        } catch (UnsupportedEncodingException e) {
            logger.error("encode msg error", e);
            throw new FlyException(FrameworkExceptionCode.ENCRYPTERROR.getCode(), FrameworkExceptionCode.ENCRYPTERROR.getMsg());
        }


    }

    /**
     *
     * 把md5结果转换为16进制
     * @param bytes
     * @return
     */
    public static String bytesToHex(byte[] bytes) {
        StringBuffer md5str = new StringBuffer();
        // 把数组每一字节换成16进制连成md5字符串
        int digital;
        for (int i = 0; i < bytes.length; i++) {
            digital = bytes[i];

            if (digital < 0) {
                digital += 256;
            }
            if (digital < 16) {
                md5str.append("0");
            }
            md5str.append(Integer.toHexString(digital));
        }
        return md5str.toString().toUpperCase();
    }

    /**
     * 通过RSA加密报文
     *
     * @param msg       原文
     * @param keyPath   密钥地址
     * @param isPrivate 是否用私钥加密
     * @return 加密结果
     */
    public static String encryptWithRSA(String msg, String keyPath, boolean isPrivate) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            if (isPrivate) {
                PrivateKey privateKey = loadRSAPrivateKey(keyPath);
                cipher.init(Cipher.ENCRYPT_MODE, privateKey);
            } else {
                PublicKey publicKey = loadRSAPublicKey(keyPath);
                cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            }
            byte[] encryptByteMsg = cipher.doFinal(msg.getBytes("utf-8"));
            String encryptMsg = Base64.getEncoder().encodeToString(encryptByteMsg);
            logger.info("get encryptMsg:[{}]", encryptMsg);
            return encryptMsg;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | BadPaddingException | UnsupportedEncodingException | IllegalBlockSizeException e) {
            logger.error("encrypt error", e);
            throw new FlyException(FrameworkExceptionCode.ENCRYPTERROR.getCode(), FrameworkExceptionCode.ENCRYPTERROR.getMsg());
        }

    }

    /**
     * 使用RSA解密报文
     *
     * @param encryptMsg 加密报文
     * @param keyPath    密钥地址
     * @param isPrivate  是否是私钥
     * @return 原文
     */
    public static String decryptMsgWithRSA(String encryptMsg, String keyPath, boolean isPrivate) {
        try {
            Cipher cipher = Cipher.getInstance("RSA");
            if (isPrivate) {
                PrivateKey privateKey = loadRSAPrivateKey(keyPath);
                cipher.init(Cipher.DECRYPT_MODE, privateKey);
            } else {
                PublicKey publicKey = loadRSAPublicKey(keyPath);
                cipher.init(Cipher.DECRYPT_MODE, publicKey);
            }
            byte[] encryptByte = Base64.getDecoder().decode(encryptMsg.getBytes());
            byte[] plainByteMsg = cipher.doFinal(encryptByte);
            return new String(plainByteMsg);
        } catch (NoSuchAlgorithmException |NoSuchPaddingException |InvalidKeyException|BadPaddingException|IllegalBlockSizeException  e) {
            logger.error("decrypt error!",e);
            throw new FlyException(FrameworkExceptionCode.DECRYPTERROR.getCode(),FrameworkExceptionCode.DECRYPTERROR.getMsg());
        }
    }


    private static String readFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String keyContent = null;
            StringBuilder key = new StringBuilder();
            while ((keyContent = reader.readLine()) != null) {
                if (keyContent.charAt(0) == '-') {
                    continue;
                }
                key.append(keyContent);
                key.append("\r");
            }
            return key.toString();
        } catch (FileNotFoundException e) {
            logger.error("file not found! path is :[{}]", filePath);
            logger.error("exception is ", e);
            throw new FlyException(FrameworkExceptionCode.FILENOTFOUND.getCode(), FrameworkExceptionCode.FILENOTFOUND.getMsg());
        } catch (IOException e) {
            logger.error("io exception!", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }
    }

    /**
     * 装载私钥
     *
     * @param privateKeyPath 私钥地址
     * @return 私钥
     */
    private static PrivateKey loadRSAPrivateKey(String privateKeyPath) {
        PrivateKey privateKey = privateKeys.get(privateKeyPath);
        if (privateKey != null) {
            return privateKey;
        }
        String keyContent = readFile(privateKeyPath);
        try {
            byte decodeKey[] = base64Decoder.decodeBuffer(keyContent);
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(decodeKey);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            privateKey = keyFactory.generatePrivate(keySpec);
            PrivateKey key = privateKeys.putIfAbsent(privateKeyPath, privateKey);
            if (key != null) {
                return key;
            }
            return privateKey;
        } catch (IOException e) {
            logger.error("IoException", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("get algorithm error!", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }
    }

    /**
     * 有密码的密钥读取
     * @param path
     * @param pwd
     * @return
     */
    public static PrivateKey loadRSAPrivateKey(String path, String pwd) {
        PrivateKey privateKey = privateKeys.get(path);
        if (privateKey != null) {
            return privateKey;
        }
        try (FileInputStream fis =  new FileInputStream(path);){
            KeyStore e = KeyStore.getInstance(KeyStore.getDefaultType());
            char[] nPassword = null;
            if(pwd != null && !pwd.trim().equals("")) {
                nPassword = pwd.toCharArray();
            }
            e.load(fis, null);
            Enumeration en = e.aliases();
            String keyAlias = null;
            if(en.hasMoreElements()) {
                keyAlias = (String)en.nextElement();
            }

            privateKey = (PrivateKey)e.getKey(keyAlias, nPassword);

            PrivateKey key = privateKeys.putIfAbsent(path, privateKey);
            if (key != null) {
                return key;
            }
            return privateKey;
        } catch (KeyStoreException |CertificateException|IOException|UnrecoverableKeyException|NoSuchAlgorithmException e) {
            logger.error("load privateKey failed!",e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
        }
    }



    private static PublicKey loadRSAPublicKey(String publicKeyPath) {
        PublicKey publicKey = publicKeys.get(publicKeyPath);
        if (publicKey != null) {
            return publicKey;
        }
        String keyContent = readFile(publicKeyPath);
        try {
            byte[] decodeKey = base64Decoder.decodeBuffer(keyContent);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(decodeKey);
            publicKey = keyFactory.generatePublic(keySpec);
            PublicKey key = publicKeys.putIfAbsent(publicKeyPath, publicKey);
            if (key != null) {
                return key;
            }
            return publicKey;
        } catch (IOException e) {
            logger.error("IoException", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            logger.error("get algorithm error!", e);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }
    }


}
