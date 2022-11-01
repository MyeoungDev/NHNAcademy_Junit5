package org.example.tdd.account;

public class LoginFailedException extends RuntimeException {

    LoginFailedException(){

    }

    LoginFailedException(String message, Account account) {
        super(message + account.getUsername());
    }
}
