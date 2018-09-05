package model;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WarehouseStaffTest {
	WarehouseStaff warehouseStaff;
	@Before
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
