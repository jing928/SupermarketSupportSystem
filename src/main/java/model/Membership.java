package model;

import java.io.Serializable;

public class Membership implements Serializable {

	private static final long serialVersionUID = 3324043878092793945L;

	private String memberNum;
	private int pointBalance;

	public Membership(String cardNum) {
		this.memberNum = cardNum;
		this.pointBalance = 0;
	}

	public String getCardNum() {
		return memberNum;
	}

	public int getPointBalance() {
		return pointBalance;
	}

	public boolean earnPoints(int amount) {
		if (amount >= 0) {
			pointBalance += amount;
			return true;
		}
		return false;
	}

	public boolean usePoints(int amount) {
		if (amount >= 0 && pointBalance >= amount) {
			pointBalance -= amount;
			return true;
		}
		return false;
	}

}
