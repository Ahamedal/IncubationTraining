package flightticketbooking;
import java.util.Map;
import java.util.HashMap;
public class Flight {
	
	private String flightName;
	private int flightNumber;
	private Map<String,String> businessClassTicket=new HashMap<>();     //key=seat name   value=seat typ(like W,A)
	private Map<String,String> economyClassTicket=new HashMap<>();      
	private double surgePrice;
	private double businessTicketPrice;
	private double economyTicketPrice;
	private String source;
	private String destination;
	private boolean businessClassAlone=false;
	private int mealPrice=200;
	
	public String getFlightName() {
		return flightName;
	}
	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}
	public int getFlightNumber() {
		return flightNumber;
	}
	public void setFlightNumber(int flightNumber) {
		this.flightNumber = flightNumber;
	}
	public Map<String, String> getBusinessClassTicket() {
		return businessClassTicket;
	}
	public void setBusinessClassTicket(Map<String, String> businessClassTicket) {
		this.businessClassTicket = businessClassTicket;
	}
	public Map<String, String> getEconomyClassTicket() {
		return economyClassTicket;
	}
	public void setEconomyClassTicket(Map<String, String> economyClassTicket) {
		this.economyClassTicket = economyClassTicket;
	}
	public double getSurgePrice() {
		return surgePrice;
	}
	public void setSurgePrice(double surgePrice) {
		this.surgePrice = surgePrice;
	}
	public double getBusinessTicketPrice() {
		return businessTicketPrice;
	}
	public void setBusinessTicketPrice(double businessTicketPrice) {
		this.businessTicketPrice = businessTicketPrice;
	}
	public double getEconomyTicketPrice() {
		return economyTicketPrice;
	}
	public void setEconomyTicketPrice(double economyTicketPrice) {
		this.economyTicketPrice = economyTicketPrice;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public int getMealPrice() {
		return mealPrice;
	}
	public void setMealPrice(int mealPrice) {
		this.mealPrice = mealPrice;
	}
	@Override
	public String toString() {
		return "Flight [flightName=" + flightName + ", flightNumber=" + flightNumber + ", businessTicketPrice="
				+ businessTicketPrice + ", economyTicketPrice=" + economyTicketPrice + ", mealPrice=" + mealPrice + "]";
	}
	
	
	

}
