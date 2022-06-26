package zkart;

public class Coupen {

	private String coupenCode;
	private int nextTransaction;
	private boolean valid=true;
	public String getCoupenCode() {
		return coupenCode;
	}
	public void setCoupenCode(String coupenCode) {
		this.coupenCode = coupenCode;
	}
	public int getNextTransaction() {
		return nextTransaction;
	}
	public void setNextTransaction(int nextTransaction) {
		this.nextTransaction = nextTransaction;
	}
	public boolean isValid() {
		return valid;
	}
	public void setValid(boolean valid) {
		this.valid = valid;
	}
	
}
