package model;

public class Product {
	private String name;
	private Supplier suppiler;;
	private double unitPrice;
	private boolean byweight;

	public Product(String name, double unitPrice, boolean b) {
		this.name = name;
		this.unitPrice = unitPrice;
		this.byweight = b;

	}

	public Product() {

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

	public Supplier getSuppiler() {
		return this.suppiler;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;

	}

	public void setSuppiler (Supplier suppiler) {
		this.suppiler = suppiler;
	}
}
