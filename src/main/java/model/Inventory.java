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

	public void setStockLevelForProduct(String productName, double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		
		this.stockLevels.put(productName, quantity);
	}
	
	public double getStockLevelForProduct(String productName) {
		return this.stockLevels.get(productName);
	}

	public void increaseStockLevelForProduct(String productName, double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		
		double newQuantity = this.stockLevels.get(productName) + quantity;
		this.stockLevels.put(productName, newQuantity);
	}

	public void decreaseStockLevelForProduct(String productName, double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		
		double newQuantity = this.stockLevels.get(productName) - quantity;
		this.stockLevels.put(productName, newQuantity);
	}

	public void setReplenishLevelForProduct(String productName, double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		
		this.replenishLevels.put(productName, quantity);
	}

	public double getReplenishLevelForProduct(String productName) {
		return this.replenishLevels.get(productName);
	}

	public void setReorderQuantityForProduct(String productName, double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		
		this.reorderQuantities.put(productName, quantity);
	}

	public double getReorderQuantityForProduct(String productName) {
		return this.reorderQuantities.get(productName);
	}

	public void placeReplenishOrderForProduct(String productName) {
		// Exact implementation needs to be decided.
	}

	public HashMap<String, Double> getStockLevels() {
		return stockLevels;
	}

	public HashMap<String, Double> getReplenishLevels() {
		return replenishLevels;
	}

	public HashMap<String, Double> getReorderQuantities() {
		return reorderQuantities;
	}
}
