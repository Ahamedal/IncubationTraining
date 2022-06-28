package calltaxibooking;

import java.util.Scanner;

public class TaxiRunner {
	

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		CallTaxiBooking object=new CallTaxiBooking();
		object.addPoints();
	boolean condition=true;
	System.out.println("How many taxi do you want");
	int tax=sc.nextInt();
	sc.nextLine();
	for(int i=0;i<tax;i++) {
		Taxi t=new Taxi();
		object.addTaxi(t);
	}
	while(condition) {
		System.out.println("Enter 1.Booking 2.print taxi deatils 3.change status");
		int choose=sc.nextInt();
		sc.nextLine();
		switch(choose) {
		case 1:
			System.out.println("Enter your pick up point ");
			char pickUp=sc.next().charAt(0);
			System.out.println("Enter your drop point ");
			char drop=sc.next().charAt(0);
			System.out.println("Enter Your pickUpTime");
			float pickUpTime=sc.nextFloat();
			int bookingType=1;
			int amount=object.payment(pickUp, drop);
			System.out.print("Charges For Normal(1) "+amount);
			if(object.isShareBooking(pickUp, drop)) {
				System.out.println(" Share(2) "+((amount*40)/100));
				System.out.println("Enter bookingType");
				bookingType=sc.nextInt();
				if(bookingType==2) {
					amount=(amount*40)/100;
				}
			}
		
			
			int k=Math.abs(pickUp-drop);
			int dropTime=0;
			for(int i=0;i<k;i++) {
				dropTime+=15;
			}
			float dropTime1=object.calculateDropTime(pickUpTime,dropTime);
			int cus=object.generatCustomerId();
			System.out.println(object.taxiBooking(pickUp, drop, pickUpTime, dropTime1,cus,bookingType,amount));
			System.out.println("Your Booking id is "+cus);
			break;
		
		case 2:
			System.out.println(object.printHistory());
			break;
		
		
			
		}
	}

	}

}
