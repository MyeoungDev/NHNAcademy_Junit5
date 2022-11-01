package org.example.tdd.account;

public class AccountLockedException extends RuntimeException {

    AccountLockedException() {

    }

    AccountLockedException(String msg, Account account) {
        super(msg + " " + account.getLoginFailCount());
    }
}
