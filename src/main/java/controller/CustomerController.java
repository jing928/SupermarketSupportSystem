package controller;

import model.Customer;
import view.CustomerView;

public class CustomerController {

	private Customer model;
	private CustomerView view;
	private MainController auxControl; // Auxiliary controller

	public CustomerController(Customer model, MainController auxControl) {
		this.model = model;
		this.auxControl = auxControl;
		this.view = new CustomerView();
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
			checkPointsBalance();
			runMenu();
			break;
		case 5:
			auxControl.runMainMenu();
			break;
		}
	}
	
	private void checkout() {
		
	}
	
	private void checkPrice() {
		
	}

	private void checkBulkDiscount() {

	}

	private void checkPointsBalance() {
		int balance = model.getRewardsAccount().getPointBalance();
		view.showBalance(balance);
	}

}
