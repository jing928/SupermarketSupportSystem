package model;

public class SalesLineItem {

	private Product item;
	private String itemName;
	private double quantity;
	private double price;

	public SalesLineItem(String itemName, double quantity, double price, Product item) {
		this.itemName = itemName;
		this.quantity = quantity;
		this.price = price;
		this.item = item;
	}

	public String getItemName() {
		return itemName;
	}

	public double getQuantity() {
		return quantity;
	}

	public double getPricey() {
		return price;
	}

	public Product getItem() {
		return item;
	}

	public void calculateBulkDiscount(Product product) {

	}

}
