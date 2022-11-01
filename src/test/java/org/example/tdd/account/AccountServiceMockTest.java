package org.example.tdd.account;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

public class AccountServiceMockTest {
    private AccountService service;
    private AccountRepository repository;

    @BeforeEach
    void setUp() {
        repository = mock(AccountRepository.class);
        service = new AccountService(repository);
    }

    @Test
    void login() {
        String username = "jordan";
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        Account result = service.login(username, password);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isNotNull().isPositive();
        assertThat(result.getUsername()).isEqualTo(username);
        assertThat(result.getPassword()).isEqualTo(password);

        verify(repository).findByUsername(username);    // !! verify(mock)
    }

    @Test
    void login_usernameIsNull_throwIllegalArgumentException() {
        String username = null;
        String password = "P@s5w0rd";

        Account account = new Account(username, password);
        when(repository.findByUsername(username)).thenReturn(account);

        assertThatIllegalArgumentException().isThrownBy(() -> service.login(username, password))
                .withMessageContaining("null");

        verify(repository, never()).findByUsername(any());  // !! verify never
    }



    @Test
    void login_threeFail_accountLock() {
        String username = "gwanii";
        String password = "123";

        Account testAccount = new Account("gwanii", "123!@#");

        when(repository.findByUsername(username)).thenReturn(testAccount);

        for (int i = 1; i < 4; i++) {
            assertThatThrownBy(() -> service.login(username, password))
                    .as("Login Fail count {}", i)
                    .isInstanceOf(LoginFailedException.class)
                    .hasMessageContaining("failed");
        }

        assertThatThrownBy(() -> service.login(username, password))
                .as("Login Locked")
                .isInstanceOf(AccountLockedException.class)
                .hasMessageContaining("Lock");

    }
}
