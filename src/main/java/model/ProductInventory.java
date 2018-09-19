// TODO only byWeight product can have decimal number of stock and quantity

package model;

import exception.InvalidInputException;

public class ProductInventory {
	private Product item;
	private double stockLevel = 0;
	private double replenishLevel = 0;
	private double reorderQuantity = 0;
	private double bulkQuantity = 1;
	private double discount = 0; // Percent off. Default to 0
	private Supplier supplier;

	public ProductInventory(String name, double unitPrice, boolean byWeight) {
		this.item = new Product(name, unitPrice, byWeight);
	}

	public double calculatePrice(double quantity) {
		double totalPrice = this.item.getUnitPrice() * quantity;
		double appliedDiscount = this.calculateBulkDiscount(quantity);
		return totalPrice - appliedDiscount;
	}

	public void sellProduct(double quantity) throws InvalidInputException, StockLevelException {
		this.decreaseStockLevel(quantity);
		this.placeReplenishOrder();
	}

	public void increaseStockLevel(double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}

		this.stockLevel += quantity;
	}

	public void decreaseStockLevel(double quantity) throws InvalidInputException, StockLevelException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}

		if (quantity > this.stockLevel) {
			throw new StockLevelException("Insufficient inventory. Cannot decrease.");
		}

		this.stockLevel -= quantity;
	}

	private double calculateBulkDiscount(double quantity) {
		int bulkNumber = (int) (quantity / this.bulkQuantity); // Get the whole number quotient
		double discountedQuantity = bulkNumber * this.bulkQuantity;
		double appliedDiscountPerUnit = this.getItem().getUnitPrice() * this.discount;
		return appliedDiscountPerUnit * discountedQuantity;
	}

	private void placeReplenishOrder() {
		// TODO May need to save info to database
		if (this.stockLevel < this.replenishLevel) {
			System.out.println("Sending a purchase order of " + this.reorderQuantity + " unit(s) " + this.getItemName()
					+ " to " + this.getSupplier().getSupplierName() + "\n");
		}
	}

	// Setters and Getters

	public String getItemBarCode() {
		return this.item.getBarCode();
	}

	public String getItemName() {
		return this.item.getName();
	}

	public double getStockLevel() {
		return stockLevel;
	}

	public void setStockLevel(double stockLevel) throws InvalidInputException {
		if (stockLevel < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		this.stockLevel = stockLevel;
	}

	public double getReplenishLevel() {
		return replenishLevel;
	}

	public void setReplenishLevel(double replenishLevel) throws InvalidInputException {
		if (replenishLevel < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		this.replenishLevel = replenishLevel;
	}

	public double getReorderQuantity() {
		return reorderQuantity;
	}

	public void setReorderQuantity(double reorderQuantity) throws InvalidInputException {
		if (reorderQuantity < 0) {
			throw new InvalidInputException("Quantity can not be negative.");
		}
		this.reorderQuantity = reorderQuantity;
	}

	public double getBulkQuantity() {
		return bulkQuantity;
	}

	public void setBulkQuantity(double bulkQuantity) throws InvalidInputException {
		if (bulkQuantity < 0) {
			throw new InvalidInputException("Bulk quantity can not be negative.");
		}
		this.bulkQuantity = bulkQuantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) throws InvalidInputException {
		if (discount < 0) {
			throw new InvalidInputException("Dicount can not be negative.");
		}

		if (discount > 1) {
			throw new InvalidInputException("Dicount can not be greater than 1.");
		}
		this.discount = discount;
	}

	public Supplier getSupplier() {
		return supplier;
	}

	public void setSupplier(Supplier supplier) {
		this.supplier = supplier;
	}

	public Product getItem() {
		return item;
	}
}
