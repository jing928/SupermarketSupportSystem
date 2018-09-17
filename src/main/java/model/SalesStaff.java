package model;

public class SalesStaff extends Employee {

	public SalesStaff(String emId, String emName, char emGender) {
		super(emId, emName, emGender);
	}

	public void addDebitCard(Customer customer, double initialAmount, DebitCard debitcard) {
		customer.setDebitCard(debitcard);
		System.out.println("The balance of this card is :" + debitcard.getBalance());
	}

	public void topUpDebitCard(DebitCard debitcard, double amount) {
		debitcard.addMoney(amount);
		System.out.println("The balance of this card is :" + debitcard.getBalance());
	}

	// TODO
	public void modifySaleQuantity(Sale sale, double quantity) {
		sale.getSalesLineItems().get(0).setQuantity(quantity);
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