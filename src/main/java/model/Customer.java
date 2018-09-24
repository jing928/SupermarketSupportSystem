package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
	
	private String id;
	private String name;
	private String phoneNum;
	private Location address;
	private Membership rewardsAccount;
	private DebitCard card;
	private List<Sale> sales;

	public Customer(String name, String phoneNum, Location address, Membership rewardsAccount) {
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
		this.rewardsAccount = rewardsAccount;
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
