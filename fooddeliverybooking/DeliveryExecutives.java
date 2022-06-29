package fooddeliverybooking;

public class DeliveryExecutives {
	private String executiveName;
	private char lastDeliveryLocation;
	private int allowance;
	private int deliveryCharge;
	private int total;
	private double freeTime=6.00;
	
	
	public char getLastDeliveryLocation() {
		return lastDeliveryLocation;
	}
	public void setLastDeliveryLocation(char lastDeliveryLocation) {
		this.lastDeliveryLocation = lastDeliveryLocation;
	}
	public String getExecutiveName() {
		return executiveName;
	}
	public void setExecutiveName(String executiveName) {
		this.executiveName = executiveName;
	}
	public int getAllowance() {
		return allowance;
	}
	public void setAllowance(int allowance) {
		this.allowance = allowance;
	}
	public int getDeliveryCharge() {
		return deliveryCharge;
	}
	public void setDeliveryCharge(int deliveryCharge) {
		this.deliveryCharge = deliveryCharge;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public double getFreeTime() {
		return freeTime;
	}
	public void setFreeTime(double freeTime) {
		this.freeTime = freeTime;
	}
	
	
}
