package com.flyingrain.translate.framework.lang.utils;

import com.flyingrain.translate.framework.lang.common.Algorithm;
import com.flyingrain.translate.framework.lang.utils.model.SignModel;
import com.flyingrain.translate.framework.lang.utils.model.VerifySignModel;
import org.junit.Test;

/**
 * Created by wally on 8/3/17.
 */
public class SignTest {

    private static final String PRIVATEKEYPATH="/home/wally/workspace/myprojects/certs/pkcs8_myprivate.pem";

    private static final String PUBLICKEYPATH = "/home/wally/workspace/myprojects/certs/pub.pem";

    @Test
    public void testSign(){

        SignModel signModel = new SignModel();
        signModel.setAlgorithm(Algorithm.RSA);
        signModel.setKeyPath(PRIVATEKEYPATH);
        signModel.setPlainContent("测试数据");
        signModel.setPrivate(true);

        String sign = SignUtil.sign(signModel);
        System.out.println(sign);

    }

    @Test
    public void testVerifySign(){
        String sign = "WTan2ps5x+BJ2zjffADSXFXWRkwMR+CVAtoS8hSfT22O24QsxRKPO9RIkWzMRauzqoEQPm019dixsSWYGyaW3ceXdIVckSI7Ye3vB58l8rhI05NMS01Bm1aS9g6lTbjWOIKXYc9SMs+oJrtcgZlhFhs5f+2ZQ569m+7vIfx7H68=";

        VerifySignModel verifySignModel = new VerifySignModel();

        verifySignModel.setSign(sign);
        verifySignModel.setPrivate(false);
        verifySignModel.setKeyPath(PUBLICKEYPATH);
        verifySignModel.setPlainContent("测试数据");
        verifySignModel.setAlgorithm(Algorithm.RSA);
        if(SignUtil.verifySign(verifySignModel)){
            System.out.println("success");
        }else
            System.out.println("failure");

    }


}
