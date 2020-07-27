package com.agileengine.bank.entity;

import com.agileengine.bank.exception.DepositException;
import com.agileengine.bank.exception.WithdrawException;

public class Transaction {

    private Long id;
    private Account account;
    private Double amount;

    public Transaction() {
    }

    public Transaction(Long id, Account account, Double amount) {
        this.id = id;
        this.account = account;
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void deposit() throws DepositException{
        if(this.amount > 0) {
            Double result = this.account.getBalance() + this.amount;
            this.account.setBalance(result);
        }else{
            throw new DepositException("Can't deposit 0 or less money");
        }
        System.out.println("The account " + this.account.getId() + " has $" + this.account.getBalance());
    }

    public void withdraw() throws WithdrawException{
        Double result = this.account.getBalance() - this.amount;
        if(result >= 0){
            this.account.setBalance(result);
        } else {
            throw new WithdrawException("Insufficient balance to generate trx");
        }
        System.out.println("The account " + this.account.getId() + " has $" + this.account.getBalance());
    }

    public static Long generateRandId(){
        long leftLimit = 1L;
        long rightLimit = 10000000L;
        return leftLimit + (long) (Math.random() * (rightLimit - leftLimit));
    }

}
