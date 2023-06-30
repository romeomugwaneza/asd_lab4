package bank.service;

import java.util.Collection;

import bank.dao.AccountDAO;
import bank.dao.IAccountDAO;
import bank.domain.Account;
import bank.domain.Customer;
import bank.subject.CreateAccountSubject;
import bank.subject.UpdateAccountSubject;


public class AccountService extends UpdateAccountSubject implements IAccountService {
    private IAccountDAO accountDAO;

    private Account updatedAccount;

    private CreateAccountSubject createAccountSubject;

    public void setCreateAccountSubject(CreateAccountSubject createAccountSubject) {
        this.createAccountSubject = createAccountSubject;
    }

    public Account getUpdatedAccount(){
        return updatedAccount;
    }

    public AccountService() {
        accountDAO = new AccountDAO();
    }

    public Account createAccount(long accountNumber, String customerName) {
        Account account = new Account(accountNumber);
        Customer customer = new Customer(customerName);
        account.setCustomer(customer);
        accountDAO.saveAccount(account);
        updatedAccount = account;
        createAccountSubject.doNotify();
        return account;
    }

    public void deposit(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.deposit(amount);
        accountDAO.updateAccount(account);
        updatedAccount = account;
        doNotify();
    }

    public Account getAccount(long accountNumber) {
        Account account = accountDAO.loadAccount(accountNumber);
        return account;
    }

    public Collection<Account> getAllAccounts() {
        return accountDAO.getAccounts();
    }

    public void withdraw(long accountNumber, double amount) {
        Account account = accountDAO.loadAccount(accountNumber);
        account.withdraw(amount);
        accountDAO.updateAccount(account);
        updatedAccount = account;
        doNotify();
    }


    public void transferFunds(long fromAccountNumber, long toAccountNumber, double amount, String description) {
        Account fromAccount = accountDAO.loadAccount(fromAccountNumber);
        Account toAccount = accountDAO.loadAccount(toAccountNumber);
        fromAccount.transferFunds(toAccount, amount, description);
        accountDAO.updateAccount(fromAccount);
        accountDAO.updateAccount(toAccount);
        doNotify();
    }
}
