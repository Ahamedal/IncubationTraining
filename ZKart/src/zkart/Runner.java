package zkart;


import java.util.ArrayList;

import java.util.List;
import java.util.Map;
import java.util.Scanner;





public class Runner {
    public void customerInitialization(ZKart zcartOb) {
    	Customer customer1=new Customer();
    	customer1.setEmailId("abc@zoho.com");
    	customer1.setMobileNumber(6385224645l);
    	customer1.setName("Rahul");
    	customer1.setEncryptedPassword("ApipNbjm");
    	customer1.setCredits(20);
    	zcartOb.addCustomer(customer1);
    	
    	Customer customer2=new Customer();
    	customer2.setEmailId("123@zoho.com");
    	customer2.setMobileNumber(6385224645l);
    	customer2.setName("Anitha");
    	customer2.setEncryptedPassword("ApipNbjm");
    	customer2.setCredits(0);
    	zcartOb.addCustomer(customer2);
    	
    	
    }
	public void invetoryInitialization(ZKart zCartOb) {
		Product zKart=new Product();
		
		zKart.setBrandName("Apple");
		zKart.setCategoryName("Mobile");
		zKart.setModelName("6S");
		zKart.setPriceOfProduct(60000);
		zKart.setStockOfProduct(10);
		zKart.setProductId(zCartOb.generateProductId());
		zCartOb.addZKart(zKart);
		Product zKart2=new Product();
		zKart2.setBrandName("HP");
		zKart2.setCategoryName("Laptop");
		zKart2.setModelName("G");
		zKart2.setPriceOfProduct(12000);
		zKart2.setStockOfProduct(5);
		zKart2.setProductId(zCartOb.generateProductId());
		zCartOb.addZKart(zKart2);
	   
		
		
	}
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Runner objForRunner=new Runner();
		ZKart objForLogic=new ZKart();
		objForLogic.initialSetUp();
		//objForRunner.invetoryInitialization(objForLogic);
		boolean condition=true;
		while(condition) {
			System.out.println("1.Customer Initialization \n 2.Inventory Initialization\n3.Customer Signup \n 4.Login\n7.Admin login\n9.Exit");
			int sel=sc.nextInt();
			sc.nextLine();
			switch(sel) {
			case 1:
				objForRunner.customerInitialization(objForLogic);
				break;
				
			case 2:
				objForRunner.invetoryInitialization(objForLogic);
				break;
				
			case 3:
				boolean condition2=true;
				Customer cus=new Customer();
				String emailId=null;
				while(condition2) {
				System.out.println("Enter your EmailId/UserName");
				emailId=sc.nextLine();
				if(objForLogic.existCustomer(emailId)) {
					System.out.println("Your emailId is already exist");
				}
				else {
					cus.setEmailId(emailId);
					condition2=false;
				}
				
				}
				System.out.println("Enter your name");
				String name=sc.nextLine();
				cus.setName(name);
				System.out.println("Enter Your MobileNo");
				long mNo=sc.nextLong();
				sc.nextLine();
				cus.setMobileNumber(mNo);
				boolean condition3=true;
				while(condition3) {
				boolean condition6=true;
				String passWord=null;
				while(condition6) {
				System.out.println("Enter Password");
				passWord=sc.nextLine();
				if(objForLogic.checkPasswordCritteria(passWord)) {
					condition6=false;
				}
				else {
					System.out.println("Password complexity of mandating atleast 1 lowercase,1 uppercase and 1 numbers");
				}
				}
				System.out.println("Enter retype above password");
				String reType=sc.nextLine();
				if(objForLogic.checkPassword(passWord,reType)) {
					
					//objForLogic.addPassword(emailId,passWord);
					cus.setEncryptedPassword(objForLogic.encryptPass(passWord));
					condition3=false;
				}
				else {
					System.out.println("Your password is not matching");
				}
				}
				
				objForLogic.addCustomer(cus);
				break;
				
			case 4:
				System.out.println("Enter your emailId");
				String emailId1=sc.nextLine();
				System.out.println("Enter your password");
				String pass=sc.nextLine();
				if(!objForLogic.loginCheck(emailId1, pass)) {
					System.out.println("your emailId or password is wrong");
				}
				else {
					boolean condition5=true;
					while(condition5){
					System.out.println("1.shopping 2.orderHistory 3.Exit");
					int sel3=sc.nextInt();
					sc.nextLine();
					switch(sel3) {
					case 1:
						boolean condition4=true;
						
						List<Integer> listOfKart=new ArrayList<>();
						List<Integer> noOfNeeds=new ArrayList<>();
					
						 while(condition4) 
						 {
						 Map<Integer,Product> map=objForLogic.getZKart();
						
						 for(Integer key:map.keySet()) 
						 {
							 System.out.println("Enter "+key+"-"+map.get(key));
							
							
						 }
						 
						 int sel1=sc.nextInt();
						 sc.nextLine();
						 System.out.println("How many do you want");
						 int sel7=sc.nextInt();
						 sc.nextLine();
						 listOfKart.add(sel1);
						 noOfNeeds.add(sel7);

						
						 
						  System.out.println("Enter Continue Shopping Enter true or false ");
						  condition4=sc.nextBoolean();
						  
						 }
						 
						 int invoice=objForLogic.generateInvoice();
						// List<Product> highestStock= objForLogic.getHighestStock();
						 objForLogic.checkOutCard(listOfKart, noOfNeeds);
						 sc.nextLine();
						 System.out.println("Is wishes to use credit Yes/No");
						 String choice1=sc.nextLine();
						 int credit=0;
						 if(choice1.startsWith("Y")||choice1.startsWith("y")) {
							 while(true) {
							 System.out.println("Enter how many credits are used");
							 credit=sc.nextInt();
							 sc.nextLine();
							 if(objForLogic.checkCredit(emailId1,credit)) {
								 
								 break;
							 }
							 else {
								 System.out.println("you dont have that credits");
							 }
							 }
						 }
						 System.out.println("Your unique voice number is "+invoice);
						
						 int totalAmount=0;
						
						 if(listOfKart.size()!=0) {
	                     
	                     System.out.println("Your orderDetails\n");
						 for(int i=0;i<listOfKart.size();i++)
						 {
							 
							
							 totalAmount+=(objForLogic.getProduct(listOfKart.get(i)).getPriceOfProduct()*noOfNeeds.get(i));
							 
							 System.out.println(objForLogic.getProduct(listOfKart.get(i))+"="+noOfNeeds.get(i));
						 }
						
						 System.out.println("Your totalAmount is "+(totalAmount-credit));
                         objForLogic.reduceCredit(emailId1,credit);
                         
                         
                         objForLogic.addOrderHistory(emailId1, listOfKart, noOfNeeds,credit,objForLogic.addCredit(emailId1,totalAmount));
						 }
						 else {
							 System.out.println("Your ordered product is not avilable");
						 }
						 break;
						 
					case 2:
						System.out.println(objForLogic.getOrderHistory(emailId1));
						break;
						
					case 3:
						condition5=false;

						break;
					
				}
				}
				}
				break;
			
			case 5:
				System.out.println(objForLogic.getCusInfo());
				break;
			case 6:
				System.out.println(objForLogic.getZKart());
				break;
				
			
				 
			case 7:
				
					
					System.out.println("Enter your loginId/emailId");
					String emailId6=sc.nextLine();
					System.out.println("Enter your password");
					String password=sc.nextLine();
					boolean condition13=true;
					while(condition13) {
					if(objForLogic.adminLoginCheck(emailId6,password)) {
				System.out.println("1.Show to display items 2.Show to display less than or equal to(10) 3.reOrder 3.exit");
				int see=sc.nextInt();
				sc.nextLine();
				switch(see) {
				case 1:
					System.out.println(objForLogic.printItems());
					break;
				case 2:
				
				   String temp=objForLogic.printItemsLessStock();
				   if(!temp.startsWith("No")) {
					   System.out.println("ProductId\t\tCategory\t\tBrand\t\t\tModel\t\t\tPrice\t\t\tStock\n");
				   }
				   System.out.println(temp);
			      break;
				case 3:
					
					while(true) {
						System.out.println("Enter product Id");
						int prodId=sc.nextInt();
					    sc.nextLine();
						Product product=objForLogic.getProduct(prodId);
						System.out.println("How many stock to add this product");
						int stock=sc.nextInt();
						sc.nextLine();
						objForLogic.addStock(product,stock);
						System.out.println("Enter continue to reorder Yes or No");
						String choice=sc.nextLine();
						if(choice.startsWith("N")||choice.startsWith("n")) {
							break;
						}
						
					}
					
					break;
				case 4:
					condition13=false;
			    
				
				
				}
			
			    }
				else {
					System.out.println("Your emailId and password is wrong");
				}
		     }
					break;
			case 9:
				condition=false;
	}
	}
	}
}
