package model;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exception.InvalidInputException;

public class Sale {

	private LocalDateTime saleDateTime;
	private Customer customer;
	private Map<String, SalesLineItem> lineItems;
	private double totalPrice;

	public Sale(Customer customer, LocalDateTime saleDateTime) {
		this.customer = customer;
		this.saleDateTime = saleDateTime;
		this.lineItems = new HashMap<String, SalesLineItem>();
	}

	public Sale(Customer customer) {
		this(customer, LocalDateTime.now());
	}

	public void addLineItem(Product item, double quantity) throws InvalidInputException {
		// Add new line item to the list
		String key = item.getName();
		SalesLineItem lineItem = new SalesLineItem(item, quantity);
		this.lineItems.put(key, lineItem);
	}

	public void updateLineItem(String itemName, double addedQuantity) throws InvalidInputException {
		// Update quantity of existing line item. This method will increase the quantity
		// instead of resetting it.
		if (addedQuantity < 0) {
			throw new InvalidInputException("Quantity cannot be negative.");
		}
		SalesLineItem lineItem = this.lineItems.get(itemName);
		double oldQuantity = lineItem.getQuantity();
		double newQuantity = oldQuantity + addedQuantity;
		lineItem.setQuantity(newQuantity);
	}

	public double getTotalPrice() {
		if (this.totalPrice != 0.0) {
			return this.totalPrice;
		}

		this.totalPrice = this.calculateTotalPrice();
		return this.totalPrice;
	}

	private double calculateTotalPrice() {
		double totalPrice = 0;
		Iterator<SalesLineItem> i = this.lineItems.values().iterator();
		while (i.hasNext()) {
			totalPrice += i.next().getSubTotalPrice();
		}
		return totalPrice;
	}

	public boolean finalizeSale() throws InvalidInputException, StockLevelException {
		Iterator<SalesLineItem> i = this.lineItems.values().iterator();
		while (i.hasNext()) {
			SalesLineItem lineItem = i.next();
			Inventory item = lineItem.getItem().getInventory();
			item.sellProduct(lineItem.getQuantity());
		}
		return true;
	}

	public Map<String, SalesLineItem> getLineItems() {
		return this.lineItems;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public LocalDateTime getSaleDate() {
		return this.saleDateTime;
	}

}
