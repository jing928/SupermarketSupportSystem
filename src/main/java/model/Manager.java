package model;

import java.text.SimpleDateFormat;
import java.util.*;

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

	public void offerBulkSale(ProductIventory product1, double bulkQuantity, double discount) {
		if (product1.getBulkQuantity() < bulkQuantity || discount <= 1 || discount >= 0)
			product1.setBulkDiscount(bulkQuantity, discount);
	}

	public void modifyPromotion(ProductIventory product1,double discount) {
		if (discount <= 0 || discount >= 1) {
			product1.setDiscount(discount);
		}
	  
	}

	public String viewSalesReport(Date startDate, Date endDate) {
		return "The Start Date is:" + salesReportDate.format(startDate) + "/nThe End Date is:"
				+ salesReportDate.format(endDate);
	}

	public String viewSupplyReport() {
		return "haha";
	}

	public String viewMostProfitableItem() {
		return "hehe";
	}

}
