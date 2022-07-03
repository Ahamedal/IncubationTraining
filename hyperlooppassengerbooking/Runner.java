package hyperlooppassengerbooking;

import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		HyperloopPassengerBooking hp = new HyperloopPassengerBooking();
		Scanner sc = new Scanner(System.in);
		char startingPoint = 'A';
		while (true) {
			try {
				System.out.println("Enter commands");
				String command = sc.nextLine();
				if (command.contains("INIT")) {
					String route = null;
					String[] initCommand = command.split(" ");
					int size = Integer.parseInt(initCommand[1]);

					startingPoint = initCommand[2].charAt(0);
					System.out.println("Enter startingpoint endpoint distance(A B 3)");
					for (int i = 0; i < size; i++) {
						route = sc.nextLine();
						String[] array = route.split(" ");
						hp.addConnectingRoutes(array[0].charAt(0), array[1].charAt(0), Integer.parseInt(array[2]));
					}

				} else if (command.contains("ADD_PASSENGER")) {
					String pass = null;
					String[] addPassengerCommand = command.split(" ");
					int size = Integer.parseInt(addPassengerCommand[1]);
					System.out.println("Enter name age destination(dharma 22 C)");
					for (int i = 0; i < size; i++) {
						pass = sc.nextLine();
						String[] array = pass.split(" ");
						hp.forCommandAddPassenger(array[0], Integer.parseInt(array[1]), array[2].charAt(0),
								startingPoint);
					}
				} else if (command.contains("START_POD")) {
					String[] addStartPodCommand = command.split(" ");
					int size = Integer.parseInt(addStartPodCommand[1]);
					List<Passenger> passenger = hp.forCommandStartPOD(size);
					if (passenger.size() != 0) {
						for (int i = 0; i < passenger.size(); i++) {
							System.out.println(passenger.get(i));
						}
					} else {
						System.out.println("No passengers in queue");
					}
				} else if (command.contains("PRINT_Q")) {
					List<Passenger> passengers = hp.forCommandPrintQ();
					if(passengers.size()!=0) {
						System.out.println(passengers.size());
					for (int i = 0; i < passengers.size(); i++) {
						Passenger passenger = passengers.get(i);
						System.out.println(passenger.getName() + "\t\t" + passenger.getAge());
					}
					}
					else {
						System.out.println("No passenger in queue");
					}
				} else if (command.equals("EXIT")) {
					break;
				} else {
					System.out.println("Enter command correctly");
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Given command is not in specified format");
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
