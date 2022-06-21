package flightticketbooking;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
	 private static Passenger getPassenger(String name, String address, String ticketType, boolean meal,String seat) {
	        Passenger passenger=new Passenger();
	        passenger.setAddress(address);
	        passenger.setName(name);
	        passenger.setMeal(meal);
	        if(ticketType.startsWith("b")||ticketType.startsWith("B")){
	            ticketType="Business";
	        }else if(ticketType.startsWith("e")||ticketType.startsWith("E")){
	            ticketType="Economy";
	        }
	        passenger.setSeatType(ticketType);
	        passenger.setSeatNumber(seat);
	        return passenger;
	    }
	public static void main(String[] args) {

	FileLayer f=new FileLayer();
	//f.createDirectory();
	//f.createFile();
	FlightTicketBooking ft=new FlightTicketBooking();
	Scanner sc=new Scanner(System.in);
	ft.initailSetUp();
	boolean condition=true;
	while(condition) {
		 System.out.println("Choose the decision :");
         System.out.println("\n2.Handle Book Ticket\n3.Cancel Ticket\n4.show all available seats for each flights\n5.");
         int choose=sc.nextInt();
         switch(choose) {
         case 2:
        	 System.out.println("1.Search Flight from given location\n2.Booking");
        	 int choose2=sc.nextInt();
        	 sc.nextLine();
        	 switch(choose2) {
        	 
        	 case 1:
        		 System.out.println("Enter source place");
        		 String source=sc.nextLine();
        		 System.out.println("Enter destination");
        		 String destination=sc.nextLine();
        		 List<Flight> list=ft.searchFlights(source,destination);
        		 for(int i=0;i<list.size();i++) {
        			 System.out.println(list.get(i));
        		 }
        		 break;
        	 case 2:
        	 System.out.println("Number of Passengers");
             int numOfPassengers=sc.nextInt();
             System.out.println("Flight Number");
             int flightNumber=sc.nextInt();
             sc.nextLine();
             System.out.println("Business/Economy");
             String ticketType=sc.nextLine();
             System.out.println(ft.availableTickets(flightNumber,ticketType));
             System.out.println("Are you want Meal(Yes/No)");
             String meal=sc.nextLine();
             boolean meals=false;
             if(meal.startsWith("Y")||meal.startsWith("y")) {
            	meals=true; 
             }
           
             List<Passenger> passengers=new ArrayList<>();
             for(int i=0;i<numOfPassengers;i++){
                 System.out.println("Name");
                 String name=sc.nextLine();
                 System.out.println("Address");
                 String address=sc.nextLine();
                 String seatNumber=null;
                 while(true) {
                 System.out.println("Enter SeatNumber");
                 seatNumber=sc.nextLine();
                 if(ft.checkSeat(flightNumber,ticketType,seatNumber)) {
                	 break;
                 }
                 else {
                	 System.out.println("seat is already booked or not available");
                 }
                 }
               
                 Passenger passenger=getPassenger(name,address,ticketType,meals,seatNumber);
                 passengers.add(passenger);
                
             }
             ft.bookTicket(passengers,flightNumber,ticketType);
        	 
             break;
        	 }
        	 break;
             
         case 3:
        	 System.out.println("Flight Number :");
             int flightNumber2=sc.nextInt();
             System.out.println("Ticket Number :");
             int ticketNumber=sc.nextInt();
             System.out.println("1.individual\n2.All");
             int decision1=sc.nextInt();
             sc.nextLine();
             switch(decision1) {
             case 1:
            	 System.out.println("Enter seat Number");
            	 String seatNumber=sc.nextLine();
            	 ft.cancelTicket(flightNumber2,ticketNumber,seatNumber);
            	 break;
            	 
             case 2:
            	 ft.cancelTicket(flightNumber2,ticketNumber,"0");
            	 break;
            	 
             }
             break;
             
         case 4:
        	 ft.printAvailableTicketForEachFlight();
        	 break;
             
	}
	
	
	
	
	
	}
	}
}
