package model;

import java.util.*;
import java.text.SimpleDateFormat;

public class Employee {
	private String emId;
	private String emName;
	private char emGender;
	private Date emBirthday;
	private SimpleDateFormat emBirthdayFormat;
	

	
	public Employee(String emId, String emName, char emGender) {
		setEmId(emId);
		setEmName(emName);
		setEmGender(emGender);
		
	}

	public Employee(String emId, String emName, char emGender, int year, int day, int month) {

		this.emId = emId;
		this.emName = emName;
		this.emGender = emGender;
		setEmBirthday(year, month, day);
	}

	private void setEmBirthday(int year, int month, int day) {
		
		if (year > 0 && month > 0 && day > 0) {
			Calendar cal = Calendar.getInstance();
			cal.set(year, month - 1, day, 0, 0, 0);
			emBirthday = cal.getTime();
		} else {

		}

	}

	public String getEmBirthday() {
		emBirthdayFormat = new SimpleDateFormat("MM-DD-YYYY");
		return emBirthdayFormat.format(emBirthday);
	}

	public String getEmId() {
		return emId;
	}

	public void setEmId(String emId) {
		this.emId = emId;
	}

	public String getEmName() {
		return emName;
	}

	public void setEmName(String emName) {
		this.emName = emName;
	}

	public char getEmGender() {
		return emGender;
	}

	public void setEmGender(char emGender) {
		this.emGender = emGender;
	}
	
	//TODO
	public void addProduct(String name, double unitPrice, boolean byweight) {
		Product product1=new Product(name, unitPrice, byweight);	
	}

}
