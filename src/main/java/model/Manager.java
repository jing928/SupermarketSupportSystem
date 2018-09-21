package model;

import java.text.SimpleDateFormat;
import java.util.*;

import exception.InvalidInputException;

public class Manager extends Employee {

	private SimpleDateFormat salesReportDate = new SimpleDateFormat("MM-DD-YYYY");

	public Manager(String emId, String name, char emGender) {
		super(emId, name, emGender);
	}

	public boolean overridePrice(Product product, double price) {
		if (price < 0) {
			return false;
		}
		product.setUnitPrice(price);
		return true;
	}

	public void offerBulkSale(ProductInventory product1, double bulkQuantity, double discount)
			throws InvalidInputException {
		if (product1.getBulkQuantity() < bulkQuantity || discount <= 1 || discount >= 0)
			product1.setDiscount(discount);
	}

	public void modifyPromotion(ProductInventory product1, double discount) throws InvalidInputException {
		if (discount <= 0 || discount >= 1) {
			product1.setDiscount(discount);
		}

	}

	// TODO
	public String viewSalesReport(Date startDate, Date endDate) {
		return "The Start Date is:" + salesReportDate.format(startDate) + "/nThe End Date is:"
				+ salesReportDate.format(endDate);
	}

	// TODO
	public String viewSupplyReport() {
		return "haha";
	}

	// TODO
	public String viewMostProfitableItem() {
		return "hehe";
	}

}
