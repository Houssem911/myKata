package com.nexeo.test.mykata;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import com.nexeo.mykata.entities.AccountLine;
import com.nexeo.mykata.enums.OperationEnum;
import com.nexeo.mykata.services.AccountLineService;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class AccountLineTest {

	private static AccountLineService accountLineService;

	@BeforeClass
	public static void initialization() {
		accountLineService = new AccountLineService();
	}

	@Test
	public void buildAccountLine() {
	
		String currentFormatedDate  = accountLineService.getFormatedDateTime(new Date());
		AccountLine accountLine = new AccountLine.AccountLineBuilder().withOperation(OperationEnum.DEPOSIT).withBalance(2000D).withAmount(100D)
				.withDate(currentFormatedDate).build();
		
		assertNotNull(accountLine);
		//Make sure that the account line has been created with the right parameters
		assertEquals(new Double(2000D), accountLine.getBalance());
		assertEquals(new Double(100D), accountLine.getAmount());
		assertEquals(currentFormatedDate, accountLine.getDate());
		assertEquals(OperationEnum.DEPOSIT, accountLine.getOperation());
		
		accountLineService.printDetails(accountLine);		
	}
}
