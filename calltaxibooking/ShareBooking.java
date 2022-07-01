package calltaxibooking;

import java.util.HashMap;
import java.util.Map;

public class ShareBooking {
	private int bookingId;
	private int taxiNo;
	private char pickUpPoint;
	private char dropPoint;
	private  Map<Character,Double> avalaibleShare=new HashMap<>();
    private int availableSpace=3;
    
    
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getTaxiNo() {
		return taxiNo;
	}
	public void setTaxiNo(int taxiNo) {
		this.taxiNo = taxiNo;
	}
	public char getPickUpPoint() {
		return pickUpPoint;
	}
	public void setPickUpPoint(char pickUpPoint) {
		this.pickUpPoint = pickUpPoint;
	}
	public char getDropPoint() {
		return dropPoint;
	}
	public void setDropPoint(char dropPoint) {
		this.dropPoint = dropPoint;
	}
	public Map<Character, Double> getAvalaibleShare() {
		return avalaibleShare;
	}
	public void setAvalaibleShare(Map<Character, Double> avalaibleShare) {
		this.avalaibleShare = avalaibleShare;
	}
	public int getAvailableSpace() {
		return availableSpace;
	}
	public void setAvailableSpace(int availableSpace) {
		this.availableSpace = availableSpace;
	}
    
    
	
}
