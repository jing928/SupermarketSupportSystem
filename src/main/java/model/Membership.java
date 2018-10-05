package model;

import java.io.Serializable;

public class Membership implements Serializable {

	private static final long serialVersionUID = 3324043878092793945L;

	private String memberNum;
	private int pointBalance;
	private int minRedeemable = 20; // Minimum 20 points for redemption
	private double minDiscount = 5; // $5 discount for every minimum redeemable points.

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

	public boolean addPoints(int amount) {
		if (amount >= 0) {
			pointBalance += amount;
			return true;
		}
		return false;
	}

	public boolean deductPoints(int amount) {
		if (amount >= 0 && pointBalance >= amount) {
			pointBalance -= amount;
			return true;
		}
		return false;
	}

	public double calculateRewardsDiscount(double price) {
		int maxMultiplier = (int) (price / minDiscount);
		int pointsNeeded = maxMultiplier * minRedeemable;
		if (pointsNeeded >= pointBalance) {
			return calculateMaxRewardsDiscount();
		} else {
			return minDiscount * getMultiplier(pointsNeeded);
		}
	}

	private double calculateMaxRewardsDiscount() {
		return minDiscount * getMultiplier(pointBalance);
	}

	public void redeemAll() {
		int pointsToUse = getMultiplier(pointBalance) * minRedeemable;
		deductPoints(pointsToUse);
	}
	
	public void redeem(double discountApplied) {
		int pointsUsed = (int) (discountApplied / 5 * 20);
		deductPoints(pointsUsed);
	}

	private int getMultiplier(int balance) {
		return balance / minRedeemable;
	}

	@Override
	public String toString() {
		double discount = getMultiplier(pointBalance) * minDiscount;
		String info = String.format("Loyalty points balance: %1$s points.\nRedeemable for $%2$.2f discount.\n",
				pointBalance, discount);
		return info;
	}

}
