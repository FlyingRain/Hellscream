package com.flyingrain.translate.auth.api;

import com.flyingrain.translate.auth.api.requests.SignRequest;
import com.flyingrain.translate.auth.api.requests.VerifyRequest;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * 验签/加签
 * Created by wally on 17-7-30.
 */
@Path("/auth")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface VerifyResource {

    /**
     * 验签
     * @param verifyRequest 验签请求
     * @return 结果
     */
    @POST
    @Path("/verifySign")
    boolean verify(VerifyRequest verifyRequest);


    /**
     * 对明文签名
     * @param signRequest
     * @return
     */
    @POST
    @Path("/sign")
    String sign(SignRequest signRequest);


    /**
     * 解密
     * @param encryptMsg
     * @return
     */
    @POST
    @Path("/decrypt")
    String decrypt(String encryptMsg);



}
