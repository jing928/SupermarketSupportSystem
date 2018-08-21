package model;

import java.util.HashMap;

public class Promotion {
	private HashMap<String, Double> bulkQuantities;
	private HashMap<String, Double> discounts;

	public Promotion() {
		this.bulkQuantities = new HashMap<String, Double>();
		this.discounts = new HashMap<String, Double>();
	}

	public void setBulkQuantityForProduct(String productName, double bulkQuantity) throws InvalidInputException {
		if (bulkQuantity < 0) {
			throw new InvalidInputException("Bulk quantity can not be negative.");
		}
		
		this.bulkQuantities.put(productName, bulkQuantity);
	}

	public double getBulkQuantityForProduct(String productName) {
		return this.bulkQuantities.get(productName);
	}

	public void setDiscountForProduct(String productName, double discount) throws InvalidInputException {
		if (discount < 0) {
			throw new InvalidInputException("Dicount can not be negative.");
		}
		
		this.discounts.put(productName, discount);
	}

	public double getDiscountForProduct(String productName) {
		return this.discounts.get(productName);
	}

	public HashMap<String, Double> getBulkQuantities() {
		return bulkQuantities;
	}

	public HashMap<String, Double> getDiscounts() {
		return discounts;
	}
}
