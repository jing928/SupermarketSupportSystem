package model;

public class SalesStaff extends Employee {

	public SalesStaff(String emId, String emName, char emGender) {
		super(emId, emName, emGender);
	}

	public void addDebitCard(Customer customer, double initialAmount, DebitCard debitcard) {
		customer.setDebitCard(debitcard);
		System.out.println("The balance of this card is :"+ debitcard.getBalance());
	}

	public void topUpDebitCard(DebitCard debitcard, double amount) {
		debitcard.addMoney(amount);
		System.out.println("The balance of this card is :"+ debitcard.getBalance());
	}

	// TODO 
	public boolean modifySale(Sale sale) {
		return false;
	}
	

	public boolean cancelSale(Sale sale) {
		return false;
	}

}