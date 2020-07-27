package com.agileengine.bank.entity;

import com.agileengine.bank.enums.AccountTypeEnum;

public class Account {

    private String id;
    private Double balance;
    private AccountTypeEnum accountType;

    public Account() {
    }

    public Account(String id, Double balance, AccountTypeEnum accountType) {
        this.id = id;
        this.balance = balance;
        this.accountType = accountType;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public AccountTypeEnum getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountTypeEnum accountType) {
        this.accountType = accountType;
    }

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    public static String randomAlphaNumeric() {
        StringBuilder builder = new StringBuilder();
        int count = 15;
        while (count-- != 0) {
            int character = (int)(Math.random()*ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Account{");
        sb.append("id='").append(id).append('\'');
        sb.append(", balance=").append(balance);
        sb.append(", accountType=").append(accountType);
        sb.append('}');
        return sb.toString();
    }
}
