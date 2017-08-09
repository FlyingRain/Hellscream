package com.flyingrain.translate.framework.filter;

import com.flyingrain.translate.framework.common.RestWrapperError;
import com.flyingrain.translate.framework.lang.FlyException;
import com.flyingrain.translate.framework.lang.common.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;

/**
 * 请求过滤器
 * Created by wally on 6/21/17.
 */
@PreMatching
@Component
public class RequestFilter implements ContainerRequestFilter {

    private Logger logger = LoggerFactory.getLogger(RequestFilter.class);

    @Value("${flyingrain.token}")
    private String innerToken;

    @Autowired
    private AuthCenter authCenter;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString("token");
        String url = requestContext.getUriInfo().getPath();
        if(this.innerToken.equals(token)){
            return;
        }

        Result result = authCenter.auth(token,url);
        if(!result.isSuccess()){
            throw new FlyException(result.getCode(),result.getMsg());
        }
        logger.info("auth result is :[{}]",result.getRealResult());
        if(result.getRealResult()!=null&&result.getRealResult().getClass()==Boolean.class){
            if(!(boolean)result.getRealResult()){
                throw new FlyException(RestWrapperError.NOAUTH.getCode(),RestWrapperError.NOAUTH.getMsg());
            }
        }else{
            logger.error("error response! [{}]",result.getRealResult());
            throw new FlyException(RestWrapperError.ERRORRESPONSE.getCode(),RestWrapperError.ERRORRESPONSE.getMsg());
        }

        //        if (requestContext.hasEntity()) {
//            InputStream inputStream = requestContext.getEntityStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
//            String test = reader.readLine();
//            String changeRequest = "{\"a\":\"1\",\"c\":\"3\"}";
//            InputStream changeStrem = new ByteArrayInputStream(changeRequest.getBytes("utf-8"));
//            requestContext.setEntityStream(changeStrem);
//        }
//        URI now =  requestContext.getUriInfo().getRequestUri();
//        try {
//            URI newURI = new URI("http://localhost:8099/translate/test/resource/proxy?mm=3");
//            requestContext.setRequestUri(newURI);
//        } catch (URISyntaxException e) {
//            e.printStackTrace();
//        }
    }
}
