package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Customer;
import model.DebitCard;
import model.Membership;
import model.Product;
import model.Sale;
import view.CustomerView;

public class CustomerController {

	private Customer model;
	private CustomerView view;
	private MainController auxControl; // Auxiliary controller
	private Scanner keyboard;

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
		view.showMenu();
		int choice;
		choice = auxControl.askForInput(1, view.getMenuEndNum());
		handleMenuChoice(choice);
	}

	private void handleMenuChoice(int choice) {
		switch (choice) {
		case 1:
			checkout();
			runMenu();
			break;
		case 2:
			checkPrice();
			runMenu();
			break;
		case 3:
			checkBulkDiscount();
			runMenu();
			break;
		case 4:
			checkDebitCard();
			runMenu();
		case 5:
			checkRewardsAccount();
			runMenu();
			break;
		case 6:
			auxControl.runMainMenu();
			break;
		}
	}

	private void checkout() {
		if (model.getDebitCard() == null) {
			System.out.println("Please purchase a debit card first. See sales staff for details.\n");
			return;
		}
		Sale newSale = runCheckOutMenu();
		if (pay(newSale)) {
			// newSale.finalizeSale(); //TODO: need to figure out exceptions
			model.addSale(newSale);
			auxControl.getModel().addSale(newSale);
			return;
		} else {
			System.out.println("Your debit card doesn't have sufficient balance. Please see sales staff to top up.\n");
			return;
		}
	}

	private Sale runCheckOutMenu() {
		view.showMenu();
		int choice;
		choice = auxControl.askForInput(1, view.getMenuEndNum());
		handleMenuChoice(choice);
		return new Sale(model); //TODO: placeholder
	}
	
	private boolean pay(Sale sale) {
		// Calculate price and deduct from debit card
		return false;
	}

	private void checkPrice() {
		Product item = findProduct(this::runMenu);
		view.showInfo(item.toString());
	}

	private void checkBulkDiscount() {
		Product item = findProduct(this::runMenu);
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

	private Product findProduct(Runnable previousMenu) {
		String barCode = "";
		try {
			barCode = runProductFinderMenu();
		} catch (ProductNotFoundException e) {
			// Going back to the previous menu
			previousMenu.run();
		}
		return auxControl.getProductByKey(barCode);
	}

	private String runProductFinderMenu() throws ProductNotFoundException {
		view.showProductFinderMenu();
		int choice;
		choice = auxControl.askForInput(1, view.getPFMenuEndNum());
		String barCode = handleProductFinder(choice);
		if (barCode.equals("b")) {
			throw new ProductNotFoundException("Product not found. User chose to go back");
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
