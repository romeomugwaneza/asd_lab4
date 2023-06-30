package bank.integration;

import bank.domain.Account;
import bank.service.AccountService;

public class Logger extends Observer{
    public Logger(AccountService accountService) {
        super(accountService);
    }
    public void log(Account account){
        System.out.println("Logger:: Updated account: " + account);
    }
    @Override
    public void update() {
        Account account = accountService.getUpdatedAccount();
        log(account);
    }
}
