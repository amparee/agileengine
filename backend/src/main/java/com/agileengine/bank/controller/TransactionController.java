package com.agileengine.bank.controller;


import com.agileengine.bank.dto.TransactionDto;
import com.agileengine.bank.entity.Transaction;
import com.agileengine.bank.entity.TrxHistory;
import com.agileengine.bank.enums.TransactionTypeEnum;
import com.agileengine.bank.exception.DepositException;
import com.agileengine.bank.exception.WithdrawException;
import com.agileengine.bank.service.impl.AccountTrxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trx")
public class TransactionController {

    @Autowired
    private AccountTrxService accountTrxService;

    @Autowired
    private TrxHistory trxHistory;

    @PostMapping("/new")
    public ResponseEntity<String> processTrx(@RequestBody TransactionDto transactionDto) {
        try {
            Double amount = transactionDto.getAmount();
            if (transactionDto.getTransactionType() == TransactionTypeEnum.DEPOSIT) {
                accountTrxService.generateDeposit(transactionDto);
            } else if (transactionDto.getTransactionType() == TransactionTypeEnum.WITHDRAW) {
                accountTrxService.generateWithdraw(transactionDto);
            }
            String response = "Trx generated successfully";
            return new ResponseEntity<String>(response, HttpStatus.OK);
        }catch(DepositException depositException){
            return new ResponseEntity<String>(depositException.getMessage(), HttpStatus.CONFLICT);
        }catch(WithdrawException withdrawException){
            return new ResponseEntity<String>(withdrawException.getMessage(),HttpStatus.CONFLICT);
        } catch (Exception e) {
            return new ResponseEntity<String>("An unexpected error ocurred", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/historic")
    public ResponseEntity<List<Transaction>> showTrxHistoric(){
        return new ResponseEntity<List<Transaction>>(trxHistory.getTrxHistory(), HttpStatus.OK);
    }

}
