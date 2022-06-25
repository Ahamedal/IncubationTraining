package calltaxibooking;

import java.util.Date;

public class TaxiHistory {
 private int bookingId;
 private int customerId;
 private char pickUpPoint;
 private char dropPoint;
 private long pickUpTime;
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
public long getPickUpTime() {
	return pickUpTime;
}
public void setPickUpTime(long pickUpTime) {
	this.pickUpTime = pickUpTime;
}

public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
@Override
public String toString() {
	Date da=new Date(pickUpTime);
	return "[bookingId=" + bookingId + ", customerId=" + customerId + ", pickUpPoint=" + pickUpPoint
			+ ", dropPoint=" + dropPoint + ", pickUpTime=" + da + ", amount=" +amount+"]";
}
 
 
}