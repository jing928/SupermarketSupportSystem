package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

	public String listMostProfitableProducts(int topX) {
		String list = "**** Products That Generate the Most Revenue ****\n\nProduct Name        Total Revenue\n";
		Map<String, Double> sortedList = sortMapByValue(aggregateSalesPrices());
		int listSize = sortedList.size();
		topX = topX > listSize ? listSize : topX;
		Iterator<Map.Entry<String, Double>> it = sortedList.entrySet().iterator();

		for (int i = 0; i < topX; i++) {
			Map.Entry<String, Double> entry = it.next();
			String name = entry.getKey();
			double revenue = entry.getValue();
			String row = String.format("%1$s        $%2$.2f\n", name, revenue);
			list += row;
		}
		return list;
	}

	private Map<String, Double> aggregateSalesPrices() {
		Map<String, Double> aggregate = new HashMap<String, Double>();
		Iterator<Sale> it = sales.iterator();
		while (it.hasNext()) {
			Sale sale = it.next();
			Map<String, Double> itemPrice = sale.listItemWithRevenue();
			Iterator<Map.Entry<String, Double>> i = itemPrice.entrySet().iterator();
			while (i.hasNext()) {
				Map.Entry<String, Double> entry = i.next();
				String itemName = entry.getKey();
				double subTotal = entry.getValue();
				if (aggregate.containsKey(itemName)) {
					double currentTotal = aggregate.get(itemName);
					double newTotal = currentTotal + subTotal;
					aggregate.put(itemName, newTotal);
				} else {
					aggregate.put(itemName, subTotal);
				}
			}
		}
		return aggregate;
	}

	private Map<String, Double> sortMapByValue(Map<String, Double> unsorted) {
		return unsorted.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
	}

}
