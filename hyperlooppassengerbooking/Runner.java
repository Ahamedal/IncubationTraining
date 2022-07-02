package hyperlooppassengerbooking;

import java.util.Map;
import java.util.TreeMap;

public class Runner {

	public static void main(String[] args) {
		HyperloopPassengerBooking hp=new HyperloopPassengerBooking();
		hp.initialSetUp();
		Map<Integer,String> map=new TreeMap<>();
		hp.getRoutes('A', 'D', 0, "A", map);
		System.out.println(map);
		
		System.out.println("Enter commands");
		
	}
}
