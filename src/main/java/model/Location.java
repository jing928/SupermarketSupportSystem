package model;

public class Location {
	private String streetNum;
	private String streetName;
	private String unitNum;
	private String suburb;
	private String zipCode;
	private String state;
	private String country;

	public Location() {

	}

	public Location(String streetNum, String streetName, String unitNum, String suburb, String zipCode, String state,
			String country) {
		this.streetNum = streetNum;
		this.streetName = streetName;
		this.unitNum = unitNum;
		this.suburb = suburb;
		this.zipCode = zipCode;
		this.state = state;
		this.country = country;
	}

	String getFullAddress() {
		return streetNum + " " + streetName + " " + unitNum + " " + suburb + " " + state + " " + zipCode + " "
				+ country;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
