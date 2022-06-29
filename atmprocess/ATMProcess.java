package atmprocess;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ATMProcess {

     ATM atm=ATM.ATMOBJECT;
     FileLayer fl=new FileLayer();
     int transactionNumber=1000;
     Map<Integer,Customer> customers=new HashMap<>();
     Map<Integer,List<Transaction>> transactions=new HashMap<>();
     
     public void initialSetUp() {
    	if(fl.checkFileExist()) {
    		setCustomerInput();
    	}
    	 atm=fl.readFile();
    	 customers=fl.readCustomers();
    	 transactionNumber=fl.readTransactionNumber();
    	 transactions=fl.readTransaction(customers);
    	 
     }
     public int generateTransactionNumber() {
    	 return ++transactionNumber;
     }
     public boolean validateCustomer(int accNo,int pinNo) throws Exception	{
    	 checkAccountNumber(accNo);
    	Customer customer= customers.get(accNo);
    	
    	if(customer.getPinNumber()==pinNo)	{
    		return true;
    	}
        
    	return false;
     }
     public void feedMoneyToATM(int noOf2000,int noOf500,int noOf100) {
    	 atm.setNoOf2000(noOf2000);
    	 atm.setNoOf500(noOf500);
    	 atm.setNoOf100(noOf100);
    	 double total=(atm.getNoOf2000()*2000)+(atm.getNoOf500()*500)+(atm.getNoOf100()*100);
    	 atm.setTotalAmount(total);
    	 fl.createAndWriteFile(atm);
     }
    
     public double getBalance(int accNumber) {
    	 
    	Customer customer= customers.get(accNumber);
    	return customer.getBalance();
     }
     public boolean checkATMBalance(int amount) {
    	 if(amount<=atm.getTotalAmount()) {
    		 return true;
    	 }
    	 return false;
     }
     public boolean checkWithDrawalAmount(int accNumber,int amount) {
    	 Customer customer=customers.get(accNumber);
    	 if(customer.getBalance()>=amount) {
    		 return true;
    	 }
    	 return false;
     }
     public boolean denominationCheck(int noOf2000,int noOf500,int noOf100) {
    	 if(atm.getNoOf2000()<noOf2000) {
    		 return false;
    	 }
    	if(atm.getNoOf500()<noOf500) {
    		 return false;
    	 }
    	if(atm.getNoOf100()<noOf100) {
    		return false;
    	}
    	return true;
    	 
     }
     public String withdrawAmountValidation(int accNo,int amount)  throws Exception{
    	 if((amount%100)==0) {
				if(amount<=10000&&amount>=100)	{
					if(checkATMBalance(amount)) {
						if(checkWithDrawalAmount(accNo,amount)) {
							if(amount<=5000) {
								if(denominationForLessThan5000(amount)) {
									reduceAmountToCustomer(accNo,amount);
									return "Withdrawal successfully";
									
								}
								else {
								throw new Exception("Denominations is not available stop the transaction");
								}
								
							}
							else {
								if(denominationForGreaterThan5000(amount)) {
									reduceAmountToCustomer(accNo,amount);
									return "WithDrawal Successfully";
								}
								else {
									
								}
							
							}
						}
						else {
							throw new Exception("Your withdrawal amount to out of range");
						}
						
					}
					else {
						throw new Exception("ATM does not sufficient money to withdrawal amount");
					}
				}
				else {
				  throw new Exception("Please enter amount 100-10000(Maximum withdrawal limit is 10000 and minimum withdrawal limit is100");
				}
				}
				else {
					throw new Exception("Your Withdrawal amount not valid(only avaliable 2000,500 and 100 currency)");
				}
			

		return "";
     }
     public String transferMoney(int accNo,int tAccNo,int amount)throws Exception {
    	 if(checkWithDrawalAmount(accNo,amount)) {
    		 Customer customer1=customers.get(accNo);
    		 Customer customer2=customers.get(tAccNo);
    		 customer1.setBalance(customer1.getBalance()-amount);
    		 customer2.setBalance(customer2.getBalance()+amount);
    		 addTransactionHistory(accNo,tAccNo,amount);
    		 fl.writeCustomers(customers);
    		 return "Transaction Successfully";
    	 }
    	 else {
    		throw new Exception("Your transfer amount is out of range") ;
    	 }
    	 
     }
     public void addTransaction(int accNo,Transaction transaction) {
    	
    	 List<Transaction> li=transactions.get(accNo);
    	 if(li==null) {
    		 li=new ArrayList<>();
    		 transactions.put(accNo, li);
    	 }
    	 li.add(transaction);
    	 fl.writeTransaction(transactions, accNo);
    	 fl.storeTransactionNumber(transactionNumber);
    	 
     }
     public void addTransactionHistory(int accNo,int amount) {
    	Customer customer=customers.get(accNo);
    	Transaction transaction=new Transaction();
    	transaction.setAmount(amount);
    	transaction.setClosingBalance(customer.getBalance());
    	transaction.setDescription("Cash Withdrawal");
    	transaction.setTransactionNumber(generateTransactionNumber());
    	transaction.setTransactionType("Debit");
    	addTransaction(accNo, transaction);
     }
     public void addTransactionHistory(int accNo,int tAccNo,int amount) {
    	 Customer customer1=customers.get(accNo);
    	 Customer customer2=customers.get(tAccNo);
    	 Transaction transaction=new Transaction();
    	 transaction.setAmount(amount);
    	 transaction.setClosingBalance(customer1.getBalance());
    	 transaction.setDescription("Transfer to "+tAccNo);
    	 transaction.setTransactionNumber(generateTransactionNumber());
    	 transaction.setTransactionType("Debit");
    	 addTransaction(accNo,transaction);
    	 
    	 Transaction transaction1=new Transaction();
    	 transaction1.setAmount(amount);
    	 transaction1.setClosingBalance(customer2.getBalance());
    	 transaction1.setDescription("Transfer from "+accNo);
    	 transaction1.setTransactionNumber(generateTransactionNumber());
    	 transaction1.setTransactionType("Credit");
    	 addTransaction(tAccNo,transaction1);
    	 
    	 
     }
     public boolean denominationForGreaterThan5000(int amount) {
    	 int noOf2000=0;
    	 int noOf500=0;
    	 int noOf100=0;
    	
    	 for(int i=0;i<2;i++) {
    		 amount=amount-2000;
    		 
    		 noOf2000++;
    		 
    	 }
    	 while(amount>=500) {
    		 amount=amount-500;
    		 noOf500++;
    	 }
    	 while(amount!=0) {
    		 noOf100++;
    		 amount=amount-100;
    	 }
    	if(denominationCheck(noOf2000,noOf500,noOf100)) {
    		reduceATMAmount(noOf2000,noOf500,noOf100);
    		
    		return true;
    	}
    	return false;
    	
     }
     public void reduceAmountToCustomer(int accNo,int amount) {
    	 Customer customer=customers.get(accNo);
    	 customer.setBalance(customer.getBalance()-amount);
    	 addTransactionHistory(accNo,amount);
    	 fl.writeCustomers(customers);
     }
     public void reduceATMAmount(int noOf2000,int noOf500,int noOf100) {
    	feedMoneyToATM(-noOf2000,-noOf500,-noOf100);
     }
     public boolean denominationForLessThan5000(int amount) {
    	 int noOf2000=0;
    	 int noOf500=0;
    	 int noOf100=0;
    	 
    		 
    		if(amount>3000) {
    			noOf2000++;
    			amount=amount-2000;
    			
    		
    		while(amount>=500) {
    			noOf500++;
    			amount=amount-500;
    		}
    		while(amount!=0) {
    			noOf100++;
    			amount=amount-100;
    		}
    		 
    		}
    		else {
    			if(amount>=1000) {
    				noOf500++;
    				amount=amount-500;
    			}
    			if(amount>1500) {
    			for(int i=0;i<10;i++) {
    				noOf100++;
    				amount=amount-100;
    			}
    			}
    			while(amount>=500) {
    				noOf500++;
    				amount=amount-500;
    			}
    			while(amount!=0) {
        			noOf100++;
        			amount=amount-100;
        		}
    		}
    	 
    		if(denominationCheck(noOf2000,noOf500,noOf100)) {
    			reduceATMAmount(noOf2000,noOf500,noOf100);
        		return true;
        	}
        	return false;
    	
    	 
    	 
     }
     public String showATMBalance() {
    	return fl.showATMBalance();
     }
     public void setCustomerInput() {
    	 Customer customer1=new Customer();
    	 customer1.setAccNo(101);
    	 customer1.setAccHolder("Suresh");
    	 customer1.setPinNumber(2343);
    	 customer1.setBalance(25234);
    	 customers.put(customer1.getAccNo(), customer1);
    	 
    	 Customer customer2=new Customer();
    	 customer2.setAccNo(102);
    	 customer2.setAccHolder("Ganesh");
    	 customer2.setPinNumber(5432);
    	 customer2.setBalance(34123);
    	 customers.put(customer2.getAccNo(), customer2);
    	 fl.writeCustomers(customers);
    	 
     }
     public void showMap() {
    	 System.out.println(customers);
     }
     public String showCustomerDetails() {
    	return fl.showCustomerDetails();
     }
     public List<String> showTransactionDetails(int accNo) {
    	 return fl.showTransactionDetails(accNo);
     }
     private void checkAccountNumber(int accNo) throws Exception {
    	 if(customers.get(accNo)==null) {
    		 throw new Exception("Account Number is wrong");
    	 }
     }
     }
