package model;

import java.util.HashMap;

public class Inventory {
	private HashMap<String, Double> stockLevels;
	private HashMap<String, Double> replenishLevels;
	private HashMap<String, Double> reorderQuantities;

	public Inventory() {
		this.stockLevels = new HashMap<String, Double>();
		this.replenishLevels = new HashMap<String, Double>();
		this.reorderQuantities = new HashMap<String, Double>();
	}

	public double getStockLevel(String productName) {
		return 0.0;
	}

	public boolean increaseStockLevel(String productName, double quantity) {
		return false;
	}

	public boolean decreaseStockLevel(String productName, double quantity) {
		return false;
	}

	public boolean setReplenishLevel(String productName, double quantity) {
		return false;
	}

	public double getReplenishLevel(String productName) {
		return 0.0;
	}

	public boolean setReorderQuantity(String productName, double quantity) {
		return false;
	}

	public double getReorderQuantity(String productName) {
		return 0.0;
	}

	public boolean placeReplenishOrder(String productName) {
		return false;
	}
}
