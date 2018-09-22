package model;

import exception.InvalidInputException;

public class SalesStaff extends Employee {

	public void addDebitCard(Customer customer, double initialAmount, DebitCard debitcard) {
		customer.setDebitCard(debitcard);
		System.out.println("The balance of this card is :" + debitcard.getBalance());
	}

	public void topUpDebitCard(DebitCard debitcard, double amount) {
		debitcard.addMoney(amount);
		System.out.println("The balance of this card is :" + debitcard.getBalance());
	}

	// TODO
	public void modifySaleQuantity(Sale sale, double quantity) throws InvalidInputException {
		sale.getLineItems().get(0).setQuantity(quantity);
	}

	// TODO
	public void modifySaleProduct() {

	}

	// TODO
	public void cancleSaleItem() {

	}

	// TODO
	public void cancleSale() {

	}

}