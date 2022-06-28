package zkart;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZKart {
    FileLayer fl=new FileLayer();
	Map<String,Customer> customerInfo=new HashMap<>();
	Map<Integer,Product> productInfo=new HashMap<>();
	
	
	int productId=0;
	public void initialSetUp() {
		if(!fl.checkCustomerFile()) {
			customerInitialization();
		}
		if(!fl.checkProductFile()) {
		invetoryInitialization();
		}
		customerInfo=fl.readCustomer();
		productInfo=fl.readProduct();
	}
	public void invetoryInitialization() {
		Product zKart=new Product();
		
		zKart.setBrandName("Apple");
		zKart.setCategoryName("Mobile");
		zKart.setModelName("6S");
		zKart.setPriceOfProduct(60000);
		zKart.setStockOfProduct(10);
		zKart.setProductId(generateProductId());
		zKart.setDiscount(4);
		addZKart(zKart);
		Product zKart2=new Product();
		zKart2.setBrandName("HP");
		zKart2.setCategoryName("Laptop");
		zKart2.setModelName("G");
		zKart2.setPriceOfProduct(12000);
		zKart2.setStockOfProduct(5);
		zKart2.setProductId(generateProductId());
		zKart2.setDiscount(2);
		addZKart(zKart2);
	   
		
		
	}
	  public void customerInitialization() {
	    	Customer customer1=new Customer();
	    	customer1.setEmailId("abc@zoho.com");
	    	customer1.setMobileNumber(6385224645l);
	    	customer1.setName("Rahul");
	    	customer1.setEncryptedPassword("ApipNbjm");
	    	customer1.setCredits(20);
	    	addCustomer(customer1);
	    	
	    	Customer customer2=new Customer();
	    	customer2.setEmailId("123@zoho.com");
	    	customer2.setMobileNumber(6385224645l);
	    	customer2.setName("Anitha");
	    	customer2.setEncryptedPassword("ApipNbjm");
	    	customer2.setCredits(0);
	    	addCustomer(customer2);
	    	
	    	
	    }
	public int generateProductId() {
		return ++productId;
	}
	public void addCustomer(Customer cus) {
		customerInfo.put(cus.getEmailId(), cus);
		fl.writeCustomer(customerInfo);
	}
	public void addZKart(Product pro) {
		productInfo.put(pro.getProductId(), pro);
		fl.writeProduct(productInfo);
	}
	public boolean adminLoginCheck(String emailId,String pass) {
		if(emailId.equals("admin@zoho.com")&&pass.equals("xyzzy")) {
			return true;
		}
		return false;

	}
	public boolean loginCheck(String emailId,String pass) {
		if(!customerInfo.containsKey(emailId)) {
			return false;
		}
		String encrypt=encryptPass(pass);
		Customer cus=customerInfo.get(emailId);
		if(!encrypt.equals(cus.getEncryptedPassword())) {
			return false;
		}
		return true;
	}
	public Map<String,Customer> getCusInfo(){
		return customerInfo;
	}
	public String getZKart(){
		return fl.printItems();
	}
	public Product getProduct(int productId) {
		return productInfo.get(productId);
	}
	public boolean checkPasswordCritteria(String pass) {
		
		if(pass==null||pass.length()<=5) {
			return false;
		}
		int count1=0;
		int count2=0;
		int count3=0;
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)>='A'&&pass.charAt(i)<='Z') {
				count1++;
			}
			else if(pass.charAt(i)>='a'&&pass.charAt(i)<='z') {
				count2++;
				
			}
			else if(Character.isDigit(pass.charAt(i))){
				count3++;
			}
		}
	if(count1>=1&&count2>=1&&count3>=1) {
		return true;
	}
		return false;
	}
	public boolean checkPassword(String pas1,String pas2) {
		if(pas1.equals(pas2)) {
			return true;
		}
		return false;
	}

	public String encryptPass(String pass) {
		String ans="";
		for(int i=0;i<pass.length();i++) {
			if(pass.charAt(i)=='z') {
				ans+="a";
			}
			else if(pass.charAt(i)=='Z') {
				ans+="A";
			}
			else if(pass.charAt(i)=='9') {
				ans+="0";
			}
			else {
				ans+=(char)(pass.charAt(i)+1);
			}
		}
		return ans;
	}
	public boolean existCustomer(String emailId) {
		if(customerInfo.containsKey(emailId)) {
			return true;
		}
		return false;
	}
	public void checkOutCard(List<Integer> produts,List<Integer> noOfOrderedItems) {
		for(int i=0;i<produts.size();i++) {
			Product product=productInfo.get(produts.get(i));
			if(product.getStockOfProduct()>=noOfOrderedItems.get(i)) {
				product.setStockOfProduct(product.getStockOfProduct()-noOfOrderedItems.get(i));
			}
			else if(product.getStockOfProduct()>0) {
				
			    noOfOrderedItems.add(i,product.getStockOfProduct() );
			    product.setStockOfProduct(0);
			}
			else {
				produts.remove(i);
				noOfOrderedItems.remove(i);
			}
		}
		fl.writeProduct(productInfo);
		
	}
	private int invoiceNumber=1000;
	public void addOrderHistory(String emailId,List<Integer> produts,List<Integer> noOfOrderedItem,int usedCredits,int addedCredits) {
		Customer cus=customerInfo.get(emailId);
		Map<Integer,OrderHistory> orders=cus.getOrders();
		OrderHistory obj=new OrderHistory();
		obj.setInvoiceNumber(invoiceNumber);
		obj.setDate(System.currentTimeMillis());
		obj.setCreditsAdded(addedCredits);
		obj.setCreditsUsed(usedCredits);
		Map<Integer,Integer> map=obj.getSellProduct();
		for(int i=0;i<produts.size();i++) {
			map.put(produts.get(i),noOfOrderedItem.get(i));
		}
		orders.put(obj.getInvoiceNumber(), obj);
	}

	public int generateInvoice() {
		return ++invoiceNumber;
	}
	public List<Product> getLessNoOfStock(){
		List<Product> lessStock=new ArrayList<>();
		for(Integer key:productInfo.keySet()) {
			Product pro=productInfo.get(key);
			if(pro.getStockOfProduct()<10) {
				lessStock.add(pro);
			}
		}
		return lessStock;
	}
	
	public void addStock(Product product,int reOr) {
		
			product.setStockOfProduct(product.getStockOfProduct()+reOr);
			fl.writeProduct(productInfo);
		
	}
	public String convertDate(long tim) {
		SimpleDateFormat formatter=new SimpleDateFormat("dd-MM-yyyy");
		Date dateObj=new Date(tim);
		return formatter.format(dateObj);
	}
	
	public String getOrderHistory(String emailId) {
		Customer cus=customerInfo.get(emailId);
		String ans="";
		Map<Integer,OrderHistory> map=cus.getOrders();
		for(Integer key:map.keySet()) {
			OrderHistory orderHistory=map.get(key);
			ans+="Invoice Number-"+orderHistory.getInvoiceNumber()+"\n";
			ans+="Date "+convertDate(orderHistory.getDate())+"\n";
			ans+="Category\t\tBrand\t\tModel\t\tPrice\t\tNoofordereditems\n";
			int total=0;
			Map<Integer,Integer> map1=orderHistory.getSellProduct();
			for(Integer key3:map1.keySet()) {
                 Product pro=productInfo.get(key3);
                 ans+=pro.getCategoryName()+"\t\t\t"+pro.getBrandName()+"\t\t"+pro.getModelName()+"\t\t"+pro.getPriceOfProduct()+"\t\t"+map1.get(key3)+"\n";
                 total+=pro.getPriceOfProduct()*map1.get(key3);
			}
			ans+="Credits Used "+orderHistory.getCreditsUsed()+"\n";
			ans+="total "+(total-orderHistory.getCreditsUsed())+"\n";
			ans+="Credits added "+orderHistory.getCreditsAdded()+"\n";
			
		}
		return ans;
	}
	public boolean checkCredit(String emailId,int credit) {
		Customer customer=customerInfo.get(emailId);
		if(customer.getCredits()>=credit) {
			return true;
		}
		return false;
	}
	public int addCredit(String emailId,int amount) {
		int credit=amount/1000;
		credit=credit*20;
		Customer customer=customerInfo.get(emailId);
		customer.setCredits(customer.getCredits()+credit);
		fl.writeCustomer(customerInfo);
		return credit;
	}
	public void reduceCredit(String emailId,int amount) {
		Customer customer=customerInfo.get(emailId);
		customer.setCredits(customer.getCredits()-amount);
	}
	public String printItems() {
		return fl.printItems();
	}
	public String printItemsLessStock() {
		return fl.printItemsLessStock();
	}
    public void updateDiscount(int productId,int discount) {
    	Product product=productInfo.get(productId);
    	product.setDiscount(discount);
    	fl.writeProduct(productInfo);
    }
}