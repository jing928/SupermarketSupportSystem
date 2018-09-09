package model;

import java.util.ArrayList;
import java.util.Date;

public class Sale {

	private Date saleDate;
	private Customer customer;
	private ArrayList<SalesLineItem> salesLineItems = new ArrayList<SalesLineItem>();

	public Sale(Customer customer, Date saleDate) {
		this.saleDate = saleDate;
		this.customer = customer;
	}

public ArrayList<SalesLineItem> getSalesLineItems(){
	return this.salesLineItems;
}

	public Customer getCustomer() {
		return this.customer;
	}

	public Date getSaleDate() {
		return this.saleDate;
	}

	public void addLineItem(Product item, double quantity) {
		SalesLineItem saleslineitem = new SalesLineItem(item.getName(), quantity, item.getUnitPrice(), item);
		salesLineItems.add(saleslineitem);
	}
}