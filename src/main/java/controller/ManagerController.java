package controller;

import exception.InvalidInputException;
import exception.ProductNotFoundException;
import model.Employee;
import model.Location;
import model.Product;
import model.Supplier;

public class ManagerController extends EmployeeController {

	// Menu states
	private boolean mainManagerFinished;

	public ManagerController(Employee model, MainController auxControl) {
		super(model, auxControl);
	}

	@Override
	void runMenu() {
		mainManagerFinished = false;
		while (!mainManagerFinished) {
			getView().showManagerMenu();
			int choice;
			choice = getAuxControl().askForInput(1, getView().getMgrMenuEndNum());
			handleMenuChoice(choice);
		}
	}

	private void handleMenuChoice(int choice) {
		switch (choice) {
		case 1:
			addProduct();
			break;
		case 2:
			addSuplier();
			break;
		case 3:
			modifyPrice();
			break;
		case 4:
			offerBulkDiscount();
			break;
		case 5:
			generateSalesReport();
			break;
		case 6:
			generateSupplyReport();
			break;
		case 7:
			listMostProfitable();
			break;
		case 8:
			mainManagerFinished = true;
			getAuxControl().setEmployeeFinished(true);
			break;
		}
	}

	private void addSuplier() {
		System.out.println("Please enter supplier name:\n");
		String name = getKeyboard().nextLine();
		System.out.println("Please enter supplier phone number:\n");
		String phoneNum = getKeyboard().nextLine();
		System.out.println("Please enter supplier street number:\n");
		String streetNum = getKeyboard().nextLine();
		System.out.println("Please enter supplier street name:\n");
		String streetName = getKeyboard().nextLine();
		System.out.println("Please enter supplier unit number:\n");
		String unitNum = getKeyboard().nextLine();
		System.out.println("Please enter supplier suburn:\n");
		String suburb = getKeyboard().nextLine();
		System.out.println("Please enter supplier zip code:\n");
		String zipCode = getKeyboard().nextLine();
		Location loc = new Location(streetNum, streetName, unitNum, suburb, zipCode);
		int idSeq = getAuxControl().generateID(getAuxControl().getModel().getSuppliers());
		String id = "SUP" + idSeq;
		getAuxControl().addSupplier(new Supplier(id, name, loc, phoneNum));
	}

	private void modifyPrice() {
		Product item;
		try {
			item = findProduct();
		} catch (ProductNotFoundException e) {
			System.out.println("No product found. Going back to previous menu.\n");
			return;
		}
		String unit = item.isByWeight() ? "per kg" : "each";
		double currentPrice = item.getUnitPrice();
		System.out.println(String.format("The current price is $%1$.2f %2$s.\n", currentPrice, unit));
		double newPrice;
		boolean priceSet = false;
		do {
			System.out.println("Please enter the new price:\n");
			newPrice = getKeyboard().nextDouble();
			getKeyboard().nextLine();
			try {
				item.setUnitPrice(newPrice);
				priceSet = true;
			} catch (InvalidInputException e) {
				System.out.println("Price cannot be negative.\n");
			}

		} while (!priceSet);
		getAuxControl().save();
		System.out.println(String.format("Price for %1$s is now: $%2$.2f\n", item.getName(), item.getUnitPrice()));
	}

	private void offerBulkDiscount() {
		// TODO Auto-generated method stub

	}

	private void generateSalesReport() {
		// TODO Auto-generated method stub

	}

	private void generateSupplyReport() {
		// TODO Auto-generated method stub

	}

	private void listMostProfitable() {
		// TODO Auto-generated method stub

	}

}
