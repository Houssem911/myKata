package com.nexeo.mykata.customexceptions;

public class WithdrawAmountValidityException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public WithdrawAmountValidityException() {
	}

	public WithdrawAmountValidityException(Double minimumAmount, Double maximumAmount) {
		super("Withdraw Amount Must Be Between The Following Amounts : " + minimumAmount + " And " + maximumAmount);
	}
}
