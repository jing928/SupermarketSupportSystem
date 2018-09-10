package model;

public class WarehouseStaff extends Employee {

	public WarehouseStaff() {
		super();
	}

	public boolean replenishStockLevel(Product item, int quantity) {
		if (quantity < 0) {
			return false;
		}

		return true;
	}

}
