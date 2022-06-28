package calltaxibooking;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


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
  public String taxiBooking(char pickUpPoint,char dropPoint,float pickUpTime,float dropTime,int customerId,int bookingType,int amount) {
	  if(pickUpPoint<'A'||pickUpPoint>'F'||dropPoint<'A'||dropPoint>'F') {
		  return "Not Available";
	  }
	  List<Taxi> availableTaxi=new ArrayList<>();
	  for(int i=0;i<taxi.size();i++) {
		  if(availableTimeForPickUp(pickUpPoint,pickUpTime,taxi.get(i))){
			  availableTaxi.add(taxi.get(i));
		  }
	  }
	  if(availableTaxi.size()==0) {
		  return "All taxi Busy,Booking Rejected";
	  }
	  Taxi nearestTaxi=nearestTaxi(availableTaxi,pickUpPoint);
	  nearestTaxi.setFreeTime(dropTime);
	  nearestTaxi.setCurrentPosition(dropPoint);
	  double earned=nearestTaxi.getAmountEarned();
	  nearestTaxi.setAmountEarned(earned+amount);
	  TaxiHistory taxiHistory=historySetter(pickUpPoint,dropPoint,pickUpTime,dropTime,amount,customerId,bookingType);
	  addHistory(taxiHistory,nearestTaxi);
	  return "Booked Successfully\nalotted Taxi is Taxi_"+nearestTaxi.getTaxiNo()+"\n";
	  
  }
  public void addHistory(TaxiHistory taxiHistor,Taxi nearestTaxi) {
	  List<TaxiHistory> lis=taxiHistory.get(nearestTaxi.getTaxiNo());
	  if(lis==null) {
		  lis=new ArrayList<>();
		  taxiHistory.put(nearestTaxi.getTaxiNo(), lis);
	  }
	  lis.add(taxiHistor);
  }
  public TaxiHistory historySetter(char pickUpPoint,char dropPoint,float pickUpTime,float dropTime,int amount,int custoerId,int bookingType) {
	  TaxiHistory taxiHistory=new TaxiHistory();
	  taxiHistory.setBookingId(custoerId);
	  taxiHistory.setCustomerId(custoerId);
	  taxiHistory.setPickUpPoint(pickUpPoint);
	  taxiHistory.setDropPoint(dropPoint);
	  taxiHistory.setBookingType(bookingType);
	  taxiHistory.setAmount(amount);
	  taxiHistory.setPickUpTime(pickUpTime);
	  taxiHistory.setDropTime(dropTime);
	  return taxiHistory;
  }
  public boolean availableTimeForPickUp(char pickUpPoint,float pickUpTime,Taxi taxiObj) {
	 float freeTime=taxiObj.getFreeTime();
//	 int toPoint=pickUpPoint;
//	  long reachTime=0;
//	 if(fromPoint>toPoint) {
//		 for(int i=fromPoint;i>toPoint;i--) {
//			 reachTime+=900000;
//		 }
//	 }
//	 else {
//		 for(int i=toPoint;i>fromPoint;i--) {
//			 reachTime+=900000;
//		 }
//	 }
	 if(pickUpTime<freeTime) {
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
//  public void changeStatus(int taxiNo) {
//	  for(int i=0;i<taxi.size();i++) {
//		  if(taxi.get(i).getTaxiNo()==taxiNo) {
//			  taxi.get(i).setAvailable(true);
//		  }
//	  }
//  }
  public String printHistory() {
	  String string="";
	  
	  Set<Integer> taxiNo=taxiHistory.keySet();
	  for(int taxiNumber:taxiNo) {
		 
		  List<TaxiHistory> l=taxiHistory.get(taxiNumber);
		  string+="Traval History of "+taxiNumber+":\n";
		    string+="Booking Id\t\tstart point\t\tend point\t\tstartTime\t\tDrop Time\t\tBookingType\t\tCharges\n";
			for(int k=0;k<l.size();k++) {
			string+=l.get(k).getBookingId()+"\t\t\t"+l.get(k).getPickUpPoint()+"\t\t\t"+l.get(k).getDropPoint()+"\t\t\t"+l.get(k).getPickUpTime()+"\t\t\t"+l.get(k).getDropTime()+"\t\t\t"+l.get(k).getBookingType()+"\t\t\t"+l.get(k).getAmount()+"\n";
			}
		
		  
	  }
	  return string;
  }
  public String time(long time) {
	  SimpleDateFormat si=new SimpleDateFormat("hh:mm");
	  Date date=new Date(time);
	 return  si.format(date);
  }

  int customerId=0;
  public int generatCustomerId() {
	  return ++customerId;
  }
  public boolean isShareBooking(char pickUp,char drop) {
	  int differance=Math.abs(pickUp-drop);
	  if(differance>2) {
		  return true;
	  }
	  return false;
  }
  public Float calculateDropTime(float pickUpTime,int dropTime) {
	  float ans=0.00f;
	  float k=dropTime/60;
	  ans=ans+k;
	  float h=dropTime%60;
	  float j=h/100;
	  ans=ans+j;
	  ans=pickUpTime+ans;
	  return ans;
  }
}
