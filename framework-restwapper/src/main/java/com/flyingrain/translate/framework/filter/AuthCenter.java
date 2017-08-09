package com.flyingrain.translate.framework.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.FrameworkExceptionCode;
import com.flyingrain.translate.framework.lang.common.Result;
import com.flyingrain.translate.framework.lang.utils.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 对接认证中心
 * Created by wally on 8/9/17.
 */
@Component
public class AuthCenter {

    @Value("${authCenter.url}")
    private String authUrl;

    @Value("${flyingrain.token}")
    private String innerToken;

    private Map<String, String> headers;

    private ObjectMapper mapper = new ObjectMapper();

    private Logger logger = LoggerFactory.getLogger(AuthCenter.class);

    @PostConstruct
    public void init() {
        headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        headers.put("Accept", "application/json");
        headers.put("token",innerToken);
    }

    public Result auth(String token, String url) {
        Map<String, String> params = new HashMap<>();
        params.put("token", token);
        params.put("url", url);
        String result = HttpUtil.sendPostForJson(params, headers, authUrl);
        try {
            return mapper.readValue(result,Result.class);

        } catch (IOException e) {
            logger.error("deserialize result failed!",e);
            logger.error("result is :[{}]",result);
            throw new FlyException(FrameworkExceptionCode.SYSERROR.getCode(),FrameworkExceptionCode.SYSERROR.getMsg());
        }

    }

    public String getAuthUrl() {
        return authUrl;
    }

    public void setAuthUrl(String authUrl) {
        this.authUrl = authUrl;
    }
}
