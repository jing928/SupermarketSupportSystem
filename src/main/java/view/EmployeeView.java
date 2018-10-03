package view;

public class EmployeeView {
	
	private final String[] WAREHOUSEMENU = { 
			"**** MAIN WAREHOUSE STAFF MENU ****", 
			"Add New Product:", 
			"Replenish Product:",
			"Go Back to Main Menu:",
			"Enter your choice:" 
	};
	
	private final String[] MANAGERMENU = { 
			"**** MAIN MANAGER MENU ****", 
			"Add New Product:", 
			"Add New Supplier:",
			"Modify Unit Price:",
			"Offer Bulk Discount:",
			"Generate Sales Report:",
			"Generate Supply Report:",
			"List Most Profitable Product:",
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
	
	public int getMgrMenuEndNum() {
		return MANAGERMENU.length - 2;
	}
	
	public void showManagerMenu() {
		MenuPrinter.printMenu(MANAGERMENU);
	}
}
