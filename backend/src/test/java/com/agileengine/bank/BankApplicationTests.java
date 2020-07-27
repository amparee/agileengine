package com.agileengine.bank;

import com.agileengine.bank.dto.TransactionDto;
import com.agileengine.bank.entity.Account;
import com.agileengine.bank.enums.AccountTypeEnum;
import com.agileengine.bank.enums.TransactionTypeEnum;
import com.agileengine.bank.exception.DepositException;
import com.agileengine.bank.exception.WithdrawException;
import com.agileengine.bank.service.impl.AccountTrxService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BankApplicationTests {

	@Autowired
	private AccountTrxService accountTrxService;
	private static TransactionDto trxDto;

	@BeforeAll
	static void initTransactionDto(){
		Account account  = new Account();
		account.setId(Account.randomAlphaNumeric());
		account.setBalance(0.0);
		account.setAccountType(AccountTypeEnum.CREDIT);

		trxDto = new TransactionDto();
		trxDto.setAccount(account);
	}

	@Test
	void depositTest() throws DepositException {
		trxDto.setTransactionType(TransactionTypeEnum.DEPOSIT);
		trxDto.setAmount(500.00);
		accountTrxService.generateDeposit(trxDto);
		assertEquals(trxDto.getAccount().getBalance(), 500.00);

		trxDto.setAmount(-500.00);
		assertThrows(RuntimeException.class, () -> accountTrxService.generateDeposit(trxDto));
	}

	@Test
	void withdrawTest() throws WithdrawException {
		trxDto.setTransactionType(TransactionTypeEnum.WITHDRAW);
		trxDto.setAmount(200.00);
		accountTrxService.generateWithdraw(trxDto);
		assertEquals(trxDto.getAccount().getBalance(), 300.00);

		trxDto.setAmount(500.00);
		assertThrows(RuntimeException.class, () -> accountTrxService.generateWithdraw(trxDto));
	}

}
