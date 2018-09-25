package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class MainSystem implements Serializable {

	private static final long serialVersionUID = -3419042963240403378L;

	private Map<String, Employee> employees;
	private Map<String, Supplier> suppliers;
	private Map<String, Customer> customers;
	// Key: Product Name; Value: Bar-code. In real life, it may be the opposite, but
	// here name is easier to remember.
	private Map<String, String> barCodeLookUp;
	private Map<String, Product> catalog;

	public MainSystem() {
		this.employees = new HashMap<String, Employee>();
		this.suppliers = new HashMap<String, Supplier>();
		this.customers = new HashMap<String, Customer>();
		this.barCodeLookUp = new HashMap<String, String>();
		this.catalog = new HashMap<String, Product>();
	}

	public Map<String, Employee> getEmployees() {
		return employees;
	}

	public Map<String, Supplier> getSuppliers() {
		return suppliers;
	}

	public Map<String, Customer> getCustomers() {
		return customers;
	}

	public Map<String, String> getBarCodeLookUp() {
		return barCodeLookUp;
	}

	public Map<String, Product> getCatalog() {
		return catalog;
	}
}
