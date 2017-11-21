package com.nexeo.test.mykata;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import com.nexeo.mykata.customexceptions.AmountBelowMinimumException;
import com.nexeo.mykata.customexceptions.WithdrawAmountValidityException;
import com.nexeo.mykata.customexceptions.WithdrawIsNotPermitedException;
import com.nexeo.mykata.entities.BankAccount;
import com.nexeo.mykata.entities.Customer;
import com.nexeo.mykata.services.BankAccountService;

/**
 * 
 * @author Houssem Selmi
 * 
 */

// Fix method execution order to method names alphabetically
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class BankAccountTest {

	private static BankAccountService bankAccountService;
	private static BankAccount bankAccount;
	private static final String TEST_ADDRESS = "77 Rue Daguerre, 75014 Paris";
	private static final Double INITIAL_BALANCE = 1000D;
	private static final Double DEPOSIT_AMOUNT = 100D;
	private static final Double WITHDRAW_AMOUNT = 250D;

	@BeforeClass
	public static void initialization() {
		bankAccountService = new BankAccountService();
		Customer customer = new Customer.CustomerBuilder().withName("Houssem").withLastName("Selmi").withAge(26).withAddress(TEST_ADDRESS).build();
		assertNotNull(customer);
		bankAccount = new BankAccount.BankAccountBuilder().withCustomer(customer).withAvailableBalance(INITIAL_BALANCE).build();
		assertNotNull(bankAccount);
		assertEquals(INITIAL_BALANCE, bankAccount.getAvailableBalance());
	}

	@Test
	public void deposit() {
		try {
			bankAccountService.deposit(bankAccount, DEPOSIT_AMOUNT);
		} catch (AmountBelowMinimumException e) {
			e.printStackTrace();
		}
		assertEquals(new Double(INITIAL_BALANCE + DEPOSIT_AMOUNT), bankAccount.getAvailableBalance());
	}

	@Test
	public void withdraw() {
		try {
			bankAccountService.withdraw(bankAccount, WITHDRAW_AMOUNT);
		} catch (WithdrawAmountValidityException e) {
			e.printStackTrace();
		} catch (WithdrawIsNotPermitedException e) {
			e.printStackTrace();
		}
		assertEquals(new Double(INITIAL_BALANCE + DEPOSIT_AMOUNT - WITHDRAW_AMOUNT), bankAccount.getAvailableBalance());
		bankAccountService.printOperationsHistory(bankAccount);
	}

}
