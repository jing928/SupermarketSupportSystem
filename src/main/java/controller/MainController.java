package controller;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

import model.*;
import utility.DataAccess;
import view.MainSystemView;

public class MainController {

	private MainSystem model;
	private MainSystemView view;

	private String dataFilePath = "system.dat";

	private Scanner keyboard;

	// Menu states
	private boolean mainFinished;
	private boolean customerFinished;
	private boolean employeeFinished;

	public MainController() {
		this.view = new MainSystemView();
	}

	public void run() throws ClassNotFoundException {
		view.showWelcome();
		startUp();
		keyboard = new Scanner(System.in);
		runMainMenu();
	}

	private void runMainMenu() {
		mainFinished = false;
		while (!mainFinished) {
			view.showMainMenu();
			int choice;
			choice = this.askForInput(1, view.getMainMenuEndNum());
			this.handleMainMenuChoice(choice);
		}
		shutDown();
	}

	private void startUp() throws ClassNotFoundException {
		DataAccess loader = new DataAccess(dataFilePath);
		try {
			System.out.println("Loading saved information...\n");
			model = (MainSystem) loader.loadObject();
		} catch (IOException e) {
			// TODO this could be in a separate Error Handler
			System.out.println("There is no saved state of the program. Starting new...\n");
			model = new MainSystem();
		} finally {
			System.out.println("System started.\n");
		}
	}

	private void shutDown() {
		System.out.println("Shutting down...Saving data...\n");
		save();
		System.out.println("Goodbye!\n");
		System.exit(0);
	}

	void save() {
		DataAccess persister = new DataAccess(dataFilePath);
		try {
			persister.saveObject(model);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	int askForInput(int menuStart, int menuEnd) {
		int choice;
		do {
			System.out.println();
			// Assuming user will only enter integer numbers.
			choice = keyboard.nextInt();
			keyboard.nextLine();
			if (choice > menuEnd || choice < menuStart) {
				System.out.println("Error: invalid input. Please select again.\n");
			}
		} while (choice > menuEnd || choice < menuStart);

		return choice;
	}

	private void handleMainMenuChoice(int choice) {
		switch (choice) {
		case 1:
			this.runCustomerMenu();
			break;
		case 2:
			this.runEmployeeMenu();
			break;
		case 3:
			mainFinished = true;
			break;
		}
	}

	private void runCustomerMenu() {
		customerFinished = false;
		while (!customerFinished) {
			view.showCustomerMenu();
			int choice;
			choice = this.askForInput(1, view.getCusMenuEndNum());
			this.handleCustomerChoice(choice);
		}
	}

	private void handleCustomerChoice(int choice) {
		switch (choice) {
		case 1:
			String cusId = findCustomer();
			if (cusId.equals("b")) {
				return;
			} else {
				runCustomerControl(cusId);
			}
			break;
		case 2:
			String newCusId = createNewCustomer();
			System.out.println("Your customer ID and Rewards Card Number are both: " + newCusId + "\n");
			runCustomerControl(newCusId);
			break;
		case 3:
			customerFinished = true;
			break;
		}
	}

	private String createNewCustomer() {
		System.out.println("Please enter your name:\n");
		String name = keyboard.nextLine();
		System.out.println("Please enter your phone number:\n");
		String phoneNum = keyboard.nextLine();
		System.out.println("Please enter your street number:\n");
		String streetNum = keyboard.nextLine();
		System.out.println("Please enter street name:\n");
		String streetName = keyboard.nextLine();
		System.out.println("Please enter your unit number:\n");
		String unitNum = keyboard.nextLine();
		System.out.println("Please enter your suburn:\n");
		String suburb = keyboard.nextLine();
		System.out.println("Please enter your zip code:\n");
		String zipCode = keyboard.nextLine();
		Location loc = new Location(streetNum, streetName, unitNum, suburb, zipCode);
		int idSeq = generateID(model.getCustomers());
		String id = "C" + idSeq;
		model.addCustomer(new Customer(id, name, phoneNum, loc));
		save();
		return id;
	}

	private void runCustomerControl(String cusKey) {
		Customer cus = model.getCustomers().get(cusKey);
		CustomerController cusControl = new CustomerController(cus, this);
		cusControl.run();
	}

	private String findCustomer() {
		System.out.println("Please enter your customer ID:\n");
		String key = keyboard.nextLine();
		while (!model.getCustomers().containsKey(key) && !key.equals("b")) {
			System.out.println("ID doesn't exist, please enter again or press \"b\" to go back.\n");
			key = keyboard.nextLine();
		}
		return key;
	}

	private void runEmployeeMenu() {
		employeeFinished = false;
		while (!employeeFinished) {
			view.showEmployeeMenu();
			int choice;
			choice = this.askForInput(1, view.getEmpMenuEndNum());
			this.handleEmployeeChoice(choice);
		}
	}

	private void handleEmployeeChoice(int choice) {
		switch (choice) {
		case 1:
			String empId = findEmployee();
			if (empId.equals("b")) {
				return;
			} else {
				runEmployeeControl(empId);
			}
			break;
		case 2:
			String newEmpId = createNewEmployee();
			System.out.println("Your employee ID is: " + newEmpId + "\n");
			runEmployeeControl(newEmpId);
			break;
		case 3:
			employeeFinished = true;
			break;
		}

	}

	private void runEmployeeControl(String empKey) {
		Employee emp = model.getEmployees().get(empKey);
		EmployeeController empControl;
		if (emp instanceof Manager) {
			empControl = new ManagerController(emp, this);
		} else if (emp instanceof SalesStaff) {
			empControl = new SalesStaffController(emp, this);
		} else {
			empControl = new WarehouseStaffController(emp, this);
		}

		empControl.run();
	}

	private String findEmployee() {
		System.out.println("Please enter your employee ID:\n");
		String key = keyboard.nextLine();
		while (!model.getEmployees().containsKey(key) && !key.equals("b")) {
			System.out.println("ID doesn't exist, please enter again or press \"b\" to go back.\n");
			key = keyboard.nextLine();
		}
		return key;
	}

	private String createNewEmployee() {
		// In in real world, it should not allow anyone to create a new employee.
		// It should be password protected.
		System.out.println("Please enter employee type:\nM for Manager\nS for Sales\nW for Warehouse\n");
		String type = keyboard.nextLine().toLowerCase();
		System.out.println("Please enter your name:\n");
		String name = keyboard.nextLine();
		int idSeq = generateID(model.getEmployees());
		String id = "";
		switch (type) {
		case "m":
			id = "M" + idSeq;
			model.addEmployee(new Manager(id, name));
			break;
		case "s":
			id = "S" + idSeq;
			model.addEmployee(new SalesStaff(id, name));
			break;
		case "w":
			id = "W" + idSeq;
			model.addEmployee(new WarehouseStaff(id, name));
			break;
		}
		save();
		return id;
	}

	public void addProduct(Product item) {
		model.addProduct(item);
		model.addNameBarCodePair(item.getName(), item.getBarCode());
		save();
	}

	public void addSupplier(Supplier supplier) {
		model.addSupplier(supplier);
		save();
	}

	public <T extends Map<?, ?>> int generateID(T map) {
		return map.size() + 101;
	}

	public MainSystem getModel() {
		return model;
	}

	public void setModel(MainSystem model) {
		this.model = model;
	}

	public MainSystemView getView() {
		return view;
	}

	public Scanner getKeyboard() {
		return keyboard;
	}

	public void setView(MainSystemView view) {
		this.view = view;
	}

	public boolean isMainFinished() {
		return mainFinished;
	}

	public void setMainFinished(boolean mainFinished) {
		this.mainFinished = mainFinished;
	}

	public boolean isCustomerFinished() {
		return customerFinished;
	}

	public void setCustomerFinished(boolean customerFinished) {
		this.customerFinished = customerFinished;
	}

	public boolean isEmployeeFinished() {
		return employeeFinished;
	}

	public void setEmployeeFinished(boolean employeeFinished) {
		this.employeeFinished = employeeFinished;
	}

	public Product getProductByKey(String barCode) {
		return model.getCatalog().get(barCode);
	}

	public String getBarCodeByName(String name) {
		return model.getBarCodeLookUp().get(name);
	}

	public Supplier getSupplierByKey(String id) {
		return model.getSuppliers().get(id);
	}

}
