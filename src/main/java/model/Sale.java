package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exception.InvalidInputException;

public class Sale implements Serializable {

	private static final long serialVersionUID = -6489149075701776427L;

	private LocalDateTime saleDateTime;
	private Customer customer;
	private Map<String, SalesLineItem> lineItems;
	private double totalPrice;
	private double rewardsDiscount;

	public Sale(Customer customer, LocalDateTime saleDateTime) {
		this.customer = customer;
		this.saleDateTime = saleDateTime;
		this.lineItems = new HashMap<String, SalesLineItem>();
	}

	public Sale(Customer customer) {
		this(customer, LocalDateTime.now());
	}

	public void addLineItem(Product item, double quantity) throws InvalidInputException, StockLevelException {
		if (lineItems.containsKey(item.getName())) {
			// Update quantity if item already exists
			updateLineItem(item.getName(), quantity);
		} else {
			// Add new line item to the list
			String key = item.getName();
			SalesLineItem lineItem = new SalesLineItem(item, quantity);
			this.lineItems.put(key, lineItem);
		}
	}

	public void updateLineItem(String itemName, double addedQuantity) throws InvalidInputException {
		// Update quantity of existing line item. This method will increase the quantity
		// instead of resetting it.
		if (addedQuantity < 0) {
			throw new InvalidInputException("Quantity cannot be negative.");
		}
		SalesLineItem lineItem = this.lineItems.get(itemName);
		double oldQuantity = lineItem.getQuantity();
		double newQuantity = oldQuantity + addedQuantity;
		lineItem.setQuantity(newQuantity);
	}

	public double getTotalPrice() {
		if (this.totalPrice != 0.0) {
			return this.totalPrice;
		}
		this.totalPrice = this.calculateTotalPrice();
		double discount = this.getRewardsDiscount();
		return this.totalPrice - discount;
	}

	private double calculateTotalPrice() {
		double totalPrice = 0;
		Iterator<SalesLineItem> i = this.lineItems.values().iterator();
		while (i.hasNext()) {
			totalPrice += i.next().getSubTotalPrice();
		}
		return totalPrice;
	}

	private double getRewardsDiscount() {
		if (this.rewardsDiscount != 0.0) {
			return this.rewardsDiscount;
		}
		this.rewardsDiscount = customer.getRewardsInfo(getTotalPrice());
		return this.rewardsDiscount;
	}

	public void finalizeSale() {
		Iterator<SalesLineItem> i = this.lineItems.values().iterator();
		while (i.hasNext()) {
			SalesLineItem lineItem = i.next();
			Inventory item = lineItem.getItem().getInventory();
			item.sellProduct(lineItem.getQuantity());
		}
		customer.redeem(getRewardsDiscount());
		addPointsToCustomer();
	}

	public Map<String, SalesLineItem> getLineItems() {
		return this.lineItems;
	}

	public Customer getCustomer() {
		return this.customer;
	}

	public LocalDateTime getSaleDate() {
		return this.saleDateTime;
	}

	private void addPointsToCustomer() {
		double totalPrice = getTotalPrice();
		int pointEarned = (int) (totalPrice / 10); // 1 points every $10
		customer.earnPoints(pointEarned);
	}

	public Map<String, Double> listItemWithRevenue() {
		Map<String, Double> itemWithRevenue = new HashMap<String, Double>();
		Iterator<Map.Entry<String, SalesLineItem>> it = lineItems.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, SalesLineItem> entry = it.next();
			itemWithRevenue.put(entry.getKey(), entry.getValue().getSubTotalPrice());
		}
		return itemWithRevenue;
	}

	@Override
	public String toString() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String dateTime = saleDateTime.format(formatter);
		int numOfItemSold = lineItems.size();
		double price = getTotalPrice();
		return String.format("DateTime: %1$s | Number of Items Sold: %2$s | Total Price: $%3$.2f\n", dateTime,
				numOfItemSold, price);
	}

}
