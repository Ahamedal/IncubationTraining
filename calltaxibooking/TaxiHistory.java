package calltaxibooking;

public class TaxiHistory {
	private int bookingId;
	private int customerId;
	private char pickUpPoint;
	private char dropPoint;
	private double pickUpTime;
	private double dropTime;
	private int bookingType;
	private int amount;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public double getPickUpTime() {
		return pickUpTime;
	}

	public void setPickUpTime(double pickUpTime) {
		this.pickUpTime = pickUpTime;
	}

	public double getDropTime() {
		return dropTime;
	}

	public void setDropTime(double dropTime) {
		this.dropTime = dropTime;
	}

	public int getBookingType() {
		return bookingType;
	}

	public void setBookingType(int bookingType) {
		this.bookingType = bookingType;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {

		return "[bookingId=" + bookingId + ", customerId=" + customerId + ", pickUpPoint=" + pickUpPoint
				+ ", dropPoint=" + dropPoint + ", pickUpTime=" + pickUpTime + ", amount=" + amount + "]";
	}

}