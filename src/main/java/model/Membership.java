package model;


public class Membership {
	private String cardNum;
	private Integer pointBalance;
	
	public Membership(String cardNum) {
		this.cardNum = cardNum;
		this.pointBalance = 0;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public Integer getPointBalance() {
		return pointBalance;
	}
	
	public boolean earnPoints(int amount){
		if(amount >= 0){
			pointBalance += amount;
			return true;
		}
		return false;
	}
	
	public boolean usePoints(int amount){
		if(amount >= 0 && pointBalance >= amount){
			pointBalance -= amount;
			return true;
		}
		return false;
	}
}
