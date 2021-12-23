package ru.mail.puh2012.exception;

import java.io.Serializable;

public class SerialException extends RuntimeException implements Serializable {
    public SerialException (String message){
        super(message);
    }
}
