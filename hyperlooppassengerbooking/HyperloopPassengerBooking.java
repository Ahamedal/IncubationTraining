package hyperlooppassengerbooking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class HyperloopPassengerBooking {

	Map<Character,Map<Character,Integer>> connectingRoutes=new HashMap<>();
	Map<Integer,List<Passenger>> passengers=new TreeMap<>();
	
	
	public void initialSetUp() {
		addConnectingRoutes('A','B',3);
		addConnectingRoutes('A','C',7);
		addConnectingRoutes('B','D',2);
		addConnectingRoutes('B','C',2);
		addConnectingRoutes('B','E',5);
		addConnectingRoutes('C','E',1);
		addConnectingRoutes('D','E',3);
	}
	public void addConnectingRoutes(char startingPoint,char endingPoint,int distance) {
		
		Map<Character,Integer> route=connectingRoutes.get(startingPoint);
		if(route==null) {
			route=new HashMap<>();
			connectingRoutes.put(startingPoint, route);
		}
		route.put(endingPoint,distance);
	}
	
	public void addPassenger(Passenger passenger) {
		List<Passenger> listOfPassenger=passengers.get(passenger.getAge());
		if(listOfPassenger==null) {
			listOfPassenger=new ArrayList<>();
			passengers.put(passenger.getAge(), listOfPassenger);
		}
		listOfPassenger.add(passenger);
	
	}
	
	public void getRoutes(char start,char end,int dis,String string,Map<Integer,String> ans) throws Exception {
		stringCheck(string);
		objectCheck(ans);
		if(start==end) {
			ans.put(dis, string);
    		return;
    		
    	}
	    
	    Map<Character,Integer> routes=connectingRoutes.get(start);
	    if(routes==null) {
	    	return;
	    }
	    Set<Character> point=routes.keySet();
	    for(char p:point) {
	    	string+=" "+p;
	    	dis+=routes.get(p);
	    	
	    	getRoutes(p,end,dis,string,ans);      //recursive call
	    	
	    	dis-=routes.get(p);
	    	string=string.replace(p+"", "");
	    }
	    
	
	}
	public void forCommandAddPassenger(String name,int age,char destination,char startingPoint) throws Exception {
		stringCheck(name);
		Passenger passenger=new Passenger();
		passenger.setName(name);
		passenger.setAge(age);
		passenger.setDestination(destination);
		Map<Integer,String> fastestRoute=new TreeMap<>();
		getRoutes(startingPoint,destination,0,String.valueOf(startingPoint),fastestRoute);
		Set<Integer> routes=fastestRoute.keySet();
		for(int route:routes) {
			passenger.setFastestRoute(fastestRoute.get(route));
			break;
		}
		addPassenger(passenger);
	}
	public List<Passenger> forCommandStartPOD(int size) throws Exception{
		List<Passenger> selectPassenger=new ArrayList<>();
		Set<Integer> ages= passengers.keySet();
		List<Integer> temp=new ArrayList<>();
		temp.addAll(ages);
		
		int j=0;
		int l=1;
		while(true) {
			if(selectPassenger.size()==size||passengers.size()==0) {
				break;
			}
		List<Passenger> passenger=passengers.get(temp.get(temp.size()-l));
		
		for(int i=0;i<passenger.size();i++) {
			if(j==size) {
				break;
			}
			selectPassenger.add(passenger.get(i));
			remove(passenger.get(i));
			j++;
		
		}
		l++;
		}
		
		return selectPassenger;
	}
	public void remove(Passenger passenger) throws Exception {
            objectCheck(passenger);
			List<Passenger> pass=passengers.get(passenger.getAge());
			pass.remove(passenger);
			if(pass.size()==0) {
				passengers.remove(passenger.getAge());
				
			}
		
	}
	public List<Passenger> forCommandPrintQ() {
		List<Passenger> passengerList=new ArrayList<>();
		Set<Integer> ages=passengers.keySet();
		for(int age:ages) {
			List<Passenger> pass=passengers.get(age);
			if(pass.size()!=0) {
			passengerList.addAll(pass);
			}
		}
		return passengerList;
	}
	
    private void stringCheck(String string) throws Exception {
    	if(string==null||string.isEmpty()) {
    		throw new Exception("String cannot be null or empty");
    	}
    }
    private void objectCheck(Object object) throws Exception {
    	if(object==null) {
    		throw new Exception("String cannot be null or empty");
    	}
    }
	
}
