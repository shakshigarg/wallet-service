package org.company.wallet.exception;

public class UserNotExistsException extends Exception {
    public UserNotExistsException(String message) {
        super(message);
    }
}
