package controller;

import exception.InvalidInputException;
import exception.ProductNotFoundException;
import model.Employee;
import model.Product;

public class WarehouseStaffController extends EmployeeController {

	// Menu states
	private boolean mainWarehouseFinished;

	public WarehouseStaffController(Employee model, MainController auxControl) {
		super(model, auxControl);
	}

	@Override
	void runMenu() {
		mainWarehouseFinished = false;
		while (!mainWarehouseFinished) {
			getView().showWarehouseMenu();
			int choice;
			choice = getAuxControl().askForInput(1, getView().getWHMenuEndNum());
			handleMenuChoice(choice);
		}
	}

	private void handleMenuChoice(int choice) {
		switch (choice) {
		case 1:
			addProduct();
			break;
		case 2:
			replenishProduct();
			break;
		case 3:
			mainWarehouseFinished = true;
			getAuxControl().setEmployeeFinished(true);
			break;
		}
	}

	private void replenishProduct() {
		Product item;
		try {
			item = findProduct();
		} catch (ProductNotFoundException e) {
			System.out.println("No product found. Going back to previous menu.\n");
			return;
		}
		boolean quantitySet = false;
		do {
			System.out.println("Set the replenish quantity:\n");
			double quantity = getKeyboard().nextDouble();
			getKeyboard().nextLine();
			try {
				item.getInventory().increaseStockLevel(quantity);
				quantitySet = true;
			} catch (InvalidInputException e) {
				System.out.println("Quantity cannot be negative.\n");
			}
		} while (quantitySet);

		getAuxControl().save();
		System.out.println("Stock level for " + item.getName() + " increased by " + "quantity" + ".\n");
	}

}
