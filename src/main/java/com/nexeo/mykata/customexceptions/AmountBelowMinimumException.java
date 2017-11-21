package com.nexeo.mykata.customexceptions;

public class AmountBelowMinimumException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AmountBelowMinimumException() {

	}

	public AmountBelowMinimumException(Double minimumAmount) {
		super("Deposit Amount Must Be Greater Than The Minimum Permeted Amount : " + minimumAmount);
	}

}
