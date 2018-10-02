package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
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
	private List<Sale> sales;

	public MainSystem() {
		this.employees = new HashMap<String, Employee>();
		this.suppliers = new HashMap<String, Supplier>();
		this.customers = new HashMap<String, Customer>();
		this.barCodeLookUp = new HashMap<String, String>();
		this.catalog = new HashMap<String, Product>();
		this.sales = new ArrayList<Sale>();
	}

	public <T extends Map<?, ?>> int generateID(T map) {
		return map.size() + 101;
	}

	public void addEmployee(Employee employee) {
		employees.put(employee.getId(), employee);
	}

	public void addSupplier(Supplier supplier) {
		suppliers.put(supplier.getId(), supplier);
	}

	public void addCustomer(Customer customer) {
		customers.put(customer.getId(), customer);
	}

	public void addNameBarCodePair(String productName, String productBarCode) {
		barCodeLookUp.put(productName, productBarCode);
	}

	public void addProduct(Product item) {
		catalog.put(item.getBarCode(), item);
	}

	public void addSale(Sale sale) {
		sales.add(sale);
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

	public List<Sale> getSales() {
		return sales;
	}

	public String generateSalesReport() {
		// Report for all sales
		String report = "";
		Iterator<Sale> it = sales.iterator();
		while (it.hasNext()) {
			Sale sale = it.next();
			report += sale.toString();
		}
		return report;
	}

	public String generateSalesReport(LocalDateTime start, LocalDateTime end) {
		// Report for specified date time range
		List<Sale> filtered = filterSalesbyDate(start, end);
		String report = "";
		Iterator<Sale> it = filtered.iterator();
		while (it.hasNext()) {
			Sale sale = it.next();
			report += sale.toString();
		}
		return report;
	}

	private List<Sale> filterSalesbyDate(LocalDateTime start, LocalDateTime end) {
		// TODO: needs test
		List<Sale> filtered = new ArrayList<Sale>();
		Iterator<Sale> it = sales.iterator();

		while (it.hasNext()) {
			Sale sale = it.next();
			LocalDateTime saleDate = sale.getSaleDate();
			boolean isWithin = saleDate.isAfter(start) && saleDate.isBefore(end);
			if (isWithin) {
				filtered.add(sale);
			}
		}
		return filtered;
	}

	public String generateSupplyReport() {
		String report = "";
		Iterator<Product> it = catalog.values().iterator();
		while (it.hasNext()) {
			Inventory inventory = it.next().getInventory();
			report += inventory.toString();
		}
		return report;
	}

}
