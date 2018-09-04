package model;

import java.util.ArrayList;

public class Product {
	private String name;
	private ArrayList<Suppiler> suppilers;
	private double unitPrice;
	private boolean byweight;

	public Product(String name, double unitPrice, boolean b) {
		this.name = name;
		this.unitPrice = unitPrice;
		suppilers = new ArrayList<Suppiler>();
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

	public ArrayList<Suppiler> getSuppilers() {
		return suppilers;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;

	}

	public void setSuppilers(ArrayList<Suppiler> suppilers) {
		this.suppilers = suppilers;
	}
}
