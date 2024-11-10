package com.yash.contactapp.exception;

public class UserBlockedException extends Exception{

    /**
     * creates user object with and without description
     */
    public UserBlockedException() {}
    public UserBlockedException(String errDesc) {
        super(errDesc);
    }
}
