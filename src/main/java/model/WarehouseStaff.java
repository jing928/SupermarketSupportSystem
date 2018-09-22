package model;

import exception.InvalidInputException;

public class WarehouseStaff extends Employee {

	// TODO
	public void replenishStockLevel(ProductInventory product, double quantity) throws InvalidInputException {
		product.setReplenishLevel(quantity);
	}

}
