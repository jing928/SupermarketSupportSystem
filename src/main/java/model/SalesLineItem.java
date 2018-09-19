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

	public double getPrice() {
		return price;
	}

	public Product getItem() {
		return item;
	}

	public void calculateBulkDiscount(Product product) {

		// Promotion.getDiscounts().get(product.getName());

	}

	public void setItem(Product item) {
		this.item = item;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
