package com.agileengine.bank.entity;

import java.util.ArrayList;
import java.util.List;

public class TrxHistory {

    public List<Transaction> trxHistory;

    public TrxHistory() {
        this.trxHistory = new ArrayList<Transaction>();
    }

    public List<Transaction> getTrxHistory() {
        return trxHistory;
    }
}
