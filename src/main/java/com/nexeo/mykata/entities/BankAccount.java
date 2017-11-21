package com.nexeo.mykata.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class BankAccount {

	private Customer customer;
	private Double availableBalance;
	private List<AccountLine> accountLines;

	private BankAccount(BankAccountBuilder builder) {
		this.customer = builder.customer;
		this.availableBalance = builder.availableBalance;
		this.accountLines = builder.accountLines;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Double getAvailableBalance() {
		return availableBalance;
	}

	public void setAvailableBalance(Double availableBalance) {
		this.availableBalance = availableBalance;
	}

	public List<AccountLine> getAccountLines() {
		if (accountLines == null)
			accountLines = new ArrayList<AccountLine>();
		return accountLines;
	}

	public void setAccountLines(List<AccountLine> accountLines) {
		this.accountLines = accountLines;
	}

	public static class BankAccountBuilder {

		private Customer customer;
		private Double availableBalance;
		private List<AccountLine> accountLines;

		public BankAccountBuilder() {

		}

		public BankAccountBuilder withCustomer(Customer customer) {
			this.customer = customer;
			return this;
		}

		public BankAccountBuilder withAvailableBalance(Double availableBalance) {
			this.availableBalance = availableBalance;
			return this;
		}

		public BankAccountBuilder withAccountLines(List<AccountLine> accountLines) {
			this.accountLines = accountLines;
			return this;
		}

		public BankAccount build() {
			return new BankAccount(this);
		}
	}
}
