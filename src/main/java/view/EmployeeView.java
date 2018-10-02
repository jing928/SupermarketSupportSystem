package view;

public class EmployeeView {
	
	private final String[] WAREHOUSEMENU = { 
			"**** MAIN WAREHOUSE STAFF MENU ****", 
			"Add New Product:", 
			"Replenish Product:",
			"Go Back to Main Menu:",
			"Enter your choice:" 
	};

	public EmployeeView() {
		
	}
	
	public void showWelcome(String name) {
		System.out.println("Welcome " + name + "!\n");
	}
	
	public int getWHMenuEndNum() {
		return WAREHOUSEMENU.length - 2;
	}
	
	public void showWarehouseMenu() {
		MenuPrinter.printMenu(WAREHOUSEMENU);
	}
}
