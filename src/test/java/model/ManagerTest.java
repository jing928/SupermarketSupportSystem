package model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagerTest {
	
	Manager manager1;

	@BeforeEach
	public void setUp() throws Exception {
		manager1=new Manager();
	}
	
	@Test
	public void testOverridePrice() {
		Product product1= new Product();
		assertTrue(manager1.overridePrice(product1, 11));
		assertFalse(manager1.overridePrice(product1, -1));
	}

	@Test
	public void testModifyPromotion() {
		Product product1= new Product();
		assertTrue(manager1.modifyPromotion(product1, 5, 0.3));
		assertFalse(manager1.modifyPromotion(product1, -1, 0.3));
		assertFalse(manager1.modifyPromotion(product1, 0, 0.3));
		assertFalse(manager1.modifyPromotion(product1, 5, -2));
		assertFalse(manager1.modifyPromotion(product1, 5, 1));
		assertFalse(manager1.modifyPromotion(product1, 5, 1.3));
		
	}

}
