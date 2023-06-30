package bank.integration;

import bank.domain.Account;
import bank.service.AccountService;

public abstract class Observer {
    AccountService accountService;

    public Observer(AccountService accountService) {
        this.accountService = accountService;
    }

    public abstract void update();
}
