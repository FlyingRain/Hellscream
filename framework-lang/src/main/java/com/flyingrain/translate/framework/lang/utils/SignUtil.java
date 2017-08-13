package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import com.flyingrain.translate.framework.lang.utils.model.SignModel;
import com.flyingrain.translate.framework.lang.utils.model.VerifySignModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 内部签名验签工具
 * Created by wally on 8/3/17.
 */
public class SignUtil {

    private static Logger logger = LoggerFactory.getLogger(SignUtil.class);

    private static String salt;

    static {
        Properties properties = new Properties();
        try {
            properties.load(SignUtil.class.getResourceAsStream("/sign.properties"));
        } catch (IOException e) {
            logger.error("load sign.properties error!");
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(), FrameworkExceptionCode.SYSERROR.getMsg());
        }
        salt = properties.getProperty("sign.salt");
    }

    /**
     * 获得签名
     *
     * @param signModel
     * @return
     */
    public static String sign(SignModel signModel) {
        String md5Encrypt = EncryptUtil.encryptWithMD5(signModel.getPlainContent() + salt);
        switch (signModel.getAlgorithm()) {
            case RSA: {
                return EncryptUtil.encryptWithRSA(md5Encrypt, signModel.getKeyPath(), signModel.isPrivate());
            }
            default: {
                logger.error("not support the algorithm![{}]", signModel.getAlgorithm().getAlgorithm());
                throw new FlyException(FrameworkExceptionCode.SIGNFAIL.getCode(), FrameworkExceptionCode.SIGNFAIL.getMsg());
            }
        }
    }


    public static boolean verifySign(VerifySignModel verifySignModel) {
        String md5Encrypt = EncryptUtil.encryptWithMD5(verifySignModel.getPlainContent() + salt);
        switch (verifySignModel.getAlgorithm()) {
            case RSA: {
                String decrypt = EncryptUtil.decryptMsgWithRSA(verifySignModel.getSign(), verifySignModel.getKeyPath(), verifySignModel.isPrivate());
                return md5Encrypt.equals(decrypt);
            }
            default: {
                logger.error("not support the algorithm :[{}]", verifySignModel.getAlgorithm().getAlgorithm());
                throw new FlyException(FrameworkExceptionCode.VERIFYSIGNFAIL.getCode(),FrameworkExceptionCode.VERIFYSIGNFAIL.getMsg());
            }
        }

    }

}
