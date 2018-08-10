# Supermarket Support System
__Group Project for ISYS1117 Software Engineering Fundamentals__

__By Gang of Four__
- [Jia Guo](https://github.com/carolJiaguo)
- [Deneng Liu](https://github.com/DenengLiu)
- [Jing Li](https://github.com/jing928)
- [Dili Wu](https://github.com/jamiewur)

## Description
A new self-checkout system is introduced in a supermarket, which only allows payments for sales to be made through the company debit card. Currently purchasing and topping up these cards are handled manually using a sales staff. The company has also introduced a scheme to promote loyalty; customers using the card get 1 point, for every $10 spent. Customers are automatically discounted $5 for every 20 points. The system should store the product, customer and employee related details allowing necessary reports to be generated. Data may be stored in relational database or flat files or through serialization. GUI is optional for this project.

### Current Limitations
A typical checkout terminal consists of a touch screen and a barcode reader but for this assignment all data will be entered through the keyboard (including the customer card number and product ID). Assume the customer is required to specify the customer number thus allowing customer details to be stored.

### Project Requirements
- A typical customer:
  1. I want the checkout system with a simple user interface, allowing me to specify ID and quantity or the product name and weight. I want to be able to select the product name from a given list.
  1. I want to be able check the price of any item by keying in the ID before proceeding with the sale.
  1. I want to check the discounts applicable when I purchase an item in bulk.

- The sales staff (Kim):
  1. I want to be able to login to the system the system and override the transaction details (removing item, cancellation) in case a customer has problems.

- The warehouse staff (Frank):
  1. I want to be able to replenish stock levels before placing items received on the shelves.
 
- The manager (Tim): I want a system that:
  1. Maintains unit-price, stock level, replenish-level and reorder quantity for all items.
  1. Maintains supplier details for all products.
  1. Allows me to override the standard price for a specific product when there is a
promotion.
  1. Allows me to offer special discounts for bulk sales (for example, 10% discount for 5
items, 20% discount for 10 items etc.) on specific products.
  1. Allows me to modify these percentages and item quantities through the interface.
  1. That automatically places a purchase order for all items below replenishment level.
  1. Allows me to generate sales report for the specified period.
  1. Generate supply report (Payments for supplies are out of scope).
  1. List products generating the most revenue.

### Bonus marks (one of the following)
1. Extend into web-based or client server applications allowing concurrent access. This extension will require the use of sockets and/or RMI and/or Servlets access.
1. Interface to an external barcode reader

### Possible Domain Classes
System, Sale, SalesLineItem, Product, Location, Customer, CreditCard, Employee, Manager, SalesStaff, Supplier

### Suggested Initial Test Cases for Milestone 1
1. Verify performing a sales reduces the stock level for all products in the sale.
1. Verify replenishing stock increases stock level by the specified amount.
1. Verify sale price is computed correctly based on sale line items.
1. Verify sale price is computed correctly for discounted items.
1. Verify sale price is computed correctly for items offering discounts for bulk sale.
1. Verify sale price is not affected for non-discounted items.
1. Verify the loyalty points are allocated correctly.
1. Verify maximum discounts are automatically given based on current loyalty points at the end of transaction.
1. Verify discounts are computed correctly when loyalty points are combined with bulk discount.
1. Verify discounts are computed correctly when loyalty points are combined with some promotional items.
