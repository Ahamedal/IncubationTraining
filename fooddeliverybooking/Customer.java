package fooddeliverybooking;

public class Customer {

	private int customerId;
	private int bookingId;
	private char orderRestaurant;
	private char destination;
	private char time;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public char getOrderRestaurant() {
		return orderRestaurant;
	}
	public void setOrderRestaurant(char orderRestaurant) {
		this.orderRestaurant = orderRestaurant;
	}
	public char getDestination() {
		return destination;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}
	public char getTime() {
		return time;
	}
	public void setTime(char time) {
		this.time = time;
	}
	
	
	
}
