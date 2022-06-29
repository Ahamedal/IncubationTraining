package calltaxibooking;

public class Taxi {
 
 private int taxiNo;
 private double amountEarned;
 private char currentPosition='A';
 private double freeTime=6.00;
 



public double getFreeTime() {
	return freeTime;
}
public void setFreeTime(double freeTime) {
	this.freeTime = freeTime;
}
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

 
 
}
