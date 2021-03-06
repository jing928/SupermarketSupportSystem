package model;

import java.io.Serializable;

import exception.InvalidInputException;

public class Product implements Serializable {

	private static final long serialVersionUID = -754547023689469186L;

	private String name;
	private String barCode;
	private double unitPrice;
	private boolean byWeight; // Indicator for whether the product is sold by weight or by quantity
	private Inventory inventory;

	public Product(String name, double unitPrice, boolean byWeight) {
		this.barCode = Product.generateBarCode(name, unitPrice, byWeight);
		this.name = name;
		this.unitPrice = unitPrice;
		this.byWeight = byWeight;
		this.inventory = new Inventory(this);
	}

	public String getBarCode() {
		return this.barCode;
	}

	public boolean isByWeight() {
		return this.byWeight;
	}

	public void setByWeight(boolean byWeight) {
		this.byWeight = byWeight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) throws InvalidInputException {
		if (unitPrice < 0) {
			throw new InvalidInputException("Price cannot be negative.");
		}
		this.unitPrice = unitPrice;
	}

	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}

	public Inventory getInventory() {
		return this.inventory;
	}

	private static String generateBarCode(String name, double unitPrice, boolean byWeight) {
		// Create a unique hash code for the product
		String productProperty = (name + unitPrice + byWeight).toLowerCase();
		int productHash = productProperty.hashCode();
		return String.format("%s", productHash);
	}

	@Override
	public String toString() {
		String perUnit = byWeight ? "per kg" : "each";
		return String.format("The price for %1$s is $%2$.2f %3$s.\n", name, unitPrice, perUnit);
	}

}
