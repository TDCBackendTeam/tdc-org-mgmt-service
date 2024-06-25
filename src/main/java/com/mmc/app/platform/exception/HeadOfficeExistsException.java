package com.mmc.app.platform.exception;

public class HeadOfficeExistsException extends Exception{

    public HeadOfficeExistsException() {
        super("Head office record already exists");
    }

    public HeadOfficeExistsException(String message) {
        super(message);
    }


}
