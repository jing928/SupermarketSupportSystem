package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WarehouseStaffTest {
	WarehouseStaff warehouseStaff;
	@BeforeEach
	public void setUp() throws Exception {
		warehouseStaff = new WarehouseStaff();
	}
	@Test
	public void testReplenishStockLevel() {
		Product product1=new Product();
		assertTrue(warehouseStaff.replenishStockLevel(product1, 2));
		assertFalse(warehouseStaff.replenishStockLevel(product1, -2));
	
	}

}
