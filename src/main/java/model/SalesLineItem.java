// TODO only byWeight product can have decimal number of stock and quantity

package model;

import exception.InvalidInputException;

public class SalesLineItem {

	private Product item;
	private double quantity;
	private double price;

	public SalesLineItem(Product item, double quantity) throws InvalidInputException {
		if (quantity <= 0) {
			throw new InvalidInputException("Quantity must be positive.");
		}
		this.item = item;
		this.quantity = quantity;
	}

	public double getSubTotalPrice() {
		if (this.price != 0.0) {
			return this.price;
		}
		
		Inventory inventory = this.item.getInventory();

		this.price = inventory.calculatePrice(this.item.getUnitPrice(), this.quantity);
		return this.price;
	}

	public Product getItem() {
		return this.item;
	}

	public void setQuantity(double quantity) throws InvalidInputException {
		if (quantity <= 0) {
			throw new InvalidInputException("Quantity cannot be negative.");
		}

		this.quantity = quantity;
	}

	public double getQuantity() {
		return this.quantity;
	}

}
