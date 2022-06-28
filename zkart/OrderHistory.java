package zkart;

import java.util.HashMap;

import java.util.Map;

public class OrderHistory {

	private int invoiceNumber;
	private long date;
	private Map<Integer,Integer> sellProduct=new HashMap<>();
	private int creditsUsed;
	private int creditsAdded;
	
	public int getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(int invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public long getDate() {
		return date;
	}
	public void setDate(long date) {
		this.date = date;
	}
	public Map<Integer, Integer> getSellProduct() {
		return sellProduct;
	}
	public void setSellProduct(Map<Integer, Integer> sellProduct) {
		this.sellProduct = sellProduct;
	}
	public int getCreditsUsed() {
		return creditsUsed;
	}
	public void setCreditsUsed(int creditsUsed) {
		this.creditsUsed = creditsUsed;
	}
	public int getCreditsAdded() {
		return creditsAdded;
	}
	public void setCreditsAdded(int creditsAdded) {
		this.creditsAdded = creditsAdded;
	}
	
	
	
}
