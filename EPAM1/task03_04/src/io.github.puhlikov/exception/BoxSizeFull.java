package ru.mail.puh2012.exception;

/**
 * Created by zf on 04.06.2019.
 */
public class BoxSizeFull extends RuntimeException {
    public BoxSizeFull(String message) {
        super(message);
    }
}
