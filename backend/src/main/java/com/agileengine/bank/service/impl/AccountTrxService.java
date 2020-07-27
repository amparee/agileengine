package com.agileengine.bank.service.impl;

import com.agileengine.bank.dto.TransactionDto;
import com.agileengine.bank.entity.Transaction;
import com.agileengine.bank.entity.TrxHistory;
import com.agileengine.bank.exception.DepositException;
import com.agileengine.bank.exception.WithdrawException;
import com.agileengine.bank.service.IAccountTrxService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.websocket.DecodeException;

@Service
public class AccountTrxService implements IAccountTrxService {

    private final static Log log = LogFactory.getLog(AccountTrxService.class);

    @Autowired
    private TrxHistory trxHistory;

    @Override
    public void generateWithdraw(TransactionDto transactionDto) throws WithdrawException{
        log.info("Generate withdraw in account: " + transactionDto.getAccount().toString());
        Transaction trx = new Transaction(Transaction.generateRandId(), transactionDto.getAccount(), transactionDto.getAmount());
        trx.withdraw();
        addTrxToHistory(trx);
    }

    @Override
    public void generateDeposit(TransactionDto transactionDto) throws DepositException{
        log.info("Generate deposit in account: " + transactionDto.getAccount().toString());
        Transaction trx = new Transaction(Transaction.generateRandId(), transactionDto.getAccount(), transactionDto.getAmount());
        trx.deposit();
        addTrxToHistory(trx);
    }

    private void addTrxToHistory(Transaction trx){
        trxHistory.getTrxHistory().add(trx);
    }

}
