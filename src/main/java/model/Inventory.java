// TODO only byWeight product can have decimal number of stock and quantity

package model;

import javax.persistence.*;

import exception.InvalidInputException;

@Entity
public class Inventory {
	@Id
	@Column(name = "inventory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "name")
	private Product item;
	@Column
	private double stockLevel;
	@Column
	private double replenishLevel;
	@Column
	private double reorderQuantity;
	@Column
	private double bulkQuantity;
	@Column
	private double discount; // Percent off. Default to 0
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id")
	private Supplier supplier;

	public Inventory(Product item) {
		this.item = item;
		this.stockLevel = 0;
		this.replenishLevel = 0;
		this.reorderQuantity = 0;
		this.bulkQuantity = 1;
		this.discount = 0;
	}

	public Inventory() {

	}

	public double calculatePrice(double unitPrice, double quantity) {
		double totalPrice = unitPrice * quantity;
		double appliedDiscount = this.calculateBulkDiscount(unitPrice, quantity);
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

	private double calculateBulkDiscount(double unitPrice, double quantity) {
		int bulkNumber = (int) (quantity / this.bulkQuantity); // Get the whole number quotient
		double discountedQuantity = bulkNumber * this.bulkQuantity;
		double appliedDiscountPerUnit = unitPrice * this.discount;
		return appliedDiscountPerUnit * discountedQuantity;
	}

	private void placeReplenishOrder() {
		// TODO May need to save info to database
		if (this.stockLevel < this.replenishLevel) {
			System.out.println("Sending a purchase order of " + this.reorderQuantity + " unit(s) " + this.item.getName()
					+ " to " + this.getSupplier().getName() + "\n");
		}
	}

	// Setters and Getters

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

}
