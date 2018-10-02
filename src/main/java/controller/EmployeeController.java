package controller;

import java.util.Scanner;

import model.Employee;
import view.EmployeeView;

public class EmployeeController {
	private Employee model;
	private EmployeeView view;
	private MainController auxControl; // Auxiliary controller
	private Scanner keyboard;

	public EmployeeController(Employee model, MainController auxControl) {
		this.model = model;
		this.auxControl = auxControl;
		this.view = new EmployeeView();
		this.keyboard = auxControl.getKeyboard();
	}

	public void run() {
		view.showWelcome(model.getName());
		runMenu();
	}
}
