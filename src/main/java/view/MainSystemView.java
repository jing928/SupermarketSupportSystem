package view;

public class MainSystemView {

	private final String WELCOME = "Welcome to the Supermarket Support System!\n";
	private final String[] MAINMENU = { 
			"**** MAIN SYSTEM MENU ****", 
			"Customer Login:", 
			"Employee Login:", 
			"Exit Program:",
			"Enter your choice:" 
	};
	private final String[] CUSTOMERMENU = {
			"**** CUSTOMER MENU ****",
			"Existing Customer:",
			"New Customer:",
			"Go Back:",
			"Enter your choice:"
	};
	

	public MainSystemView() {

	}
	
	public int getMainMenuEndNum() {
		return MAINMENU.length - 2;
	}

	public int getCusMenuEndNum() {
		return CUSTOMERMENU.length - 2;
	}

	public void showWelcome() {
		System.out.println(WELCOME);
	}

	public void showMainMenu() {
		MenuPrinter.printMenu(MAINMENU);
	}

	public void showCustomerMenu() {
		MenuPrinter.printMenu(CUSTOMERMENU);
	}

	public void showEmployeeMenu() {

	}
	
}
