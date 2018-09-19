// TODO only byWeight product can have decimal number of stock and quantity

package model;

import exception.InvalidInputException;

public class SalesLineItem {

	private ProductInventory item;
	private double quantity;
	private double price;

	public SalesLineItem(ProductInventory item, double quantity) {
		this.item = item;
		this.quantity = quantity;
	}

	public double getPrice() throws InvalidInputException {
		if (this.price != 0.0) {
			return this.price;
		}

		this.price = this.item.calculatePrice(this.quantity);
		return this.price;
	}

	public ProductInventory getItem() {
		return this.item;
	}

	public void setQuantity(double quantity) throws InvalidInputException {
		if (quantity < 0) {
			throw new InvalidInputException("Quantity cannot be negative.");
		}

		this.quantity = quantity;
	}

	public double getQuantity() {
		return this.quantity;
	}

}
