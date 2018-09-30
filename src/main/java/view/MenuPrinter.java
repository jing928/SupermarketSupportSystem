package view;

public class MenuPrinter {

	public static void printMenu(String[] items) {
		for (int i = 0; i < items.length; i++) {
			if (i == 0) {
				System.out.println(items[i]);
				System.out.println();
			} else if (i == items.length - 1) {
				System.out.println(items[i]);
			} else {
				String item = String.format("%-30s %s", items[i], i);
				System.out.println(item);
			}
		}

		System.out.println();
	}
	
}
