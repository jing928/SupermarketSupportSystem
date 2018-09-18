package model;

import java.util.ArrayList;

public class Customer {
	private String id;
	private String name;
	private ArrayList<String> phoneNums;
	private ArrayList<Location> customerLocation;
	private Membership rewardsAccount;
	private DebitCard card;
	private ArrayList<Sale> sales;

	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
		phoneNums = new ArrayList<String>();
		customerLocation = new ArrayList<Location>();
		rewardsAccount = new Membership(id);
		sales = new ArrayList<Sale>();
	}

	public Customer(String id, String name, DebitCard card) {
		this.id = id;
		this.name = name;
		phoneNums = new ArrayList<String>();
		customerLocation = new ArrayList<Location>();
		rewardsAccount = new Membership(id);
		this.card = card;
		sales = new ArrayList<Sale>();
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Location> getCustomerLocation() {
		return customerLocation;
	}

	public ArrayList<String> getPhones() {
		return phoneNums;
	}

	public boolean addPhone(String phone) {
		if (phone == null || phoneNums.contains(phone)) {
			return false;
		}
		phoneNums.add(phone);
		return true;
	}

	public boolean addAddress(Location customerlocation) {
		if (customerlocation == null || customerLocation.contains(customerlocation)) {
			return false;
		}
		customerLocation.add(customerlocation);
		return true;
	}

	public boolean addSale(Sale sale) {
		if (sale == null) {
			return false;
		}
		sales.add(sale);
		return true;
	}

	public Membership getRewardsAccount() {
		return rewardsAccount;
	}

	public ArrayList<Sale> getSales() {
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
