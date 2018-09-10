package model;

public class SalesStaff extends Employee {

	public SalesStaff() {
		super();
	}

	public boolean addDebitCard(Customer customer, double initialAmount) {
		if (initialAmount < 0) {
			return false;
		}
		return true;
	}

	public boolean topUpDebitCard(Customer customer, double amount) {
		if (amount < 0) {
			return false;
		}

		return true;
	}

	public boolean modifySale(Sale sale) {
		return false;
	}

	public boolean cancelSale(Sale sale) {
		return false;
	}

}