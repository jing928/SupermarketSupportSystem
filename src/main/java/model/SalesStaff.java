package model;

public class SalesStaff extends Employee{

public SalesStaff() {
	super();
}
	
	
public boolean addDebitCard(Customer customer, double initialAmount) {
	return false;
}
public boolean topUpDebitCard(Customer customer, double amount) {
	return false;
}
public boolean modifySale(Sale sale) {
	return false;
}
public boolean cancelSale(Sale sale) {
	return false;
}

}