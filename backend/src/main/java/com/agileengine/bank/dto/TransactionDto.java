package com.agileengine.bank.dto;

import com.agileengine.bank.entity.Account;
import com.agileengine.bank.enums.TransactionTypeEnum;

public class TransactionDto {

    private Account account;
    private Double amount;
    private TransactionTypeEnum transactionType;

    public TransactionDto() {
    }

    public TransactionDto(Account account, Double amount, TransactionTypeEnum transactionType) {
        this.account = account;
        this.amount = amount;
        this.transactionType = transactionType;
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

    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }
}
