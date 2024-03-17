package com.Ashish.BookMyShow.exception.UserException;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDoesNotExistsException extends RuntimeException{
    public UserDoesNotExistsException() {
    }

    public UserDoesNotExistsException(String message) {
        super(message);
    }

    public UserDoesNotExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public UserDoesNotExistsException(Throwable cause) {
        super(cause);
    }

    public UserDoesNotExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
