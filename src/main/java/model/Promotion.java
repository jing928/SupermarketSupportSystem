package model;

import java.util.HashMap;

public class Promotion {
	private HashMap<String, Double> bulkQuantities;
	private HashMap<String, Double> discounts;

	public Promotion() {
		this.bulkQuantities = new HashMap<String, Double>();
		this.discounts = new HashMap<String, Double>();
	}

	public boolean setBulkQuantity(String productName, double bulkQuantity) {
		return false;
	}

	public boolean setDiscount(String productName, double discount) {
		return false;
	}

	public double getBulkQuantity(String productName) {
		return 0.0;
	}

	public double getDiscount(String productName) {
		return 0.0;
	}
}
