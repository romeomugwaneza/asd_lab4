package bank.integration;

import bank.domain.Account;
import bank.service.AccountService;

public class EmailSender extends Observer {
    public EmailSender(AccountService accountService) {
        super(accountService);
    }
    public void sendEmail(Account account){
        System.out.println("EmailSender:: Created account: " + account);
    }

    @Override
    public void update() {
        Account account = accountService.getUpdatedAccount();
        sendEmail(account);
    }
}
