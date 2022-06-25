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
			System.out.println("How much time takes to pickup you ");
			int pickUpTime=sc.nextInt();
			long t=0;
			for(int i=0;i<pickUpTime;i++) {
				t+=3600000;
			}
			int cus=object.generatCustomerId();
			System.out.println(object.taxiBooking(pickUp, drop, t, cus));
			break;
		
		case 2:
			//System.out.println(object.printHistory());
			break;
		
		case 3:
			int taxiNo=sc.nextInt();
			sc.nextLine();
			object.changeStatus(taxiNo);
			break;
			
		}
	}

	}

}
