package fooddeliverybooking;

public class DeliveryHistory {

	private int trip;
	private String executiveName;
	private char restaurantName;
	private char destinationPoint;
	private int orders;
	private double pickUpTime;
	private double deliveryTime;
	private int deliveryCharge;
	
	

	public int getTrip() {
		return trip;
	}
	public void setTrip(int trip) {
		this.trip = trip;
	}
	public String getExecutiveName() {
		return executiveName;
	}
	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}
	public char getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(char restaurantName) {
		this.restaurantName = restaurantName;
	}
	public char getDestinationPoint() {
		return destinationPoint;
	}
	public void setDestinationPoint(char destinationPoint) {
		this.destinationPoint = destinationPoint;
	}
	public int getOrders() {
		return orders;
	}
	public void setOrders(int orders) {
		this.orders = orders;
	}
	public double getPickUpTime() {
		return pickUpTime;
	}
	public void setPickUpTime(double pickUpTime) {
		this.pickUpTime = pickUpTime;
	}
	public double getDeliveryTime() {
		return deliveryTime;
	}
	public void setDeliveryTime(double deliveryTime) {
		this.deliveryTime = deliveryTime;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	
	
}
