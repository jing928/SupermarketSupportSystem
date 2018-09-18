package model;

import java.util.HashSet;

public class Supplier {
	private String supplierId;
	private String supplierName;
	private HashSet<Location> supplierLocations;
	private HashSet<Product> supplierProducts;
	private HashSet<String> supplierPhoneNumber;

	public Supplier() {

	}

	public Supplier(String supplierId, String supplierName) {
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		supplierLocations = new HashSet<Location>();
		supplierProducts = new HashSet<Product>();
		supplierPhoneNumber = new HashSet<String>();
	}

	public HashSet<Location> getSupplierLocation() {
		return supplierLocations;
	}

	public HashSet<Product> getSupplierProducts() {
		return supplierProducts;
	}

	public HashSet<String> getSupplierPhoneNumber() {
		return supplierPhoneNumber;
	}

	public boolean addSupplierLocation(Location location) {
		if (location == null) {
			return false;
		}
		supplierLocations.add(location);
		return true;
	}

	public boolean addSupplierProducts(Product products) {
		if (products == null) {
			return false;
		}
		supplierProducts.add(products);
		return true;
	}

	public boolean addPhoneNumber(String phone) {
		if (phone == null || supplierPhoneNumber.contains(phone))
			return false;
		supplierPhoneNumber.add(phone);
		return true;
	}

	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

}
