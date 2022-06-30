package fooddeliverybooking;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	private int customerId;
	private List<Integer> bookingIds=new ArrayList<>();
	private char orderRestaurant;
	private char destination;
	private char time;
	
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	
	public List<Integer> getBookingIds() {
		return bookingIds;
	}
	public void setBookingIds(List<Integer> bookingIds) {
		this.bookingIds = bookingIds;
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
