package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import exception.InvalidInputException;
import exception.ProductNotFoundException;
import model.Customer;
import model.DebitCard;
import model.Employee;
import model.Membership;
import model.Product;
import model.Sale;
import model.SalesLineItem;
import model.SalesStaff;
import model.StockLevelException;
import view.CustomerView;

public class CustomerController {

	private Customer model;
	private CustomerView view;
	private MainController auxControl; // Auxiliary controller
	private Scanner keyboard;

	private Sale currentSale; // Hold the current transaction

	// Menu states
	private boolean mainCusFinished;
	private boolean checkoutFinished;
	private boolean modifyFinished;

	public CustomerController(Customer model, MainController auxControl) {
		this.model = model;
		this.auxControl = auxControl;
		this.view = new CustomerView();
		this.keyboard = auxControl.getKeyboard();
	}

	public void run() {
		view.showWelcome(model.getName());
		runMenu();
	}

	private void runMenu() {
		mainCusFinished = false;
		while (!mainCusFinished) {
			view.showMenu();
			int choice;
			choice = auxControl.askForInput(1, view.getMenuEndNum());
			handleMenuChoice(choice);
		}
	}

	private void handleMenuChoice(int choice) {
		switch (choice) {
		case 1:
			checkout();
			break;
		case 2:
			checkPrice();
			break;
		case 3:
			checkBulkDiscount();
			break;
		case 4:
			checkDebitCard();
			break;
		case 5:
			checkRewardsAccount();
			break;
		case 6:
			mainCusFinished = true;
			auxControl.setCustomerFinished(true);
			break;
		}
	}

	private void checkout() {
		if (model.getDebitCard() == null) {
			System.out.println("Please purchase a debit card first. See sales staff for details.\n");
			return;
		}
		// TODO: may be able to continue a previous incomplete sale or start a new
		currentSale = new Sale(model);
		runCheckOutMenu();
	}

	private void runCheckOutMenu() {
		checkoutFinished = false;
		while (!checkoutFinished) {
			view.showCheckoutMenu();
			int choice;
			choice = auxControl.askForInput(1, view.getCKMenuEndNum());
			handleCheckoutChoice(choice);
		}
	}

	private void handleCheckoutChoice(int choice) {
		switch (choice) {
		case 1:
			addItem();
			break;
		case 2:
			modifyTransaction();
			break;
		case 3:
			if (cancelTransaction()) {
				// If success, go back to previous menu
				System.out.println("Transaction cancelled.\n");
				checkoutFinished = true;
			}
			break;
		case 4:
			pay();
			checkoutFinished = true;
			break;
		case 5:
			checkoutFinished = true;
			break;
		}
	}

	private void addItem() {
		Product item = findProduct();
		if (item == null) {
			return;
		}
		String unit = item.isByWeight() ? "weight" : "number of items";
		double quantity;

		boolean inputSuccess = false;
		do {
			System.out.println(String.format("Please enter the %s:\n", unit));
			quantity = keyboard.nextDouble();
			try {
				currentSale.addLineItem(item, quantity);
				inputSuccess = true;
			} catch (InvalidInputException iie) {
				System.out.println(iie.getMessage());
			} catch (StockLevelException sle) {
				// A little weird as if the customer can get to the checkout point, it must mean
				// the inventory has enough stock, but we still need to check the inventory to
				// validate user input. TODO: May need to update.
				System.out.println(sle.getMessage());
			}
		} while (!inputSuccess);

		System.out.println(String.format("%s successfully added.\n", item.getName()));
	}

	private void modifyTransaction() {
		if (!verifySalesStaffStatus()) {
			return;
		}
		runModifyTransactionMenu();
	}

	private void runModifyTransactionMenu() {
		modifyFinished = false;
		while (!modifyFinished) {
			view.showModifyTransactionMenu();
			int choice;
			choice = auxControl.askForInput(1, view.getMTMenuEndNum());
			handleModificationChoice(choice);
		}
	}

	private void handleModificationChoice(int choice) {
		switch (choice) {
		case 1:
			removeItem();
			modifyFinished = true;
			break;
		case 2:
			updateQuantity();
			modifyFinished = true;
			break;
		case 3:
			modifyFinished = true;
			break;
		}
	}

	private void removeItem() {
		String itemName = locateLineItem();
		if (itemName.equals("b")) {
			System.out.println("Nothing removed. Going back...\n");
			return;
		}
		SalesLineItem removedItem = currentSale.getLineItems().remove(itemName);

		if (removedItem != null) {
			double quantity = removedItem.getQuantity();
			String name = removedItem.getItem().getName();
			System.out.println(String.format("%1$.2f %2$s removed from the shopping cart.\n", quantity, name));
		} else {
			System.out.println("Something went wrong...Please try again.\n");
		}

	}

	private void updateQuantity() {
		String itemName = locateLineItem();
		if (itemName.equals("b")) {
			System.out.println("Nothing removed. Going back...\n");
			return;
		}

		boolean updated = false;
		double newQuantity;
		do {
			System.out.println("Please enter the new quantity for " + itemName + ":\n");
			newQuantity = keyboard.nextDouble();
			keyboard.nextLine();
			try {
				currentSale.getLineItems().get(itemName).setQuantity(newQuantity);
				updated = true;
			} catch (InvalidInputException e) {
				System.out.println(e.getMessage());
			}
		} while (!updated);

		SalesLineItem updatedItem = currentSale.getLineItems().get(itemName);
		System.out.println(String.format("New quantity for %1$s is: %2$.2f\n", updatedItem.getItem().getName(),
				updatedItem.getQuantity()));
	}

	private String locateLineItem() {
		String name;
		boolean nameExists = false;
		do {
			System.out.println("Please enter the product name you want to remove or enter \"b\" to go back:\n");
			name = keyboard.nextLine();
			nameExists = currentSale.getLineItems().containsKey(name);
		} while (!nameExists && !name.equals("b"));
		return name;
	}

	private boolean cancelTransaction() {
		if (!verifySalesStaffStatus()) {
			return false;
		}
		// If the sales staff status is verified, then clear out the current sale
		// instance to cancel the transaction.
		currentSale = null;
		return true;
	}

	private boolean verifySalesStaffStatus() {
		System.out.println("A friendly sales staff is on the way to help...\n");
		Employee salesStaff;
		do {
			System.out.println("Please enter your employee ID:\n");
			String key = keyboard.nextLine();
			salesStaff = auxControl.getEmployeeByKey(key);
			if (salesStaff == null) {
				System.out.println("ID doesn't exist, please enter again.\n");
			}
		} while (salesStaff == null);

		if (!(salesStaff instanceof SalesStaff)) {
			System.out.println("You are not a sales staff. Please have a sales staff enter again.\n");
			return false;
		}

		return true;
	}

	private void pay() {
		if (currentSale.getLineItems().size() == 0) {
			System.out.println("There is nothing in the shopping cart. Nothing to pay.\n");
			return;
		}
		// Calculate price and deduct from debit card
		double totalPrice = currentSale.getTotalPrice();
		boolean isPaid = model.getDebitCard().deductMoney(totalPrice);
		if (isPaid) {
			currentSale.finalizeSale();
			model.addSale(currentSale); // Add to customer
			auxControl.getModel().addSale(currentSale); // Add to system
			auxControl.save(); // Save information (serialization)
			System.out.println(String.format("Payment successful. Total paid: $%.2f\n", totalPrice));
		} else {
			System.out.println("Your debit card doesn't have sufficient balance. Please see sales staff to top up.\n");
		}
	}

	private void checkPrice() {
		Product item = findProduct();
		if (item == null) {
			return;
		}
		view.showInfo(item.toString());
	}

	private void checkBulkDiscount() {
		Product item = findProduct();
		if (item == null) {
			return;
		}
		view.showInfo(item.getInventory().getBulkDiscountInfo());
	}

	private void checkDebitCard() {
		DebitCard card = model.getDebitCard();
		if (card == null) {
			view.showDebitCardError();
		} else {
			view.showInfo(card.toString());
		}
	}

	private void checkRewardsAccount() {
		Membership card = model.getRewardsAccount();
		view.showInfo(card.toString());
	}

	private Product findProduct() {
		String barCode = "";
		try {
			barCode = runProductFinderMenu();
		} catch (ProductNotFoundException e) {
			// Going back to the previous menu
			System.out.println(e.getMessage());
			return null;
		}
		return auxControl.getProductByKey(barCode);
	}

	private String runProductFinderMenu() throws ProductNotFoundException {
		view.showProductFinderMenu();
		int choice;
		choice = auxControl.askForInput(1, view.getPFMenuEndNum());
		String barCode = handleProductFinder(choice);
		if (barCode.equals("b")) {
			throw new ProductNotFoundException("User chose to go back");
		}
		return barCode;
	}

	private String handleProductFinder(int choice) {
		switch (choice) {
		case 1:
			return findByBarCode();
		case 2:
			return findByName();
		case 3:
			return selectFromList();
		case 4:
			return "b"; // b means go back to the previous menu
		default:
			return "b";
		}
	}

	private String findByBarCode() {
		System.out.println("Please enter the bar code of the product:\n");
		String barCode = keyboard.nextLine();
		while (!auxControl.getModel().getCatalog().containsKey(barCode) && !barCode.equals("b")) {
			System.out.println("Bar code doesn't exist, please enter again or press \"b\" to go back.\n");
			barCode = keyboard.nextLine();
		}
		return barCode;
	}

	private String findByName() {
		System.out.println("Please enter the name of the product:\n");
		String name = keyboard.nextLine();
		while (!auxControl.getModel().getBarCodeLookUp().containsKey(name) && !name.equals("b")) {
			System.out.println("Name doesn't exist, please enter again or press \"b\" to go back.\n");
			name = keyboard.nextLine();
		}
		String barCode;
		if (name.equals("b")) {
			barCode = name;
		} else {
			barCode = auxControl.getBarCodeByName(name);
		}
		return barCode;
	}

	private String selectFromList() {
		List<String> nameList = new ArrayList<String>(auxControl.getModel().getBarCodeLookUp().keySet());
		if (nameList.isEmpty()) {
			System.out.println("There is no product in the system yet. Going back to previous menu.\n");
			return "b";
		}
		nameList.add(0, "**** PRODUCT LIST ****");
		nameList.add("Enter your choice:");
		String[] list = (String[]) nameList.toArray(new String[nameList.size()]);
		view.showProductList(list);
		int choice = auxControl.askForInput(1, list.length - 2);
		String name = nameList.get(choice);
		return auxControl.getBarCodeByName(name);
	}

}
