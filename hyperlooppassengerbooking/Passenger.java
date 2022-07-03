package hyperlooppassengerbooking;

public class Passenger {

	private String name;
	private int age;
	private char destination;
	private String fastestRoute;
	
	
	
	public String getFastestRoute() {
		return fastestRoute;
	}
	public void setFastestRoute(String fastestRoute) {
		this.fastestRoute = fastestRoute;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public char getDestination() {
		return destination;
	}
	public void setDestination(char destination) {
		this.destination = destination;
	}
	@Override
	public String toString() {
		return "" + name +"\t"+  fastestRoute + "";
	}
	
	
}
