package controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.Employee;
import model.MainSystem;

class MainControllerTest {
	
	private MainSystem mainSystem;
	private MainController mainController;

	@BeforeEach
	void setUp() throws Exception {
		mainSystem = new MainSystem();
		mainController = new MainController();
	}

	@Test
	public void testGenerateFirstID() {
		int expected = 101;
		int actual = mainController.generateID(mainSystem.getEmployees());
		assertEquals(expected, actual);
	}

	@Test
	public void testGenerateNextID() {
		mainSystem.addEmployee(new Employee("101", "Jane"));
		int expected = 102;
		int actual = mainController.generateID(mainSystem.getEmployees());
		assertEquals(expected, actual);
	}

}
