package com.hei.exception;

/**
 *
 * @author Crystry
 * @date 2021/9/1520:47
 */
public class EmptyTxtException extends Exception{
    public EmptyTxtException() {
    }

    public EmptyTxtException(String message) {
        super(message);
    }
}
