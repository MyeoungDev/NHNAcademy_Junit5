package org.example.tdd.account;

public class Account {
    private Long id;
    private String username;
    private String password;

    private int loginFailCount;
    private boolean accountLock;

    public int getLoginFailCount() {
        return loginFailCount;
    }

    public void accountFailCountPlus() {
        this.loginFailCount++;
    }

    public void accountFailCountClear() {
        this.loginFailCount = 0;
    }

    public boolean isAccountLock() {
        return accountLock;
    }

    public void accountIsLock() {
        this.accountLock = true;
    }


    public Account(String username, String password) {
        this.id = nextUuid();
        this.username = username;
        this.password = password;

        this.loginFailCount = 0;
        this.accountLock = false;

    }

    private static long nextUuid() {
        // Generate Id
        return System.currentTimeMillis();
    }

    public Long getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}