package com.flyingrain.translate.user.api.request;

/**
 * Created by wally on 3/8/18.
 */
public class WxLoginRequest {

    private String wxNo;

    public String getWxNo() {
        return wxNo;
    }

    public void setWxNo(String wxNo) {
        this.wxNo = wxNo;
    }

    @Override
    public String toString() {
        return "WxLoginRequest{" +
                "wxNo='" + wxNo + '\'' +
                '}';
    }
}
