package com.flyingrain.translate.framework.filter;

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

    @Value("${flyingrain.token}")
    private String innerToken;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String token = requestContext.getHeaderString("token");
        String url = requestContext.getUriInfo().getPath();
        if(this.innerToken.equals(token)){
            return;
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
