package com.agileengine.bank.service;

import com.agileengine.bank.dto.TransactionDto;
import com.agileengine.bank.exception.DepositException;
import com.agileengine.bank.exception.WithdrawException;

public interface IAccountTrxService {
    public void generateWithdraw(TransactionDto transactionDto) throws WithdrawException;
    public void generateDeposit(TransactionDto transactionDto) throws DepositException;
}
