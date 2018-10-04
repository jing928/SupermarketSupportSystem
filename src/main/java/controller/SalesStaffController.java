package controller;

import exception.CustomerNotFoundException;
import model.Customer;
import model.DebitCard;
import model.Employee;

public class SalesStaffController extends EmployeeController {

	// Menu states
	private boolean mainSalesStaffMenuFinished;

	public SalesStaffController(Employee model, MainController auxControl) {
		super(model, auxControl);
	}

	@Override
	void runMenu() {
		mainSalesStaffMenuFinished = false;
		while (!mainSalesStaffMenuFinished) {
			getView().showSalesStaffMenu();
			int choice;
			choice = getAuxControl().askForInput(1, getView().getSalesMenuEndNum());
			handleMenuChoice(choice);
		}
	}

	private void handleMenuChoice(int choice) {
		switch (choice) {
		case 1:
			sellDebitCard();
			break;
		case 2:
			topUpDebitCard();
			break;
		case 3:
			mainSalesStaffMenuFinished = true;
			getAuxControl().setEmployeeFinished(true);
			break;
		}
	}

	private void sellDebitCard() {
		Customer cus;
		try {
			cus = locateCustomer();
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		String cardNum = "6610666688880" + cus.getId().substring(1);
		DebitCard card = new DebitCard(cardNum);
		if (cus.setDebitCard(card)) {
			getAuxControl().save();
			System.out.println(String.format("New debit card linked to %1$s (%2$s).", cus.getName(), cus.getId()));
			System.out.println(card.toString());
		} else {
			System.out.println("Something went wrong...Please try again later.\n");
		}

	}

	private void topUpDebitCard() {
		Customer cus;
		try {
			cus = locateCustomer();
		} catch (CustomerNotFoundException e) {
			System.out.println(e.getMessage());
			return;
		}
		double topUpValue;
		do {
			System.out.println("Please enter the top up value:\n");
			topUpValue = getKeyboard().nextDouble();
			getKeyboard().nextLine();
			if (topUpValue < 0) {
				System.out.println("Value cannot be negative.\n");
			}
		} while (topUpValue < 0);
		if (cus.getDebitCard().addMoney(topUpValue)) {
			getAuxControl().save();
			System.out.println("Top Up Successful.\n");
			System.out.println(cus.getDebitCard().toString());
		} else {
			System.out.println("Something went wrong...Please try again later.\n");
		}

	}

	private Customer locateCustomer() throws CustomerNotFoundException {
		System.out.println("Please enter the customer ID:\n");
		String key = getKeyboard().nextLine();
		while (!getAuxControl().getModel().getCustomers().containsKey(key) && !key.equals("b")) {
			System.out.println("ID doesn't exist, please enter again or press \"b\" to go back.\n");
			key = getKeyboard().nextLine();
		}
		if (key.equals("b")) {
			throw new CustomerNotFoundException("Customer not found. User chose to go back.");
		}
		return getAuxControl().getCustomerByKey(key);
	}

}
