package model;

public class WarehouseStaff extends Employee {

	public WarehouseStaff() {
		super();
	}

	
	//TODO
	public void replenishStockLevel(String item, double quantity, Inventory inventory) throws InvalidInputException {
		inventory.increaseStockLevelForProduct(item, quantity);
	}

}
