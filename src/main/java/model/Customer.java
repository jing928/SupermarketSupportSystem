package model;

import java.util.ArrayList;

public class Customer {
	private String id;
	private String name;
	private ArrayList<String> phoneNums;
	private ArrayList<String> addresses;
	private MemberShip rewardsAccount;
	private DebitCard card;
	private ArrayList<Sale> sales;
	
	public Customer(String id, String name) {
		this.id = id;
		this.name = name;
		phoneNums = new ArrayList<String>();
		addresses = new ArrayList<String>();
		rewardsAccount = new MemberShip(id);
		sales = new ArrayList<Sale>();
	}
	
	public Customer(String id, String name, DebitCard card) {
		this.id = id;
		this.name = name;
		phoneNums = new ArrayList<String>();
		addresses = new ArrayList<String>();
		rewardsAccount = new MemberShip(id);
		this.card = card;
		sales = new ArrayList<Sale>();
	}
	
	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public ArrayList<String> getAddresses() {
		return addresses;
	}
	
	public ArrayList<String> getPhones() {
		return phoneNums;
	}
	
	public boolean addPhone(String phone){
		if(phone == null || phoneNums.contains(phone)){
			return false;
		}
		phoneNums.add(phone);
		return true;
	}
	
	public boolean addAddress(String addr){
		if(addr == null || addresses.contains(addr)){
			return false;
		}
		addresses.add(addr);
		return true;
	}
	
	public boolean addSale(Sale sale){
		if(sale == null){
			return false;
		}
		sales.add(sale);
		return true;
	}
	
	public MemberShip getRewardsAccount() {
		return rewardsAccount;
	}
	
	public ArrayList<Sale> getSales() {
		return sales;
	}
	
	public boolean setDebitCard(DebitCard card){
		if(card == null){
			return false;
		}
		this.card = card;
		return true;
	}
	
	public DebitCard getDebitCard() {
		return card;
	}
	
}
