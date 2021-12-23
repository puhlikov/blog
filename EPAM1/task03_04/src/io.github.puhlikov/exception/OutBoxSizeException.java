package ru.mail.puh2012.exception;

public class OutBoxSizeException extends RuntimeException {
    public OutBoxSizeException (String message) {
        super(message);
    }
}
