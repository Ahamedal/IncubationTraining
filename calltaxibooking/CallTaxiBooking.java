package calltaxibooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CallTaxiBooking {

	List<Taxi> taxi=new ArrayList<>();
	List<Character> points=new ArrayList<>();
	Map<Integer,List<TaxiHistory>> taxiHistory=new HashMap<>();
	int taxiNo=0;
	
  public void addPoints() {
	  points.add('A');
	  points.add('B');
	  points.add('C');
	  points.add('D');
	  points.add('E');
	 
  }
  public void addTaxi(Taxi taxDetails){
	  taxDetails.setTaxiNo(++taxiNo);
	  taxi.add(taxDetails);
  }
  public String taxiBooking(char pickUpPoint,char dropPoint,long pickUpTime,int customerId) {
	  if(pickUpPoint<'A'||pickUpPoint>'F'||dropPoint<'A'||dropPoint>'F') {
		  return "Not Available";
	  }
	  List<Taxi> availableTaxi=new ArrayList<>();
	  for(int i=0;i<taxi.size();i++) {
		  if(taxi.get(i).isAvailable()&&availableTimeForPickUp(pickUpPoint,pickUpTime,taxi.get(i))){
			  availableTaxi.add(taxi.get(i));
		  }
	  }
	  if(availableTaxi.size()==0) {
		  return "All taxi Busy,Booking Rejected";
	  }
	  Taxi nearestTaxi=nearestTaxi(availableTaxi,pickUpPoint);
	  nearestTaxi.setAvailable(false);
	  nearestTaxi.setCurrentPosition(dropPoint);
	  int amount=payment(pickUpPoint,dropPoint);
	  double earned=nearestTaxi.getAmountEarned();
	  nearestTaxi.setAmountEarned(earned+amount);
	  TaxiHistory taxiHistory=historySetter(pickUpPoint,dropPoint,pickUpTime,amount,customerId);
	  addHistory(taxiHistory,nearestTaxi);
	  return "Booked Successfully\nTaxi can be alotted";
	  
  }
  public void addHistory(TaxiHistory taxiHistor,Taxi nearestTaxi) {
	  List<TaxiHistory> lis=taxiHistory.get(nearestTaxi.getTaxiNo());
	  if(lis==null) {
		  lis=new ArrayList<>();
		  taxiHistory.put(nearestTaxi.getTaxiNo(), lis);
	  }
	  lis.add(taxiHistor);
  }
  public TaxiHistory historySetter(char pickUpPoint,char dropPoint,long pickUpTime,int amount,int custoerId) {
	  TaxiHistory taxiHistory=new TaxiHistory();
	  taxiHistory.setBookingId(custoerId);
	  taxiHistory.setCustomerId(custoerId);
	  taxiHistory.setPickUpPoint(pickUpPoint);
	  taxiHistory.setDropPoint(dropPoint);
	  taxiHistory.setAmount(amount);
	  taxiHistory.setPickUpTime(System.currentTimeMillis()+pickUpTime);
	  return taxiHistory;
  }
  public boolean availableTimeForPickUp(char pickUpPoint,long pickUpTime,Taxi taxiObj) {
	 int fromPoint=taxiObj.getCurrentPosition();
	 int toPoint=pickUpPoint;
	  long reachTime=0;
	 if(fromPoint>toPoint) {
		 for(int i=fromPoint;i>toPoint;i--) {
			 reachTime+=900000;
		 }
	 }
	 else {
		 for(int i=toPoint;i>fromPoint;i--) {
			 reachTime+=900000;
		 }
	 }
	 if(pickUpTime<reachTime) {
		 return false;
	 }
	 return true;
  }
  public Taxi nearestTaxi(List<Taxi> lis,char pickUpPoint) {
	  int min=Integer.MAX_VALUE;
	  ArrayList<Taxi> nearestTaxi=new ArrayList<>();
	  Taxi nearest=null;
	  for(int i=0;i<lis.size();i++) {
		 int val=Math.abs(lis.get(i).getCurrentPosition()-pickUpPoint) ;
		 if(val<=min) {
			
			 min= val;
			 nearest=lis.get(i);
			 if(min==val) {
					nearestTaxi.add(lis.get(i)) ;
				 }
				 else {
					 nearestTaxi.clear();
				 }
		 }
	  }
	if(nearestTaxi.size()!=0) {
		nearest=lowestEarning(nearestTaxi);
	}
	return nearest;
  }
  public Taxi lowestEarning(ArrayList<Taxi> lis) {
	  int min=Integer.MAX_VALUE;
	  Taxi lowest=null;
	  for(int i=0;i<lis.size();i++) {
		  int earning=(int) lis.get(i).getAmountEarned();
		  if(earning<min) {
			  min=earning;
			  lowest=lis.get(i);
		  }
	  }
	  return lowest;
  }
  public int payment(char pickUpPoint,char dropPoint) {
	  int fromPoint=points.indexOf(pickUpPoint);
	  int toPoint=points.indexOf(dropPoint);
	  int amount=50;
	  if(fromPoint>toPoint) {
		  amount=amount+(10*10);
		  for(int i=fromPoint;i>toPoint+1;i--) {
			  amount=amount+(10*15);
		  }
	  }
	  else {
		  amount=amount+(10*10);
		  for(int i=toPoint;i>fromPoint+1;i--) {
			  amount=amount+(10*15);
		  }
	  }
	  return amount;
  }
  public void changeStatus(int taxiNo) {
	  for(int i=0;i<taxi.size();i++) {
		  if(taxi.get(i).getTaxiNo()==taxiNo) {
			  taxi.get(i).setAvailable(true);
		  }
	  }
  }
  public void printHistory() {
	  String string="";
	  
	  for(int i=0;i<taxi.size();i++) {
		  Taxi t=taxi.get(i);
		  List<TaxiHistory> l=taxiHistory.get(t.getTaxiNo());
		  string+="Traval History of "+t.getTaxiNo()+":\n";
		  if(l.size()==0) {
			  string+="No travels\n";
		  }
		  else {
			
		  }
		  
	  }
	  //return taxiHistory;
  }
  int customerId=0;
  public int generatCustomerId() {
	  return ++customerId;
  }
}
