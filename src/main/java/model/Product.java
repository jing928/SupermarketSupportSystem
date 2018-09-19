package model;

public class Product {
	private String barCode;
	private String name;
	private double unitPrice;
	private boolean byWeight; // Indicator for whether the product is sold by weight or by quantity

	public Product(String name, double unitPrice, boolean byWeight) {
		this.barCode = Product.generateBarCode(name, unitPrice, byWeight);
		this.name = name;
		this.unitPrice = unitPrice;
		this.byWeight = byWeight;
	}

	public Product() {

	}

	public String getBarCode() {
		return this.barCode;
	}

	public boolean isByWeight() {
		return this.byWeight;
	}

	public void setByWeight(boolean byWeight) {
		this.byWeight = byWeight;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public double getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	private static String generateBarCode(String name, double unitPrice, boolean byWeight) {
		// Create a unique hash code for the product
		String productProperty = (name + unitPrice + byWeight).toLowerCase();
		int productHash = productProperty.hashCode();
		return String.format("%s", productHash);
	}

}
