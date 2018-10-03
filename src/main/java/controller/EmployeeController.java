package controller;

import java.util.Scanner;

import exception.InvalidInputException;
import exception.ProductNotFoundException;
import model.Employee;
import model.Product;
import model.Supplier;
import view.EmployeeView;

public abstract class EmployeeController {
	private Employee model;
	private EmployeeView view;
	private MainController auxControl; // Auxiliary controller
	private Scanner keyboard;

	protected EmployeeController(Employee model, MainController auxControl) {
		this.model = model;
		this.auxControl = auxControl;
		this.view = new EmployeeView();
		this.keyboard = auxControl.getKeyboard();
	}

	public void run() {
		view.showWelcome(model.getName());
		runMenu();
	}

	abstract void runMenu();

	protected void addProduct() {
		System.out.println("Please enter the product name:\n");
		String name = keyboard.nextLine();
		System.out.println("Please enter the unit price:\n");
		double price = keyboard.nextDouble();
		keyboard.nextLine();
		System.out.println("Is the product weightable? Enter \"true\" or \"false\"\n");
		boolean byWeight = keyboard.nextBoolean();
		keyboard.nextLine();
		String supplierId;
		Supplier supplier;
		do {
			System.out.println("Please enter the supplier ID:\n");
			supplierId = keyboard.nextLine();
			supplier = auxControl.getSupplierByKey(supplierId);
			if (supplier == null) {
				System.out.println("The supplier doesn't exist. Please enter again or press \"x\" to skip.\n");
			}
		} while (supplier == null && !supplierId.equals("x"));
		
		Product item = new Product(name, price, byWeight);
		boolean stockLevelSet = false;
		do {
			System.out.println("Set the initial stock level:\n");
			double stockLevel = keyboard.nextDouble();
			keyboard.nextLine();
			try {
				item.getInventory().setStockLevel(stockLevel);
				stockLevelSet = true;
			} catch (InvalidInputException e) {
				System.out.println("Stock level cannot be negative.\n");
			}
		} while (stockLevelSet);
		
		boolean replenishLevelSet = false;
		do {
			System.out.println("Set the initial replenish level:\n");
			double replenishLevel = keyboard.nextDouble();
			keyboard.nextLine();
			try {
				item.getInventory().setStockLevel(replenishLevel);
				replenishLevelSet = true;
			} catch (InvalidInputException e) {
				System.out.println("Replenish level cannot be negative.\n");
			}
		} while (replenishLevelSet);
		
		auxControl.getModel().addProduct(item);
		auxControl.save();
		System.out.println("New product " + item.getName() + " added.\n");
	}
	
	protected Product findProduct() throws ProductNotFoundException {
		System.out.println("Please enter the product name:\n");
		String name = keyboard.nextLine();
		while (!auxControl.getModel().getBarCodeLookUp().containsKey(name) && !name.equals("b")) {
			System.out.println("Name doesn't exist, please enter again or press \"b\" to go back.\n");
			name = keyboard.nextLine();
		}
		String barCode;
		if (name.equals("b")) {
			throw new ProductNotFoundException("Product not found. User chose to go back");
		} else {
			barCode = auxControl.getBarCodeByName(name);
		}
		return auxControl.getProductByKey(barCode);
	}

	public Employee getModel() {
		return model;
	}

	public EmployeeView getView() {
		return view;
	}

	public MainController getAuxControl() {
		return auxControl;
	}

	public Scanner getKeyboard() {
		return keyboard;
	}

}
