package org.wahlzeit.model;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoordinateTest {
	
	@Test(expected = NullPointerException.class)
	public void testGetDistanceThrowsNullPointerException() {
		Coordinate coord = new Coordinate();
		coord.getDistance(null);
	}

	@Test
	public void testGetDistanceIsZeroForEqualCoordinates() {
		Coordinate coord = new Coordinate(42,42);
		assertEquals(0, coord.getDistance(coord), 0.0f);
	}
	
	@Test
	public void testGetDistanceIsCorrect() {
		Coordinate coord1 = new Coordinate(51.8853, 0.2545);
		Coordinate coord2 = new Coordinate(58.3838, 3.0412);
		assertEquals(743800, coord1.getDistance(coord2), 1000);
	}
	
	@Test
	public void testGetLongitudeDistanceIsCorrect() {
		Coordinate coord1 = new Coordinate(51.8853, 0.2545);
		Coordinate coord2 = new Coordinate(58.3838, 3.0412);
		assertEquals(6,4985, coord2.getLatitudinalDistance(coord1));
	}
	
	@Test
	public void testGetLatitudeDistanceIsCorrect() {
		Coordinate coord1 = new Coordinate(51.8853, 0.2545);
		Coordinate coord2 = new Coordinate(58.3838, 3.0412);
		assertEquals(2,7867, coord2.getLatitudinalDistance(coord1));
	}
	
}
