package com.nexeo.mykata.services;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import com.nexeo.mykata.entities.AccountLine;

/**
 * 
 * @author Houssem Selmi
 * 
 */
public class AccountLineService {
	private static final String HEADER = "|             Date             | OPERATION |      Amount      |      Balance     |";
	private static final String FOOTER = "|______________________________|___________|__________________|__________________|";

	public String getFormatedDateTime(Date date) {
		Locale currentLocale = Locale.getDefault();
		DateFormat formatter = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM, currentLocale);
		return formatter.format(date);
	}

	public void printDetails(AccountLine accountLine) {

		System.out.println("Account Line Details : ");
		System.out.println(HEADER);
		System.out.format("|%30s|%11s|%18.2f|%18.2f|%n", accountLine.getDate(), accountLine.getOperation().toString(), accountLine.getAmount(), accountLine.getBalance());
		System.out.println(FOOTER);

	}
}
