package com.nexeo.mykata.entities;

import com.nexeo.mykata.enums.OperationEnum;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class AccountLine {
	private OperationEnum operation;
	private Double balance;
	private Double amount;
	private String date;

	private AccountLine(AccountLineBuilder builder) {
		this.operation = builder.operation;
		this.balance = builder.balance;
		this.amount = builder.amount;
		this.date = builder.date;
	}

	public OperationEnum getOperation() {
		return operation;
	}

	public void setOperation(OperationEnum operation) {
		this.operation = operation;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public static class AccountLineBuilder {
		private OperationEnum operation;
		private Double balance;
		private Double amount;
		private String date;

		public AccountLineBuilder() {

		}

		public AccountLineBuilder withOperation(OperationEnum operation) {
			this.operation = operation;
			return this;
		}

		public AccountLineBuilder withBalance(Double balance) {
			this.balance = balance;
			return this;
		}

		public AccountLineBuilder withAmount(Double amount) {
			this.amount = amount;
			return this;
		}

		public AccountLineBuilder withDate(String date) {
			this.date = date;
			return this;
		}

		public AccountLine build() {
			return new AccountLine(this);
		}

	}
}
