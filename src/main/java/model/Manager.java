package model;

import java.text.SimpleDateFormat;
import java.util.*;

public class Manager extends Employee {
private SimpleDateFormat salesReportDate=new SimpleDateFormat("MM-DD-YYYY");

public Manager() {
	super();
}

public boolean overridePrice(Product product, double price) {
	return false;
}

public boolean modifyPromotion(Product product, double bulkQuantity,double discount) {
	return false;
}

public String viewSalesReport(Date startDate, Date endDate) {
	return "The Start Date is:"+ salesReportDate.format(startDate)+"/nThe End Date is:"+salesReportDate.format(endDate);
}

public String viewSupplyReport() {
	return "haha";
}
public String viewMostProfitableItem() {
	return "hehe";
}

}
