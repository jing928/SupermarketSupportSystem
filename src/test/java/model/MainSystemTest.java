package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MainSystemTest {

	private MainSystem mainSystem;

	@BeforeEach
	public void setUp() throws Exception {
		mainSystem = new MainSystem();
	}

	@Test
	public void testGenerateFirstID() {
		int expected = 101;
		int actual = mainSystem.generateID(mainSystem.getEmployees());
		assertEquals(expected, actual);
	}

	@Test
	public void testGenerateNextID() {
		mainSystem.addEmployee(new Employee("101", "Jane"));
		int expected = 102;
		int actual = mainSystem.generateID(mainSystem.getEmployees());
		assertEquals(expected, actual);
	}

}
