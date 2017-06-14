package com.flyingrain.translate.framework.lang;

/**
 * 框架内部自定义异常
 * Created by wally on 6/14/17.
 */
public final class FlyException extends RuntimeException {
    private static final long serialVersionUID = -5617150674111598844L;

    private String exCode;

    private String exMsg;

    public FlyException(String exCode, String exMsg) {
        super(exMsg);
        this.exCode = exCode;
        this.exMsg = exMsg;
    }

    public FlyException() {
    }

    public FlyException(String exMsg) {
        super(exMsg);
        this.exMsg = exMsg;
    }

    public String getExCode() {
        return exCode;
    }

    public String getExMsg() {
        return exMsg;
    }

    /**
     * 重写fillStackTrace方法，避免异常发生时生成方法调用栈，优化异常处理
     * @return
     */
    @Override
    public synchronized Throwable fillInStackTrace() {
        return this;
    }
}
