package com.flyingrain.translate.framework.api.param;

/**
 * Created by wally on 6/15/17.
 */
public class MyParam {

    private String a;

    private String b;

    private String c;

    public MyParam(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public MyParam() {
    }

    public String getA() {
        return a;
    }

    public void setA(String a) {
        this.a = a;
    }

    public String getB() {
        return b;
    }

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public void setB(String b) {
        this.b = b;
    }

    @Override
    public String toString() {
        return "MyParam{" +
                "a='" + a + '\'' +
                ", b='" + b + '\'' +
                ", c='" + c + '\'' +
                '}';
    }
}
