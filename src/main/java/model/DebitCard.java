package model;

import java.io.Serializable;

public class DebitCard implements Serializable {

	private static final long serialVersionUID = -8638206132150146118L;

	private String cardNum;
	private double balance;

	public DebitCard(String cardNum) {
		this.cardNum = cardNum;
		this.balance = 100.0; // When first created, customer has to add $100
	}

	public String getCardNum() {
		return cardNum;
	}

	public double getBalance() {
		return balance;
	}

	public boolean addMoney(double amount) {
		if (amount >= 0) {
			balance += amount;
			return true;
		}
		return false;
	}

	public boolean deductMoney(double amount) {
		if (amount >= 0 && balance >= amount) {
			balance -= amount;
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return String.format("The balance for card number %1$s: $%2$.2f\n", cardNum, balance);
	}

}
