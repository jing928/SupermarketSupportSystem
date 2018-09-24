package model;

public class Membership {
	
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
