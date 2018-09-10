package model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LocationTest {

	private Location location;
	private final String streetNum = "203";
	private final String streetName = "College Road";
	private final String unitNum = "Block 13";
	private final String suburb = "Princeton";
	private final String zipCode = "08540";
	private final String state = "New Jerse";
	private final String country = "USA";

	@BeforeEach
	public void setUp() throws Exception {
		location = new Location(streetNum, streetName, unitNum, suburb, zipCode, state, country);
	}

	@Test
	public void testGetFullAddress() {
		assertEquals("203 College Road Block 13 Princeton New Jerse 08540 USA", location.getFullAddress());
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

	@Test
	public void testGetState() {
		assertEquals(state, location.getState());
	}

	@Test
	public void testSetState() {
		location.setState("New State");
		assertEquals("New State", location.getState());
	}

	@Test
	public void testGetCountry() {
		assertEquals(country, location.getCountry());
	}

	@Test
	public void testSetCountry() {
		location.setCountry("China");
		assertEquals("China", location.getCountry());
	}

}
