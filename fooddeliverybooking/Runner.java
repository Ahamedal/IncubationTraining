package fooddeliverybooking;

import java.util.InputMismatchException;
import java.util.Scanner;



public class Runner {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		FoodDeliveryBooking fd=new FoodDeliveryBooking();
		fd.addRestaurantPoints();
	    boolean condition=true;
	System.out.println("How many DeliveryExecutive do you want");
	int executiveCount=sc.nextInt();
	sc.nextLine();
	fd.addDeliveryExecutive(executiveCount);
	while(condition) {
		System.out.println("Enter 1.Booking 2.show delivery history 3.show executives Details  4.Exit");
		int choose=sc.nextInt();
		sc.nextLine();
		switch(choose) {
		case 1:
			try {
			System.out.println("Enter Your customerId");
			int cusId=sc.nextInt();
			System.out.println("Enter your RestaurantName(A,B,C,D,E)");
			char restaurant=sc.next().charAt(0);
			System.out.println("Enter your deliveryLocation(A,B,C,D,E)");
			char delivery=sc.next().charAt(0);
			
			System.out.println("Enter Your time");
			double pickUpTime=sc.nextDouble();
			double dropTime=fd.findAddBetweenTwoTimes(pickUpTime,45);
			System.out.println(fd.foodBooking(restaurant, delivery,pickUpTime, dropTime,cusId));
			
			}
			catch(InputMismatchException e) {
				System.out.println("Enter numbers only");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
			break;
		
		case 2:
			System.out.println(fd.printHistory());
			break;
			
		case 3:
			System.out.println(fd.printExecutiveDetails());
			break;
			
		case 4:
			condition=false;
		
		}
	}

	}
}
