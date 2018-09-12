package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {
	
	Employee employee;
	
	@BeforeEach
	void Setup()
	{
		employee=new Employee();
	}
	

	@Test
	void testSetEmId() {
		// Fixtures
		
		// Actions
		employee.setEmId("S111");
		// Actual Result
		String actualEmId=employee.getEmId();
		// Expected Result
		String expectedEmId="S111";
		// Assertions
		assertEquals(expectedEmId,actualEmId);
	}

	@Test
	void testSetEmName() {
		// Fixtures
		
		// Actions
		employee.setEmName("William");
		// Actual Result
		String actualEmName = employee.getEmName();
		// Expected Result
		String expectedEmName = "William";
		// Assertions
		assertEquals(expectedEmName, actualEmName);
	}

	@Test
	void testSetEmGender() {
		// Fixtures
		
		// Actions
		employee.setEmGender('M');
		// Actual Result
		char actualEmGender = employee.getEmGender();
		// Expected Result
		char expectedEmGender = 'M';
		// Assertions
		assertEquals(expectedEmGender, actualEmGender);
	}

	

}
