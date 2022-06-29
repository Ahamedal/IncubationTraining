package atmprocess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileLayer {
  File file=new File("ATM.txt");
  File file1=new File("Customers.txt");
  public boolean checkFileExist() {
	  if(file1.exists()) {
		  return false;
	  }
	  return true;
	  
  }
	public void createAndWriteFile(ATM atm) {
		try(FileWriter fw=new FileWriter(file);) {
			fw.write("Denomination\t\t\tNumber\t\t\t\tValue\n");
			fw.write("2000\t\t\t\t"+atm.getNoOf2000()+"\t\t\t\t"+(2000*atm.getNoOf2000())+"\n");
			fw.write("500\t\t\t\t"+atm.getNoOf500()+ "\t\t\t\t"+(500*atm.getNoOf500())+"\n");
			fw.write("100\t\t\t\t"+atm.getNoOf100()+ "\t\t\t\t"+(100*atm.getNoOf100())+"\n\n");
			fw.write("Total amount available in ATM = "+atm.getTotalAmount());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public ATM readFile() 
	{
		ATM atm=ATM.ATMOBJECT;
		if(file.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(file))){
		int i=0;
		double amount=0;
			bf.readLine();
			String st="";
			while((st=bf.readLine())!=null) {
				String[] ar=st.split("\t\t\t\t");
				if(i==0) {
					atm.setNoOf2000(Integer.parseInt(ar[1]));
					amount+=(2000*atm.getNoOf2000());
				}
				else if(i==1) {
					atm.setNoOf500(Integer.parseInt(ar[1]));
					amount+=(500*atm.getNoOf500());
				}
				else if(i==2) {
					atm.setNoOf100(Integer.parseInt(ar[1]));
					amount+=(100*atm.getNoOf100());
				}
				i++;
				
			}
			atm.setTotalAmount(amount);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return atm;
	}
	public void writeCustomers(Map<Integer,Customer> customers) {
		
		try(FileWriter fw=new FileWriter(file1)){
			fw.write("AccNo\t\t\t\tAccountHolder\t\t\tPinNumber\t\t\tAccountBalance\n");
			Set<Integer> set=customers.keySet();
			for(Integer accNo:set) {
				Customer customer=customers.get(accNo);
			    fw.write(customer.getAccNo()+"\t\t\t\t"+customer.getAccHolder()+"\t\t\t\t"+customer.getPinNumber()+"\t\t\t\t"+customer.getBalance()+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Map<Integer,Customer> readCustomers(){
		Map<Integer,Customer> customers=new HashMap<>();
		if(file1.exists()) {
			try(BufferedReader bf=new BufferedReader(new FileReader(file1))){
				bf.readLine();
				String string="";
				while((string=bf.readLine())!=null) {
					String[] ar=string.split("\t\t\t\t");
					Customer customer=new Customer();
					customer.setAccNo(Integer.parseInt(ar[0]));
					customer.setAccHolder(ar[1]);
					customer.setPinNumber(Integer.parseInt(ar[2]));
					customer.setBalance(Double.parseDouble(ar[3]));
					customers.put(customer.getAccNo(), customer);
				}
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return customers;
	}
	
public void writeTransaction(Map<Integer,List<Transaction>> transactions,int accountNo) {
		
		try(FileWriter fw=new FileWriter(accountNo+"_transaction.txt")){
			List<Transaction> li=transactions.get(accountNo);
			
			fw.write("Transaction Number\t\tDescription\t\t\tCredit/Debit\t\tAmount\t\t\tClosingBalance\n");
			for(int i=0;i<li.size();i++) {
				Transaction transaction=li.get(i);
				fw.write(transaction.getTransactionNumber()+"\t\t\t"+transaction.getDescription()+"\t\t\t"+transaction.getTransactionType()+"\t\t\t"+transaction.getAmount()+"\t\t\t"+transaction.getClosingBalance()+"\n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
public Map<Integer,List<Transaction>> readTransaction(Map<Integer,Customer> customers){
	Map<Integer,List<Transaction>> transactions=new HashMap<>();
	    Set<Integer> set=customers.keySet();
	    for(int accNo:set) {
	    	File file=new File(accNo+"_transaction.txt");
	    	if(file.exists()) {
	    		try(BufferedReader bf=new BufferedReader(new FileReader(file))) {
	    			bf.readLine();
	    			String st="";
	    			while((st=bf.readLine())!=null) {
	    				String[] ar=st.split("\t\t\t");
	    				Transaction transaction=new Transaction();
	    				transaction.setTransactionNumber(Integer.parseInt(ar[0]));
	    				transaction.setDescription(ar[1]);
	    				transaction.setTransactionType(ar[2]);
	    				transaction.setAmount(Double.parseDouble(ar[3]));
	    				transaction.setClosingBalance(Double.parseDouble(ar[4]));
	    				addTransaction(accNo,transaction,transactions);
	    			}
	    		}  catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	    	}
	    }
	    return transactions;
}
	public void storeTransactionNumber(int transactionNumber) {
		try(FileWriter fw=new FileWriter("transaction.txt")){

			fw.write(transactionNumber+"\t\t"+"\n");
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public int readTransactionNumber() {
		int transactionId=1000;
			File accFile=new File("transaction.txt");
		if(accFile.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(accFile))){
			String st=bf.readLine();
			String[] array=st.split("\t\t");
			transactionId=Integer.parseInt(array[0]);
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		
		return transactionId;
	}
	
	public String showATMBalance() {
		String string="";
		if(file.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(file))){
		  String t="";
		  while((t=bf.readLine())!=null) {
			  string+=t+"\n";
		  }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return string;
	}
	public String showCustomerDetails() {
		String string="";
		if(file1.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(file1))){
		  String t="";
		  while((t=bf.readLine())!=null) {
			  string+=t+"\n";
		  }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return string;
	}
	public List<String> showTransactionDetails(int accNo) {
		List<String> store=new ArrayList<>();
		String string="";
		File trFile=new File(accNo+"_transaction.txt");
		if(trFile.exists()) {
		try(BufferedReader bf=new BufferedReader(new FileReader(trFile))){
		  String t="";
		 String temp= bf.readLine();
		 store.add(temp);
		  while((t=bf.readLine())!=null) {
			  store.add(t);
		  }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		return store;
	}
	 public void addTransaction(int accNo,Transaction transaction,Map<Integer,List<Transaction>> transactions) {
    	 List<Transaction> li=transactions.get(accNo);
    	 if(li==null) {
    		 li=new ArrayList<>();
    		 transactions.put(accNo, li);
    	 }
    	 li.add(transaction);
    	 
    	 
     }
	
}
