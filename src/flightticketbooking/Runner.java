package flightticketbooking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Runner {
	private static Passenger getPassenger(String name, String address, String seatType, String seat) {
		Passenger passenger = new Passenger();
		passenger.setAddress(address);
		passenger.setName(name);

		
		passenger.setSeatType(seatType);
		
		
		passenger.setSeatNumber(seat);
		return passenger;
	}

	public static void main(String[] args) {

		FileLayer f = new FileLayer();
		 //f.createDirectory();
		 //f.createFile();
		FlightTicketBooking ft = new FlightTicketBooking();
		Scanner sc = new Scanner(System.in);
		try {
		ft.initailSetUp();
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
		boolean condition = true;
		while (condition) {
			System.out.println("Choose the decision :");
			System.out.println("1.List name of flights and no of flights from folder\n2.Handle Booking\n3.Cancel Ticket\n4.show all available seats for each flights\n5.show seat numbers for meal ordered in each flight\n6.show indivitual and flight summary\n7.Exit");
			int choose = sc.nextInt();
			switch (choose) {
			case 1:
				String[] arrays=ft.getNoOfFlightsAndName();
				System.out.println("noOfFlights is = "+arrays.length);
				for(int i=0;i<arrays.length;i++) {
					System.out.println(arrays[i]);
				}
				break;
			case 2:
				try {
				System.out.println("1.Search Flight from given location\n2.Booking");
				int choose2 = sc.nextInt();
				sc.nextLine();
				switch (choose2) {

				case 1:
					System.out.println("Enter source place");
					String source = sc.nextLine();
					System.out.println("Enter destination");
					String destination = sc.nextLine();
					List<Flight> list = ft.searchFlights(source, destination);
					for (int i = 0; i < list.size(); i++) {
						System.out.println(list.get(i));
					}
					break;
				case 2:
					System.out.println("Number of Passengers");
					int numOfPassengers = sc.nextInt();
					System.out.println("Flight Number");
					int flightNumber = sc.nextInt();
					sc.nextLine();
					System.out.println("Business/Economy");
					String ticketType = sc.nextLine();
					System.out.println(ft.availableTickets(flightNumber, ticketType));
					System.out.println("Are you want Meal(Yes/No)");
					String meal = sc.nextLine();
					boolean meals = false;
					if (meal.startsWith("Y") || meal.startsWith("y")) {
						meals = true;
					}

					List<Passenger> passengers = new ArrayList<>();
					for (int i = 0; i < numOfPassengers; i++) {
						System.out.println("Name");
						String name = sc.nextLine();
						System.out.println("Address");
						String address = sc.nextLine();
						String seatNumber = null;
						while (true) {
							System.out.println("Enter SeatNumber");
							seatNumber = sc.nextLine();
							if (ft.checkSeat(flightNumber, ticketType, seatNumber)) {
								break;
							} else {
								System.out.println("seat is already booked or not available");
							}
						}
						String seatType=ft.getSeatType(flightNumber,seatNumber,ticketType);
						ft.bookingSeat(seatNumber,flightNumber,ticketType);
						
						Passenger passenger = getPassenger(name, address, seatType, seatNumber);
						passengers.add(passenger);

					}
					System.out.println(ft.bookTicket(passengers, flightNumber, ticketType, meals));

					break;
				}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 3:
				try {
				System.out.println("Flight Number :");
				int flightNumber2 = sc.nextInt();
				System.out.println("Ticket Number :");
				int ticketNumber = sc.nextInt();
				System.out.println("1.individual\n2.All");
				int decision1 = sc.nextInt();
				sc.nextLine();
				switch (decision1) {
				case 1:
					System.out.println("Enter seat Number");
					String seatNumber = sc.nextLine();
					System.out.println(ft.cancelTicket(flightNumber2, ticketNumber, seatNumber));
					break;

				case 2:
					System.out.println(ft.cancelTicket(flightNumber2, ticketNumber, "0"));
					break;

				}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case 4:
				ft.printAvailableTicketForEachFlight();
				break;

			case 5:
				System.out.println("What flight do show seat numbers for ordered meals");
				System.out.println(
						"Enter number 1.Flight-A112-Chennai-Mumbai\n2.Flight-A113-Chennai-Kolkata\n3.Flight-A114-Chennai-Delhi");
				int number = sc.nextInt();
				sc.nextLine();
				switch (number) {
				case 1:
					ft.printSeatNumbersForMealForBusiness(112);

					
					ft.printSeatNumbersForMealForEconomy(112);

					
					break;

				case 2:
                    ft.printSeatNumbersForMealForBusiness(113);

					
					ft.printSeatNumbersForMealForEconomy(113);

					break;

				case 3:
                    ft.printSeatNumbersForMealForBusiness(114);

					
					ft.printSeatNumbersForMealForEconomy(114);

					break;
					
				default:
					System.out.println("Enter correct number");
				}
				break;
				
			case 6:
				try {
				System.out.println("Enter booking id");
				int bookingId=sc.nextInt();
				ft.printIndividualAndFlightSummary(bookingId);
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
				break;
				
			case 7:
				condition=false;
				

			}

		}
		
	}
}
