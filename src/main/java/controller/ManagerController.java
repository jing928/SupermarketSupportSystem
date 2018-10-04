package controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

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
			System.out.println(e.getMessage());
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
				System.out.println(e.getMessage());
			}

		} while (!priceSet);
		getAuxControl().save();
		System.out.println(String.format("Price for %1$s is now: $%2$.2f\n", item.getName(), item.getUnitPrice()));
	}

	private void offerBulkDiscount() {
		Product item;
		try {
			item = findProduct();
		} catch (ProductNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		System.out.println(item.getInventory().getBulkDiscountInfo());
		setBulkQuantity(item);
		setDiscount(item);
		getAuxControl().save();
		System.out.println(item.getInventory().getBulkDiscountInfo());
	}

	private void setBulkQuantity(Product item) {
		boolean bulkQuantitySet = false;
		do {
			System.out.println("Set the bulk quantity:\n");
			double bulkQuantity = getKeyboard().nextDouble();
			getKeyboard().nextLine();
			try {
				item.getInventory().setBulkQuantity(bulkQuantity);
				bulkQuantitySet = true;
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} while (!bulkQuantitySet);
	}

	private void setDiscount(Product item) {
		boolean discountSet = false;
		do {
			System.out.println("Set the discount (enter percentage off as decimal):\n");
			double discount = getKeyboard().nextDouble();
			getKeyboard().nextLine();
			try {
				item.getInventory().setDiscount(discount);
				discountSet = true;
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} while (!discountSet);
	}

	private void generateSalesReport() {
		String report;
		System.out.println("Enter 1 for all periods.\nEnter 2 to specify range.\n");
		int choice = getKeyboard().nextInt();
		getKeyboard().nextLine();
		if (choice == 1) {
			report = getAuxControl().getModel().getSalesReport();
			System.out.println(report);
		} else if (choice == 2) {
			// TODO add range validation. start must be before end, etc.
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
			System.out.println("Please enter the start date (in yyyy/mm/dd format):\n");
			LocalDateTime start = LocalDateTime.parse(getKeyboard().nextLine(), formatter);
			System.out.println("Please enter the end date (in yyyy/mm/dd format):\n");
			LocalDateTime end = LocalDateTime.parse(getKeyboard().nextLine(), formatter);
			report = getAuxControl().getModel().getSalesReport(start, end);
			System.out.println(report);
		} else {
			System.out.println("Invalid input. Going back to previous menu.\n");
		}
	}

	private void generateSupplyReport() {
		String report = getAuxControl().getModel().getSupplyReport();
		System.out.println(report);
	}

	private void listMostProfitable() {
		int topX;
		do {
			System.out.println("Please enter the number of top products as a whole number:\n");
			topX = getKeyboard().nextInt();
			getKeyboard().nextLine();
			if (topX <= 0) {
				System.out.println("The input must be positive.\n");
			}
		} while (topX <= 0);

		String list = getAuxControl().getModel().getMostProfitableProducts(topX);
		System.out.println(list);
	}

}
