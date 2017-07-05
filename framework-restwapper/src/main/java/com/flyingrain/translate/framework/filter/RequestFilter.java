package com.flyingrain.translate.framework.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.PreMatching;
import java.io.IOException;

/**
 * 请求过滤器
 * Created by wally on 6/21/17.
 */
@PreMatching
public class RequestFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
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
