package calltaxibooking;

public class Taxi {
 
 private int taxiNo;
 private double amountEarned;
 private char currentPosition='A';
 private boolean isAvailable=true;
public int getTaxiNo() {
	return taxiNo;
}
public void setTaxiNo(int taxiNo) {
	this.taxiNo = taxiNo;
}
public double getAmountEarned() {
	return amountEarned;
}
public void setAmountEarned(double amountEarned) {
	this.amountEarned = amountEarned;
}
public char getCurrentPosition() {
	return currentPosition;
}
public void setCurrentPosition(char currentPosition) {
	this.currentPosition = currentPosition;
}
public boolean isAvailable() {
	return isAvailable;
}
public void setAvailable(boolean isAvailable) {
	this.isAvailable = isAvailable;
}
 
 
}
