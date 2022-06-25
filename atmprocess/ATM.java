package atmprocess;

enum ATM {
     
    ATMOBJECT;
	
	private int noOf2000;
	private int noOf500;
	private int noOf100;
	private double totalAmount;
	
	public double getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}
	public int getNoOf2000() {
		return noOf2000;
	}
	public void setNoOf2000(int noOf2000) {
		this.noOf2000 += noOf2000;
	}
	public int getNoOf500() {
		return noOf500;
	}
	public void setNoOf500(int noOf500) {
		this.noOf500 += noOf500;
	}
	public int getNoOf100() {
		return noOf100;
	}
	public void setNoOf100(int noOf100) {
		this.noOf100 += noOf100;
	}
	
	
	
	
	
}
