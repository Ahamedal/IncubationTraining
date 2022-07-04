package fooddeliverybooking;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class FoodDeliveryBooking {

	List<DeliveryExecutives> deliveryExecutives=new ArrayList<>();
	Map<Integer,DeliveryHistory> deliveryHistory=new HashMap<>();
	Map<Integer,Customer> customers=new HashMap<>();
	List<Character> restaurants=new ArrayList<>();
	
	
	static int bookingId=0;
	
	public void addRestaurantPoints() {
		restaurants.add('A');
		restaurants.add('B');
		restaurants.add('C');
		restaurants.add('D');
		restaurants.add('E');
		
	}
	public String foodBooking(char restaurant, char destination, double pickUpTime, double dropTime, int customerId) throws Exception {
		if (restaurant < 'A' || restaurant > 'E' || destination < 'A' || destination > 'E') {
			return "Not Available";
		}
		List<DeliveryExecutives> availableExecutives = new ArrayList<>();
		String executiveDetails=getExecutiveDetails();
		for(int i=0;i<deliveryExecutives.size();i++) {
			if (availableTimeForPickup(pickUpTime, deliveryExecutives.get(i))) {
				availableExecutives.add(deliveryExecutives.get(i));
			}
		}
		DeliveryExecutives executive=checkMultipleOrder(pickUpTime,destination);
		if(executive!=null) {
			
			executive.setDeliveryCharge(executive.getDeliveryCharge()+5);
			executive.setTotal(executive.getAllowance()+executive.getDeliveryCharge());
			DeliveryHistory dh=deliveryHistory.get(executive.getLastTrip());
			dh.setDeliveryCharge(executive.getDeliveryCharge());
			dh.setOrders(dh.getOrders()+1);
			return "Booked Successfully\nBooking id is "+bookingId+"\n"+executiveDetails+"\nalotted Delivery Exceutive is:" +executive.getExecutiveName()+"(because same location within 15 mins)"+ "\n";
		}
		else {
		
		if (availableExecutives.size() == 0) {
			return "All Executives are Busy,Booking Rejected";
		}
		DeliveryExecutives executive1=lowestEarning(availableExecutives);
		executive1.setFreeTime(dropTime);
		executive1.setDeliveryCharge(executive1.getDeliveryCharge()+50);
		executive1.setAllowance(executive1.getAllowance()+10);
		bookingId++;
		executive1.setLastTrip(bookingId);
		addHistory(bookingId,executive1.getExecutiveName(),restaurant,destination,findAddBetweenTwoTimes(pickUpTime,15),findAddBetweenTwoTimes(pickUpTime,45),50);
		executive1.setLastDeliveryLocation(destination);
		executive1.setTotal(executive1.getAllowance()+executive1.getDeliveryCharge());
	
		return "Booked Successfully\nBooking id is "+bookingId+"\n"+executiveDetails+"\nalotted Delivery Exceutive is " +executive1.getExecutiveName()+ "\n";
		}
	}
	public void addHistory(int bookingId,String executiveName,char restaurant,char destination,double pickUpTime,double deliveryTime,int charge) throws Exception {
		stringCheck(executiveName);
		DeliveryHistory history=new DeliveryHistory();
		history.setTrip(bookingId);
		history.setExecutiveName(executiveName);
		history.setPickUpTime(pickUpTime);
		history.setDeliveryTime(deliveryTime);
		history.setDeliveryCharge(charge);
		history.setRestaurantName(restaurant);
		history.setOrders(1);
		history.setDestinationPoint(destination);
		deliveryHistory.put(history.getTrip(), history);
		
	}
	public String printHistory() {
		String string = "";

		string += "Trip\t\tExecutive\t\tRestaurant\t\tDestinationPoint\t\tOrders\t\tPickUpTime\t\tDeliveryTime\t\tCharges\n";
		for (int i=1;i<=deliveryHistory.size();i++) {

			DeliveryHistory dh=deliveryHistory.get(i);
			
			
			
			
				string += dh.getTrip() + "\t\t\t" + dh.getExecutiveName()+ "\t\t\t"
						+ dh.getRestaurantName()+ "\t\t\t" + dh.getDestinationPoint()+ "\t\t\t"
						+ dh.getOrders()+ "\t\t\t" + dh.getPickUpTime()+ "\t\t\t"
						+ dh.getDeliveryTime()+"\t\t\t" + dh.getDeliveryCharge()+"\n";
		

		}
		return string;
	}
	public String getExecutiveDetails() {
		String details="";
		details+="Executive"+"\t\t"+"Delivery Charge Earned\n";
		for(int i=0;i<deliveryExecutives.size();i++) {
			details+=deliveryExecutives.get(i).getExecutiveName()+"\t\t\t"+deliveryExecutives.get(i).getDeliveryCharge()+"\n";
		}
		return details;	
		
	}
	public void addDeliveryExecutive(int n) {
		for(int i=1;i<=n;i++) {
			DeliveryExecutives deliveryExecutive=new DeliveryExecutives();
			deliveryExecutive.setExecutiveName("DE"+i);
			deliveryExecutives.add(deliveryExecutive);
		}
		
	}
	public DeliveryExecutives checkMultipleOrder(double pickUpTime,char deliveryLocation) {
		
		for(int i=0;i<deliveryExecutives.size();i++) {
			DeliveryExecutives executive=deliveryExecutives.get(i);
			double freeTime=executive.getFreeTime();
			double time=findDifferenceBetweenTwoTimes(freeTime);
			if(time>=pickUpTime&&executive.getLastDeliveryLocation()==deliveryLocation) {
				return executive;
			}
			
		}
		return null;
		
	}
	public double findDifferenceBetweenTwoTimes(double freeTime) {
		SimpleDateFormat format=new SimpleDateFormat("HH:mm");
		String ans=null;
		try {
			String string=String.valueOf(freeTime);
			string=string.replace(".", ":");
			String[] array=string.split(":");
			if(array[1].length()==1) {
				string+="0";
			}
			Date date1=format.parse(string);
			Date date2=format.parse("0:30");
			long difference=Math.abs(date1.getTime()-date2.getTime());
			long hours=(difference/(60*60*1000))%24;
			long minutes=(difference/(60*1000))%60;
			ans=String.valueOf(hours)+"."+String.valueOf(minutes);
			
			
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Double.parseDouble(ans);
	}
	public double findAddBetweenTwoTimes(double freeTime,int dropTime) {
		String[] array1=String.valueOf(freeTime).split("[.]");
		if (array1[1].length() == 1) {
			array1[1] += "0";
		}
		int totalMinutes=(Integer.parseInt(array1[0])*60)+Integer.parseInt(array1[1])+dropTime;
		String string=String.valueOf(totalMinutes/60)+"."+String.valueOf(totalMinutes%60);

		return Double.parseDouble(string);


	}
	public boolean availableTimeForPickup(double pickUpTime,DeliveryExecutives executive) throws Exception {
		objectCheck(executive);
	double freeTime=executive.getFreeTime();
	if(pickUpTime<freeTime) {
		return false;
	}
	return true;
	}
	public DeliveryExecutives lowestEarning(List<DeliveryExecutives> executives) throws Exception {
		objectCheck(executives);
		int min = Integer.MAX_VALUE;
		DeliveryExecutives lowest = null;
		for (int i = 0; i < executives.size(); i++) {
			int earning = executives.get(i).getDeliveryCharge();
			if (earning < min) {
				min = earning;
				lowest = executives.get(i);
			}
		}
		return lowest;
	}
	public String printExecutiveDetails() {
		String string="";
		string+="Total earned\n";
		string+="ExecutiveName\t\tAllowance\t\tDeliveryCherge\t\tTotal\n";
		for(int i=0;i<deliveryExecutives.size();i++) {
			DeliveryExecutives de=deliveryExecutives.get(i);
			string+=de.getExecutiveName()+"\t\t\t"+de.getAllowance()+"\t\t\t"+de.getDeliveryCharge()+"\t\t\t"+de.getTotal()+"\n";
		}
		return string;
	}
	public double changeTimeFormat(String pickUpTime) throws Exception {
		stringCheck(pickUpTime);
    	double time=0;
    	if(pickUpTime.contains("AM")) {
    		pickUpTime=pickUpTime.replaceAll(" ", "");
    		pickUpTime=pickUpTime.replace("AM", "");
    		time=Double.parseDouble(pickUpTime);
    		
    	}
    	else if(pickUpTime.contains("PM")) {
    		pickUpTime=pickUpTime.replaceAll(" ", "");
    		pickUpTime=pickUpTime.replace("PM", "");
    		time=Double.parseDouble(pickUpTime)+12.00;
    	}
    	else {
    		time=Double.parseDouble(pickUpTime);
    	}
    	return time;
    }
	 private void stringCheck(String str1) throws Exception{
		  if(str1==null||str1.isEmpty()) {
			  throw new Exception("String cannot be null or empty");
		  }
	  }
	  private void objectCheck(Object obj)throws Exception{
		  if(obj==null) {
			  throw new Exception(obj+"Cannot be null");
		  }
	  }
	
}
