package model;

import java.util.HashMap;

public class Promotion {
	private HashMap<String, Double> bulkQuantities;
	private HashMap<String, Double> discounts;

	public Promotion() {
		this.bulkQuantities = new HashMap<String, Double>();
		this.discounts = new HashMap<String, Double>();
	}

	public boolean setBulkQuantityForProduct(String productName, double bulkQuantity) throws InvalidInputException {
		return false;
	}

	public double getBulkQuantityForProduct(String productName) {
		return 0.0;
	}

	public boolean setDiscountForProduct(String productName, double discount) throws InvalidInputException {
		return false;
	}

	public double getDiscountForProduct(String productName) {
		return 0.0;
	}

	public HashMap<String, Double> getBulkQuantities() {
		return bulkQuantities;
	}

	public HashMap<String, Double> getDiscounts() {
		return discounts;
	}
}
