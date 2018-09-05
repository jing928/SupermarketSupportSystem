package model;

import java.util.ArrayList;

public class Product {
	private String name;
	private ArrayList<Supplier> suppilers = new ArrayList<Supplier>();;
	private double unitPrice;
	private boolean byweight;

	public Product(String name, double unitPrice, boolean b) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.byweight = b;

	}

	public boolean isByweight() {
		return byweight;
	}

	public void setByweight(boolean byweight) {
		this.byweight = byweight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public ArrayList<Supplier> getSuppilers() {
		return suppilers;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;

	}

	public void setSuppilers(ArrayList<Supplier> suppilers) {
		this.suppilers = suppilers;
	}
}
