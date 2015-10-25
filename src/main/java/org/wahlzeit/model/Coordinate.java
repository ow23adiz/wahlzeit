package org.wahlzeit.model;
import org.wahlzeit.services.*;


public class Coordinate extends DataObject {
	private double longitude;
	private double latitude;
	
	private static final int R = 6371000;
	
	public double getLongitude() { return longitude; }
	public double getLatitude() { return latitude; }
	public void setLongitude(double val) { longitude=val; writeCount++; }
	public void setLatitude(double val) { latitude = val; writeCount++; }
	
	public Coordinate(double latitude, double longitude) {
		this.longitude = longitude;
		this.latitude = latitude;
		writeCount++;
	}
	
	public Coordinate() {}
	
	private double toRadians(double val) {
		return val*Math.PI/180;
	}
	
	public double getDistance(Coordinate coord) {
		
		// Implemented as described in 
		// http://www.movable-type.co.uk/scripts/latlong.html
		double phi1 = toRadians(latitude);
		double phi2 = toRadians(coord.getLatitude());
		double deltaPhi = toRadians(coord.getLatitude()-latitude);
		double deltaLambda = toRadians(coord.getLongitude()-longitude);
		
		double a = Math.sin(deltaPhi/2)*Math.sin(deltaPhi/2) +
				Math.cos(phi1)*Math.cos(phi2)*
				Math.sin(deltaLambda/2)*Math.sin(deltaLambda/2);
		double c = 2*Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		double d = R*c;
		return d;
	}
	
	
	public double getLatitudinalDistance(Coordinate coord) {
		return latitude-coord.getLatitude();
	}
	
	public double getLongitudinalDistance(Coordinate coord) {
		return longitude-coord.getLongitude();
	}
	
}
