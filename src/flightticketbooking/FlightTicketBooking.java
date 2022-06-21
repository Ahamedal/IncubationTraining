package flightticketbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FlightTicketBooking {
	int surge=0;
	int ticketNumber=1000;
	Map<Integer,Flight> flights=new HashMap<>();
	Map<Integer,Ticket> bookingTicket=new HashMap<>();
	Map<Integer,List<Integer>> listOfTickets=new HashMap<>();
	FileLayer fl=new FileLayer();
	
  void initailSetUp() {
	  
	  for(int i=1;i<=3;i++) {
	  String str1=fl.readFile1(i);
	  String str2=fl.readFile2(i);
	  List<Integer> list1=initialSeatSetup(str1);
	  List<Integer> list2=initialSeatSetup(str2);
	  
	 Map<String,String> businessClass= seatingArrangements(list1);
	 Map<String,String> economyClass=seatingArrangements(list2);
	
	  setFlight(111+i,businessClass,economyClass);
	  
	  System.out.println(str1+"\n"+str2);
	  }
	  
  }
  public List<Integer> initialSeatSetup(String str1) {
	  List<Integer> list1=new ArrayList<>();
	  String[] array=str1.split(":");
	  String[] array1=array[1].split(",");
	
	  for(String ar:array1) {
		  if(ar.contains("{")) {
			  ar=ar.replace("{", "");
		  }
		  if(ar.contains("}")) {
			  ar=ar.replace("}", "");
		  }
		  list1.add(Integer.parseInt(ar));
		  
	  }
	  return list1;
  }
  public void setFlight(int flightNumber,Map<String,String> business,Map<String,String> economyClass) {
	  
		  Flight flight=new Flight();
		  flight.setFlightNumber(flightNumber);
		  flight.setEconomyClassTicket(economyClass);
		  flight.setBusinessClassTicket(business);
		  flight.setBusinessTicketPrice(2000);
		  flight.setEconomyTicketPrice(1000);
		  flight.setSurgePrice(100+surge);
		  surge+=10;
		  if(flightNumber==112) {
			  flight.setFlightName("Flight-A112-Chennai-Mumbai");
			  flight.setSource("Chennai");
			  flight.setDestination("Mumbai");
		  }
		  else if(flightNumber==113) {
			  flight.setFlightName("Flight-A113-Chennai-Kolkata");
			  flight.setSource("Chennai");
			  flight.setDestination("Kolkata");
		  }
		  else if(flightNumber==114) {
			  flight.setFlightName("Flight-A114-Chennai-Delhi");
			  flight.setSource("Chennai");
			  flight.setDestination("Delhi");
		  }
		  flights.put(flight.getFlightNumber(), flight);
	 
  }
  public void addListOfTicket() {
	  
  }
  public List<Flight> searchFlights(String source,String destination){
	  List<Flight> l=new ArrayList<>();
	  Set<Integer> set=flights.keySet();
	  for(int flightNumber:set) {
		 Flight flight= flights.get(flightNumber);
		 if(flight.getSource().equals(source)&&flight.getDestination().equals(destination)) {
			 l.add(flight);
		 }
	  }
	  if(l.isEmpty()) {
		  System.out.println("No flights for source to destination");
	  }
	  return l;
  }
  public void showMap() {
	  Flight flight=flights.get(112);
	  Map<String,String> businessClass=flight.getBusinessClassTicket();
	  Map<String,String> economyClass=flight.getEconomyClassTicket();
	  System.out.println(businessClass);
	  System.out.println(economyClass);
  }
  public Map<String,String> seatingArrangements(List<Integer> list) {
	  String left="W";
	  String middle="A";
	  String right="A";
	  
	  Map<String,String> businessClass=new HashMap<>();
	  
	  for(int i=1;i<=list.get(3);i++) {
		  int column=65;
		  char c=(char) column;
		  for(int j=0;j<list.get(0);j++) {
			  if(j==list.get(0)-1) {
				  left="A";
			  }
			 c=(char) column;
			 String str=""+i+"_"+c;
			 businessClass.put(str, left);
			 left="M";
			 column++;
			 
		  }
		  
		  for(int k=0;k<list.get(1);k++) {
			  if(k==list.get(1)-1) {
				  middle="A";
			  }
			     c=(char) column;
				 String str=""+i+"_"+c;
				 businessClass.put(str, middle);
				 middle="M";
				 column++;
		  }
		  for(int l=0;l<list.get(2);l++) {
			  if(l==list.get(2)-1) {
				  right="W";
			  }
			     c=(char) column;
				 String str=""+i+"_"+c;
				 businessClass.put(str, right);
				 middle="M";
				 column++;
		  }
	  }
	  return businessClass;
  }
  public Map<String,String> availableTickets(int flightNumber,String ticketType){
	  Flight flight=flights.get(flightNumber);
	  Map<String,String> map=new HashMap<>();
	  if(ticketType.startsWith("B")||ticketType.startsWith("b")) {
		  map=flight.getBusinessClassTicket();
	  }
	  else if(ticketType.startsWith("E")||ticketType.startsWith("e")) {
		  map=flight.getEconomyClassTicket();
	  }
	  return map;
  }
  public boolean checkSeat(int flightNumber,String ticketType,String seatNumber) {
	  Flight flight=flights.get(flightNumber);
	
	  if(ticketType.startsWith("B")||ticketType.startsWith("b")) {
		  Map<String,String> map=flight.getBusinessClassTicket();
		  if(map.containsKey(seatNumber)) {
			  return true;
		  }
		 
		
	  }
	  else if(ticketType.startsWith("E")||ticketType.startsWith("e")) {
		  Map<String,String> map=flight.getEconomyClassTicket();
		  if(map.containsKey(seatNumber)) {
			  return true;
		  }
		 
			
	  }
	  return false;
  }
  public double getAmount(Passenger passenger,int flightNumber){
      double totalAmount=0;
     
      String ticketType= passenger.getSeatType();
      Flight flight=flights.get(flightNumber);
      if(ticketType.startsWith("e")||ticketType.startsWith("E")){
          totalAmount+=flight.getEconomyTicketPrice();
      }else if(ticketType.startsWith("b")||ticketType.startsWith("B")){
          totalAmount+=flight.getBusinessTicketPrice();
      }
      if(passenger.isMeal()){
          totalAmount+=flight.getMealPrice();
      }
      if(passenger.getSeatType().equals("W")||passenger.getSeatType().equals("A")) {
    	  totalAmount+=100;
      }
      
      return totalAmount;
  }
  public String bookTicket(List<Passenger> passengers,int flightNo,String ticketType) {
	  Ticket ticket=new Ticket();
	  ticket.setFlightNumber(flightNo);
	  for(Passenger passenger:passengers) {
		 double amount=getAmount(passenger,flightNo);
		 passenger.setAmount(amount);
		 ticket.setTotalAmount(amount);
		 ticket.setPassengers(passenger);
		 bookingSeat(passenger.getSeatNumber(),flightNo,ticketType);
	  }
	  ticket.setBookingId(++ticketNumber);
	  ticket.setSeatClass(ticketType);
	  bookTicket(ticket);
	  surgePricing(flightNo);
	  String str="Your ticket number is"+ticketNumber;
	  str+=passengers.toString()+"Your total amount is"+ticket.getTotalAmount();
	  return str;
	  
  }
  public void surgePricing(int flightNumber) {
	  Flight flight=flights.get(flightNumber);
	  double k=flight.getSurgePrice();
	  flight.setBusinessTicketPrice(flight.getBusinessTicketPrice()+k);
	  flight.setEconomyTicketPrice(flight.getEconomyTicketPrice()+(2*k));
  }
  public void bookTicket(Ticket ticket) {
	  bookingTicket.put(ticket.getBookingId(), ticket);
  }
  public void bookingSeat(String seat,int flightNumber,String ticketType) {
	  Flight flight=flights.get(flightNumber);
	  if(ticketType.startsWith("B")||ticketType.startsWith("b")) {
		 Map<String,String> map= flight.getBusinessClassTicket();
		 map.remove(seat);
	  }
	  if(ticketType.startsWith("E")||ticketType.startsWith("e")) {
			 Map<String,String> map= flight.getEconomyClassTicket();
			 map.remove(seat);
	  }
  }
  public String cancelTicket(int flightNumber,int ticketNumber,String seatNumber) {
	  double refundAmount=0;
	  Ticket ticket=bookingTicket.get(ticketNumber);
	  if(ticket==null) {
		  return "Your ticket Number is not found";
	  }
	  Map<String,Passenger> passengers=ticket.getPassengers();
	  if(!passengers.containsKey(seatNumber)) {
		  return "Seat Number is not exist";
	  }
	  if(seatNumber.equals("0")) {
		 Set<String> set= passengers.keySet();
		 for(String seat:set) {
			  Passenger passenger=passengers.get(seat);
			  addTicket(flightNumber,passenger,ticket.getSeatClass());
			  refundAmount+=cancelTicket(passenger);
			  passengers.remove(seat);
		 }
		 ticket.setTotalAmount(ticket.getTotalAmount()-refundAmount);
	  }
	  else {
	  Passenger passenger=passengers.get(seatNumber);
	  addTicket(flightNumber,passenger,ticket.getSeatClass());
	  refundAmount+=cancelTicket(passenger);
	  passengers.remove(seatNumber);
	  ticket.setTotalAmount(ticket.getTotalAmount()-refundAmount);
	  }
	  return "Cancel Successfully,Your refund amount is"+refundAmount;
	  
  }
  public void addTicket(int flightNumber,Passenger passenger,String ticketType) {
	  Flight flight=flights.get(flightNumber);
	  String seatNumber=passenger.getSeatNumber();
	  String seatType=passenger.getSeatType();
	  if(ticketType.startsWith("B")||ticketType.startsWith("b")) {
		  Map<String,String> map=flight.getBusinessClassTicket();
		  map.put(seatNumber, seatType);
	  }
	  else  if(ticketType.startsWith("E")||ticketType.startsWith("e")) {
		  Map<String,String> map=flight.getEconomyClassTicket();
		  map.put(seatNumber, seatType);
	  }
  }
  public double cancelTicket(Passenger passenger) {
	 double amount= passenger.getAmount();
	 amount-=200;
	 return amount;
	
  }
  public void printAvailableTicketForEachFlight() {
	  Set<Integer> set=flights.keySet();
	  for(int flightNumber:set) {
		  Flight flight=flights.get(flightNumber);
		  System.out.println("Business Tickets are :");
		  Map<String,String> business=flight.getBusinessClassTicket();
		  if(business.isEmpty()) {
			  System.out.println("No Business Tickets");
		  }
		  else {
			  System.out.println(business);
		  }
		  System.out.println("Economy Tickets are:");
		  Map<String,String> economy=flight.getEconomyClassTicket();
		  if(economy.isEmpty()) {
			  System.out.println("No Economy Tickets");
		  }
		  else {
			  System.out.println(economy);
		  }
		  
	  }
  }
//  public Map<String,String> seatingArrangementsForEconomy(List<Integer> list) {
//	  String left="W";
//	  String middle="A";
//	  String right="A";
//	  
//	  Map<String,String> busClass=new HashMap<>();
//	  
//	  for(int i=1;i<=list.get(3);i++) {
//		  int column=65;
//		  char c=(char) column;
//		  for(int j=0;j<list.get(0);j++) {
//			  if(j==list.get(0)-1) {
//				  left="A";
//			  }
//			 c=(char) column;
//			 String str=""+i+"_"+c;
//			 businessClass.put(str, left);
//			 left="M";
//			 column++;
//			 
//		  }
//		  
//		  for(int k=0;k<list.get(1);k++) {
//			  if(k==list.get(1)-1) {
//				  middle="A";
//			  }
//			     c=(char) column;
//				 String str=""+i+"_"+c;
//				 businessClass.put(str, middle);
//				 middle="M";
//				 column++;
//		  }
//		  for(int l=0;l<list.get(2);l++) {
//			  if(l==list.get(2)-1) {
//				  right="W";
//			  }
//			     c=(char) column;
//				 String str=""+i+"_"+c;
//				 businessClass.put(str, right);
//				 right="M";
//				 column++;
//		  }
//	  }
//	  return business
//  }

}
