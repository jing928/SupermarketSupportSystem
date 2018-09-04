package model;
import java.util.ArrayList;

public class Supplier {
private String supplierId;
private String supplierName;
private ArrayList<Location> supplierLocations;//
private ArrayList<Product> supplierProducts;//
private ArrayList<String> supplierPhoneNumber;// 

public Supplier() {
	
}
public Supplier(String supplierId,String supplierName) {
	this.supplierId=supplierId;
	this.supplierName=supplierName;
	supplierLocations= new ArrayList<Location>();
	supplierProducts= new ArrayList<Product>();
	supplierPhoneNumber= new ArrayList<String>();
}

public ArrayList<Location> getSupplierLOcation(){
	return supplierLocations;
}
public ArrayList<Product> getSupplierProducts(){
	return supplierProducts;
}
public ArrayList<String> getSupplierPhoneNumber(){
	return supplierPhoneNumber;
}

public String getSupplierId() {
	return supplierId;
}
public void setSupplierId(String supplierId) {
	this.supplierId=supplierId;
}

public String getSupplierName() {
	return supplierName;
}
public void setSupplierName(String supplierName) {
	this.supplierName=supplierName;
}



}
