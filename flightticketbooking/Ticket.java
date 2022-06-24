package flightticketbooking;

import java.util.HashMap;

import java.util.Map;

public class Ticket {

	private int flightNumber;
	private int bookingId;
	private String seatClass;
	private boolean meal;
	private Map<String,Passenger> passengers=new HashMap<>();
	private double totalAmount;
	
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	
	public boolean isMeal() {
		return meal;
	}
	public void setMeal(boolean meal) {
		this.meal = meal;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
    
	public String getSeatClass() {
		return seatClass;
	}
	public void setSeatClass(String seatClass) {
		this.seatClass = seatClass;
	}
	public Map<String, Passenger> getPassengers() {
		return passengers;
	}
	public void setPassengers(Passenger passengerss) {
		String seatNo=passengerss.getSeatNumber();
		passengers.put(seatNo,passengerss);
	}
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount += totalAmount;
	}
	
	
}
