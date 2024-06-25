package com.mmc.app.platform.exception;

public class PinExistsException extends Exception{
    public PinExistsException() {
        super("Pin already exists");
    }

  /*  public PinExistsException(String message) {
        super(message);
    }*/
}
