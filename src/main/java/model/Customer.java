package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Customer implements Serializable {

	private static final long serialVersionUID = 3179192387392740773L;

	private String id;
	private String name;
	private String phoneNum;
	private Location address;
	private Membership rewardsAccount;
	private DebitCard card;
	private List<Sale> sales;

	public Customer(String id, String name, String phoneNum, Location address) {
		this.id = id;
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.rewardsAccount = new Membership(id); // Reward Account card number is the same as the customer ID
		sales = new ArrayList<Sale>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Location getAddress() {
		return address;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public void setAddress(Location address) {
		this.address = address;
	}

	public boolean addSale(Sale sale) {
		if (sale == null) {
			return false;
		}
		sales.add(sale);
		return true;
	}

	public void setRewardsAccount(Membership account) {
		this.rewardsAccount = account;
	}

	public Membership getRewardsAccount() {
		return rewardsAccount;
	}
	
	public double getRewardsInfo() {
		return rewardsAccount.calculateRewardsDiscount();
	}

	public List<Sale> getSales() {
		return sales;
	}

	public boolean setDebitCard(DebitCard card) {
		if (card == null) {
			return false;
		}
		this.card = card;
		return true;
	}

	public DebitCard getDebitCard() {
		return card;
	}

}
