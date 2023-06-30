package bank.integration;

import bank.domain.Account;
import bank.service.AccountService;

public class SMSSender extends Observer{
    public SMSSender(AccountService accountService) {
        super(accountService);
    }
    public void sendSMS(Account account){
        System.out.println("SMSSender:: Updated account: " + account);
    }

    @Override
    public void update() {
        Account account = accountService.getUpdatedAccount();
        sendSMS(account);
    }
}
