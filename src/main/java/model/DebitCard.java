
package model;
import static org.junit.Assert.*;
public class DebitCard {
	private String cardNum;
	private double balance;

	public DebitCard(String cardNum) {
		this.cardNum = cardNum;
		this.balance = 0.0;
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
}
