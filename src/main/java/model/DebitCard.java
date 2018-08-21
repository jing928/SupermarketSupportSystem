package model;

public class DebitCard {
	private String cardNum;
	private Double balance;
	
	public DebitCard(String cardNum) {
		this.cardNum = cardNum;
		this.balance = 0.0;
	}
	
	public String getCardNum() {
		return cardNum;
	}
	
	public Double getBalance() {
		return balance;
	}
	
	public boolean addMoney(double amount){
		if(amount >= 0){
			balance += amount;
			return true;
		}
		return false;
	}
	
	public boolean deductMoney(double amount){
		if(amount >= 0 && balance >= amount){
			balance -= amount;
			return true;
		}
		return false;
	}
}
