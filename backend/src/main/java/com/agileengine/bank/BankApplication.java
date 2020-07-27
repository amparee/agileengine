package com.agileengine.bank;

import com.agileengine.bank.entity.TrxHistory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BankApplication {

	@Bean
	public TrxHistory initTrxHistory(){
		return new TrxHistory();
	}

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}

}
