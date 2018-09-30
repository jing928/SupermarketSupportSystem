package view;

public class CustomerView {
	
	private final String[] MENU = { 
			"**** MAIN CUSTOMER MENU ****", 
			"Checkout:", 
			"Check Price:",
			"Check Bulk Discount",
			"View Debit Card Info",
			"View Loyalty Points",
			"Go Back to Main Menu:",
			"Enter your choice:" 
	};

	public CustomerView() {
		
	}
	
	public int getMenuEndNum() {
		return MENU.length - 2;
	}
	
	public void showWelcome(String name) {
		System.out.println("Welcome " + name + "!\n");
	}
	
	public void showMenu() {
		MenuPrinter.printMenu(MENU);
	}
	
	public void showBalance(int balance) {
		System.out.println("Your current loyalt rewards balance: " + balance + " points.\n");
	}
}
