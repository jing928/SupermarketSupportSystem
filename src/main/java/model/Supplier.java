package model;

import java.util.HashSet;
import java.util.Set;

public class Supplier {
	
	private String id;
	private String name;
	private Location address;
	private Set<Inventory> products;
	private String phoneNum;

	public Supplier(String name, Location address, String phoneNum) {
		this.name = name;
		this.address = address;
		this.phoneNum = phoneNum;
		products = new HashSet<Inventory>();
	}

	public Location getAddress() {
		return address;
	}

	public Set<Inventory> getProducts() {
		return products;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setAddress(Location address) {
		this.address = address;
	}

	public boolean addProduct(Inventory product) {
		if (products == null) {
			return false;
		}
		products.add(product);
		return true;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
