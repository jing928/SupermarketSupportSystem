package model;

public class WarehouseStaff extends Employee {

	public WarehouseStaff(String emId, String emName, char emGender) {
		super(emId, emName, emGender);
	}

	// TODO
	public void replenishStockLevel(ProductIventory product, double quantity) {
		product.setReplenishLevel(quantity);
	}

}
