package model;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

	private Location location;
	private final String streetNum = "203";
	private final String streetName = "College Road";
	private final String unitNum = "13";
	private final String suburb = "Princeton";
	private final String zipCode = "08540";

	@BeforeEach
	public void setUp() throws Exception {
		location = new Location(streetNum, streetName, unitNum, suburb, zipCode);
	}

	@Test
	public void testGetFullAddress() {
		assertEquals("13/203 College Road, Princeton 08540", location.getFullAddress());
	}

	@Test
	public void testGetStreetNum() {
		assertEquals(streetNum, location.getStreetNum());
	}

	@Test
	public void testSetStreetNum() {
		location.setStreetNum("333");
		assertEquals("333", location.getStreetNum());
	}

	@Test
	public void testGetStreetName() {
		assertEquals(streetName, location.getStreetName());
	}

	@Test
	public void testSetStreetName() {
		location.setStreetName("New Street");
		assertEquals("New Street", location.getStreetName());
	}

	@Test
	public void testGetUnitNum() {
		assertEquals(unitNum, location.getUnitNum());
	}

	@Test
	public void testSetUnitNum() {
		location.setUnitNum("222");
		assertEquals("222", location.getUnitNum());
	}

	@Test
	public void testGetSuburb() {
		assertEquals(suburb, location.getSuburb());
	}

	@Test
	public void testSetSuburb() {
		location.setSuburb("sub");
		assertEquals("sub", location.getSuburb());
	}

	@Test
	public void testGetZipCode() {
		assertEquals(zipCode, location.getZipCode());
	}

	@Test
	public void testSetZipCode() {
		location.setZipCode("000111");
		assertEquals("000111", location.getZipCode());
	}

}
