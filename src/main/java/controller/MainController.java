package controller;

import java.io.IOException;
import java.util.Scanner;

import model.MainSystem;
import utility.DataAccess;
import view.MainSystemView;

public class MainController {

	private MainSystem model;
	private MainSystemView view;

	private String dataFilePath = "system.dat";
	
	private Scanner keyboard;

	public MainController() {
		this.view = new MainSystemView();
	}

	public void run() throws ClassNotFoundException {
		view.showWelcome();
		startUp();
		keyboard = new Scanner(System.in);
		runMainMenu();
	}

	private void runMainMenu() {
		view.showMainMenu();
		int choice;
		choice = this.askForInput(1, 3);
		this.handleMainMenuChoice(choice);
	}

	private void startUp() throws ClassNotFoundException {
		DataAccess loader = new DataAccess(dataFilePath);
		try {
			System.out.println("Loading saved information...\n");
			model = (MainSystem) loader.loadObject();
		} catch (IOException e) {
			// TODO this could be in a separate Error Handler
			System.out.println("There is no saved state of the program. Starting new...\n");
			model = new MainSystem();
		} finally {
			System.out.println("System started.\n");
		}
	}

	private void shutDown() {
		System.out.println("Shutting down...Saving data...\n");
		DataAccess persister = new DataAccess(dataFilePath);
		try {
			persister.saveObject(model);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Goodbye!\n");
	}

	private int askForInput(int menuStart, int menuEnd) {
		int choice;
		do {
			System.out.println();
			// Assuming user will only enter integer numbers.
			choice = keyboard.nextInt();
			keyboard.nextLine();
			if (choice > menuEnd || choice < menuStart) {
				System.out.println("Error: invalid input. Please select again.\n");
			}
		} while (choice > menuEnd || choice < menuStart);

		return choice;
	}

	private void handleMainMenuChoice(int choice) {
		switch (choice) {
		case 1:
			this.runCustomerMenu();
			break;
		case 2:
			this.handleEmployee();
			break;
		case 3:
			shutDown();
			break;
		}
	}

	private void runCustomerMenu() {
		view.showCustomerMenu();
		int choice;
		choice = this.askForInput(1, 3);
		this.handleCustomerChoice(choice);
	}

	private void handleCustomerChoice(int choice) {
		switch (choice) {
		case 1:

			break;
//		case 2:
//			// create new customer
//			break
		case 3:
			runMainMenu();
			break;
		}
	}

	private void handleEmployee() {
		// TODO Auto-generated method stub

	}

	public MainSystem getModel() {
		return model;
	}

	public void setModel(MainSystem model) {
		this.model = model;
	}

	public MainSystemView getView() {
		return view;
	}

	public void setView(MainSystemView view) {
		this.view = view;
	}

}
