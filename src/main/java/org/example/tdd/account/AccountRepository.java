package org.example.tdd.account;

public interface AccountRepository {

    public void insert(Account account);


    Account findByid(Long id);

    Account findByUsername(String username);
}
