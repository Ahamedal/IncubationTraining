package calltaxibooking;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CallTaxiBooking {

	List<Taxi> taxi = new ArrayList<>();
	List<Character> points = new ArrayList<>();
	Map<Integer, ShareBooking> shareBooking = new HashMap<>();
	Map<Integer, List<TaxiHistory>> taxiHistory = new HashMap<>();
	int taxiNo = 0;
	int bookingId = 0;

	public void addPoints() {
		points.add('A');
		points.add('B');
		points.add('C');
		points.add('D');
		points.add('E');

	}

	public void addTaxi(Taxi taxDetails) throws Exception {
		objectCheck(taxDetails);
		taxDetails.setTaxiNo(++taxiNo);
		taxi.add(taxDetails);
	}

	public String taxiBooking(char pickUpPoint, char dropPoint, double pickUpTime, double dropTime, int customerId,
			int bookingType, int amount, boolean flag) throws Exception {
		if (pickUpPoint < 'A' || pickUpPoint > 'F' || dropPoint < 'A' || dropPoint > 'F') {
			return "Not Available";
		}
		List<Taxi> availableTaxi = new ArrayList<>();
		for (int i = 0; i < taxi.size(); i++) {
			if (availableTimeForPickUp(pickUpPoint, pickUpTime, taxi.get(i))) {
				availableTaxi.add(taxi.get(i));
			}
		}
		if (availableTaxi.size() == 0) {
			return "All taxi Busy,Booking Rejected";
		}

		Taxi nearestTaxi = nearestTaxi(availableTaxi, pickUpPoint);
		nearestTaxi.setFreeTime(dropTime);
		bookingId++;
		if (flag) {
			ShareBooking share = new ShareBooking();
			share.setAvailableSpace(share.getAvailableSpace() - 1);
			share.setPickUpPoint(pickUpPoint);
			share.setDropPoint(dropPoint);
			share.setBookingId(bookingId);
			Map<Character, Double> availablePoint = share.getAvalaibleShare();
			addAvailablePoint(availablePoint, pickUpPoint, dropPoint, pickUpTime);
			shareBooking.put(nearestTaxi.getTaxiNo(), share);
		}

		nearestTaxi.setCurrentPosition(dropPoint);
		double earned = nearestTaxi.getAmountEarned();
		nearestTaxi.setAmountEarned(earned + amount);

		TaxiHistory taxiHistory = historySetter(pickUpPoint, dropPoint, pickUpTime, dropTime, amount, customerId,
				bookingType, bookingId);
		addHistory(taxiHistory, nearestTaxi);
		return "Booked Successfully\nYour booking Id is " + bookingId + " alotted Taxi is Taxi_"
				+ nearestTaxi.getTaxiNo() + "\n";

	}

	public void addHistory(TaxiHistory taxiHistor, Taxi nearestTaxi) throws Exception {
		objectCheck(taxiHistor);
		objectCheck(nearestTaxi);
		List<TaxiHistory> lis = taxiHistory.get(nearestTaxi.getTaxiNo());
		if (lis == null) {
			lis = new ArrayList<>();
			taxiHistory.put(nearestTaxi.getTaxiNo(), lis);
		}
		lis.add(taxiHistor);
	}

	public TaxiHistory historySetter(char pickUpPoint, char dropPoint, double pickUpTime, double dropTime, int amount,
			int custoerId, int bookingType, int bookingId) {
		TaxiHistory taxiHistory = new TaxiHistory();
		taxiHistory.setBookingId(bookingId);
		taxiHistory.setCustomerId(custoerId);
		taxiHistory.setPickUpPoint(pickUpPoint);
		taxiHistory.setDropPoint(dropPoint);
		taxiHistory.setBookingType(bookingType);
		taxiHistory.setAmount(amount);
		taxiHistory.setPickUpTime(pickUpTime);
		taxiHistory.setDropTime(dropTime);
		return taxiHistory;
	}

	public boolean availableTimeForPickUp(char pickUpPoint, double pickUpTime, Taxi taxiObj) throws Exception {
		objectCheck(taxiObj);
		double freeTime = taxiObj.getFreeTime();

		if (pickUpTime < freeTime) {
			return false;
		}
		return true;
	}

	public Taxi nearestTaxi(List<Taxi> lis, char pickUpPoint) throws Exception {
		objectCheck(lis);
		int min = Integer.MAX_VALUE;
		ArrayList<Taxi> nearestTaxi = new ArrayList<>();
		Taxi nearest = null;
		for (int i = 0; i < lis.size(); i++) {
			int val = Math.abs(lis.get(i).getCurrentPosition() - pickUpPoint);
			if (val <= min) {

				min = val;
				nearest = lis.get(i);
				if (min == val) {
					nearestTaxi.add(lis.get(i));
				} else {
					nearestTaxi.clear();
				}
			}
		}
		if (nearestTaxi.size() != 0) {
			nearest = lowestEarning(nearestTaxi);
		}
		return nearest;
	}

	public Taxi lowestEarning(ArrayList<Taxi> lis) throws Exception {
		objectCheck(lis);
		int min = Integer.MAX_VALUE;
		Taxi lowest = null;
		for (int i = 0; i < lis.size(); i++) {
			int earning = (int) lis.get(i).getAmountEarned();
			if (earning < min) {
				min = earning;
				lowest = lis.get(i);
			}
		}
		return lowest;
	}

	public int payment(char pickUpPoint, char dropPoint) {
		int fromPoint = points.indexOf(pickUpPoint);
		int toPoint = points.indexOf(dropPoint);
		int amount = 50;
		if (fromPoint > toPoint) {
			amount = amount + (10 * 10);
			for (int i = fromPoint; i > toPoint + 1; i--) {
				amount = amount + (10 * 15);
			}
		} else {
			amount = amount + (10 * 10);
			for (int i = toPoint; i > fromPoint + 1; i--) {
				amount = amount + (10 * 15);
			}
		}
		return amount;
	}

	public String printHistory() {
		String string = "";

		Set<Integer> taxiNo = taxiHistory.keySet();
		for (int taxiNumber : taxiNo) {

			List<TaxiHistory> l = taxiHistory.get(taxiNumber);
			string += "Traval History of " + taxiNumber + ":\n";
			string += "Booking Id\t\tstart point\t\tend point\t\tstartTime\t\tDrop Time\t\tBookingType\t\tCharges\n";
			for (int k = 0; k < l.size(); k++) {
				string += l.get(k).getBookingId() + "\t\t\t" + l.get(k).getPickUpPoint() + "\t\t\t"
						+ l.get(k).getDropPoint() + "\t\t\t" + l.get(k).getPickUpTime() + "\t\t\t"
						+ l.get(k).getDropTime() + "\t\t\t" + l.get(k).getBookingType() + "\t\t\t"
						+ l.get(k).getAmount() + "\n";
			}

		}
		return string;
	}

	public String time(long time) {
		SimpleDateFormat si = new SimpleDateFormat("hh:mm");
		Date date = new Date(time);
		return si.format(date);
	}

	int customerId = 0;

	public int generatCustomerId() {
		return ++customerId;
	}

	public boolean isShareBooking(char pickUp, char drop) {
		int differance = Math.abs(pickUp - drop);
		if (differance > 2) {
			return true;
		}
		return false;
	}

	public double calculateDropTime(double pickUpTime, int dropTime) {

		double ans = 0.00;
		double k = dropTime / 60;
		ans = ans + k;
		k = dropTime % 60;
		k = k / 100;
		ans = ans + k;

		String[] array1 = String.valueOf(ans).split("[.]");
		if (array1[1].length() == 1) {
			array1[1] += "0";
		}
		String[] array2 = String.valueOf(pickUpTime).split("[.]");
		if (array2[1].length() == 1) {
			array2[1] += "0";
		}
		int dropTime2 = Integer.parseInt(array1[1]) + Integer.parseInt(array2[1]);
		double ans1 = 0.00f;
		double k1 = dropTime2 / 60;
		ans1 = ans1 + k1;
		k1 = dropTime2 % 60;
		k1 = k1 / 100;
		ans1 = ans1 + k1;

		ans = ((int) pickUpTime) + ans1;

		return ans;
	}

	public int isShareAvailable(char pickUp, char drop, double pickUpTime) {
		Set<Integer> taxiNos = shareBooking.keySet();
		for (int taxiNo : taxiNos) {
			ShareBooking sb = shareBooking.get(taxiNo);
			if (sb.getDropPoint() == drop && sb.getAvailableSpace() != 0) {
				Map<Character, Double> availableShare = sb.getAvalaibleShare();
				if (availableShare.get(pickUp) != null && availableShare.get(pickUp) == pickUpTime) {
					return taxiNo;
				}
			}
		}
		return 0;
	}

	public void addAvailablePoint(Map<Character, Double> availableSharePoints, char pickUpPoint, char dropPoint,
			double pickUpTime) {
		if (pickUpPoint < dropPoint) {
			for (int i = pickUpPoint; i < dropPoint; i++) {

				availableSharePoints.put((char) (i), pickUpTime);
				pickUpTime = calculateDropTime(pickUpTime, 15);
			}
		} else {
			for (int i = dropPoint; i > pickUpPoint; i--) {

				availableSharePoints.put((char) (i), pickUpTime);
				pickUpTime = calculateDropTime(pickUpTime, 15);
			}
		}
	}

	public void setHistoryForShare(char pickUp, char drop, double pickUpTime, int taxiNo, int amount, int customerId,
			int bookingType) throws Exception {
		Taxi tax = taxi.get(taxiNo - 1);
		tax.setAmountEarned(tax.getAmountEarned() + amount);
		ShareBooking shareBook = shareBooking.get(tax.getTaxiNo());
		TaxiHistory taxiHistory = historySetter(pickUp, drop, pickUpTime, tax.getFreeTime(), amount, customerId,
				bookingType, shareBook.getBookingId());
		addHistory(taxiHistory, tax);

	}

	private void objectCheck(Object object) throws Exception {
		if (object == null) {
			throw new Exception("Object is cannot be null");
		}
	}
}
