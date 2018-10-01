package view;

public class CustomerView {
	
	private final String[] MENU = { 
			"**** MAIN CUSTOMER MENU ****", 
			"Checkout:", 
			"Check Price:",
			"Check Bulk Discount",
			"View Debit Card Info",
			"View Rewards Account Info",
			"Go Back to Main Menu:",
			"Enter your choice:" 
	};
	
	private final String[] PRODUCTFINDERMENU = { 
			"**** PRODUCT FINDER MENU ****", 
			"Find by Bar Code:", 
			"Find by Name:",
			"Select From List",
			"Go Back:",
			"Enter your choice:" 
	};

	public CustomerView() {
		
	}
	
	public int getMenuEndNum() {
		return MENU.length - 2;
	}
	
	public int getPFMenuEndNum() {
		return PRODUCTFINDERMENU.length - 2;
	}
	
	public void showWelcome(String name) {
		System.out.println("Welcome " + name + "!\n");
	}
	
	public void showMenu() {
		MenuPrinter.printMenu(MENU);
	}
	
	public void showInfo(String info) {
		System.out.println(info);
	}
	
	public void showDebitCardError() {
		System.out.println("You don't have a debit card yet, please find sales staff to purchase one.\n");
	}

	public void showProductFinderMenu() {
		MenuPrinter.printMenu(PRODUCTFINDERMENU);
	}
	
	public void showProductList(String[] list) {
		MenuPrinter.printMenu(list);
	}
	
}
