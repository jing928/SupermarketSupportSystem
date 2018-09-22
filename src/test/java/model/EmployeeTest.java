package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmployeeTest {

	Employee employee;

	@BeforeEach
	void Setup() {
		employee = new Employee("Jack");
	}

	@Test
	void testSetEmName() {
		// Fixtures

		// Actions
		employee.setName("William");
		// Actual Result
		String actualEmName = employee.getName();
		// Expected Result
		String expectedEmName = "William";
		// Assertions
		assertEquals(expectedEmName, actualEmName);
	}

}
