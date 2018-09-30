package model;

import java.io.Serializable;

public class Location implements Serializable {
	
	private static final long serialVersionUID = 4244601785233049696L;
	
	private String streetNum;
	private String streetName;
	private String unitNum;
	private String suburb;
	private String zipCode;

	public Location(String streetNum, String streetName, String unitNum, String suburb, String zipCode) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.unitNum = unitNum;
		this.suburb = suburb;
		this.zipCode = zipCode;
	}

	String getFullAddress() {
		return String.format("%1$s/%2$s %3$s, %4$s %5$s", unitNum, streetNum, streetName, suburb, zipCode);
	}

	public String getStreetNum() {
		return streetNum;
	}

	public void setStreetNum(String streetNum) {
		this.streetNum = streetNum;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getUnitNum() {
		return unitNum;
	}

	public void setUnitNum(String unitNum) {
		this.unitNum = unitNum;
	}

	public String getSuburb() {
		return suburb;
	}

	public void setSuburb(String suburb) {
		this.suburb = suburb;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

}
