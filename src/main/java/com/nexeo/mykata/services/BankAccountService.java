package com.nexeo.mykata.services;

import java.util.Date;

import com.nexeo.mykata.customexceptions.AmountBelowMinimumException;
import com.nexeo.mykata.customexceptions.WithdrawAmountValidityException;
import com.nexeo.mykata.customexceptions.WithdrawIsNotPermitedException;
import com.nexeo.mykata.entities.AccountLine;
import com.nexeo.mykata.entities.BankAccount;
import com.nexeo.mykata.enums.OperationEnum;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class BankAccountService {

	private static final Double MIN_DEPOSIT_AMOUNT = 10D;
	private static final Double MAX_WITHDRAW_AMOUNT = 5000D;
	private static final Double MIN_WITHDRAW_AMOUNT = 10D;
	private static final String HEADER = "|             Date             | OPERATION |      Amount      |      Balance     |";
	private static final String FOOTER = "|______________________________|___________|__________________|__________________|";

	private static AccountLineService accountLineService = new AccountLineService();

	public void deposit(BankAccount bankAccount, Double depositAmount) throws AmountBelowMinimumException {

		if (depositAmountValidityCheck(depositAmount)) {
			bankAccount.setAvailableBalance(bankAccount.getAvailableBalance() + depositAmount);
			addAccountLine(bankAccount, depositAmount, OperationEnum.DEPOSIT);
		} else {
			throw new AmountBelowMinimumException(MIN_DEPOSIT_AMOUNT);
		}

	}

	public void withdraw(BankAccount bankAccount, Double withdrawAmount) throws WithdrawAmountValidityException, WithdrawIsNotPermitedException {
		if (withdrawAmountValidityCheck(withdrawAmount)) {

			if (withdrawnIsPermitedOnAccount(bankAccount, withdrawAmount)) {
				bankAccount.setAvailableBalance(bankAccount.getAvailableBalance() - withdrawAmount);
				addAccountLine(bankAccount, withdrawAmount, OperationEnum.WITHDRAW);
			} else {
				throw new WithdrawIsNotPermitedException();
			}
		} else {
			throw new WithdrawAmountValidityException(MIN_WITHDRAW_AMOUNT, MAX_WITHDRAW_AMOUNT);
		}

	}

	private void addAccountLine(BankAccount bankAccount, Double amount, OperationEnum operation) {
		bankAccount.getAccountLines().add(
				new AccountLine.AccountLineBuilder().withAmount(amount).withBalance(bankAccount.getAvailableBalance()).withOperation(operation)
						.withDate(accountLineService.getFormatedDateTime(new Date())).build());
	}

	private boolean withdrawAmountValidityCheck(Double withdrawAmount) {
		if (withdrawAmount >= MIN_WITHDRAW_AMOUNT && withdrawAmount <= MAX_WITHDRAW_AMOUNT)
			return true;

		return false;
	}

	private boolean depositAmountValidityCheck(Double depositAmount) {
		if (depositAmount >= MIN_DEPOSIT_AMOUNT)
			return true;

		return false;
	}

	private boolean withdrawnIsPermitedOnAccount(BankAccount bankAccount, Double withdrawAmount) {
		if (withdrawAmount <= bankAccount.getAvailableBalance())
			return true;

		return false;
	}

	public void printOperationsHistory(BankAccount bankAccount) {
		if (hasOperationsHistory(bankAccount)) {
			System.out.println("Operations History : ");
			System.out.println(HEADER);
			for (AccountLine accountLine : bankAccount.getAccountLines()) {
				System.out.format("|%30s|%11s|%18.2f|%18.2f|%n", accountLine.getDate(), accountLine.getOperation().toString(), accountLine.getAmount(), accountLine.getBalance());
			}

			System.out.println(FOOTER);

		} else {
			System.out.println("No Operations History Is Available !!");

		}

	}

	private boolean hasOperationsHistory(BankAccount bankAccount) {
		if (!bankAccount.getAccountLines().isEmpty())
			return true;

		return false;
	}
}
