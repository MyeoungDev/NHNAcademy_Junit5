package org.example.tdd.account;

import java.util.Objects;

public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository) {
        this.repository = repository;
    }

    public void join(Account account) {
        repository.insert(account);
    }

    public Account getAccount(Long id) {
        return repository.findByid(id);
    }

    public Account login(String username, String password) {

        if (username == null) {
            throw new IllegalArgumentException("userName is null");
        }

        Account account = repository.findByUsername(username);

        if (account.getLoginFailCount() >= 3) {
            account.accountIsLock();
        }

        if (account.isAccountLock()) {
            throw new AccountLockedException("Account is Lock", account);
        }

        if (Objects.isNull(account)) {
            return null;
        }

        if (!account.getPassword().equals(password)) {
            account.accountFailCountPlus();
            throw new LoginFailedException("Login failed ", account);
        }

        account.accountFailCountClear();
        return account;
    }
}