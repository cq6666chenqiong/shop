package com.zhsj.m.exception;


public class MException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 7771051225403402687L;
    private int code;

    public MException(int code, String message) {
        super(message);
        this.code = code;
    }

    public int getCode() {
        return code;
    }

}
