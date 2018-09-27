package view;

public class MainSystemView {

	private final String WELCOME = "Welcome to the Supermarket Support System!\n";
	private final String[] MAINMENUITEMS = { 
			"**** MAIN SYSTEM MENU ****", 
			"Customer Login:", 
			"Employee Login:", 
			"Exit Program:",
			"Enter your choice:" 
	};
	private final String[] CUSTOMERMENUITEMS = {
			"**** CUSTOMER MENU ****",
			"Existing Customer:",
			"New Customer:",
			"Go Back:",
			"Enter your choice:"
	};

	public MainSystemView() {

	}

	public void showWelcome() {
		System.out.println(WELCOME);
	}

	public void showMainMenu() {
		MenuPrinter.printMenu(MAINMENUITEMS);
	}
	
	public void showCustomerMenu() {
		MenuPrinter.printMenu(CUSTOMERMENUITEMS);
	}
	
	public void showEmployeeMenu() {
		
	}
	
}
