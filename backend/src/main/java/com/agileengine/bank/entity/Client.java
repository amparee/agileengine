package com.agileengine.bank.entity;

import java.util.List;

public class Client {

    private String name;
    private List<Account> account;

    public Client(String name, List<Account> account) {
        this.name = name;
        this.account = account;
    }

    public Client() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Account> getAccount() {
        return account;
    }

    public void setAccount(List<Account> account) {
        this.account = account;
    }
}
