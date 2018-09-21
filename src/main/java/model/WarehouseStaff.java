package model;

import exception.InvalidInputException;

public class WarehouseStaff extends Employee {

	public WarehouseStaff(String emId, String emName, char emGender) {
		super(emId, emName, emGender);
	}

	// TODO
	public void replenishStockLevel(ProductInventory product, double quantity) throws InvalidInputException {
		product.setReplenishLevel(quantity);
	}

}
