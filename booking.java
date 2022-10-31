package bus_reservation;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat; 
public class Booking {
	String passengerName;
	String ID_Name;
	String ID_Number;
	int busNo;
	Date date;
	
	Booking(){
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter name of passenger: ");
		passengerName = scanner.next();
		
		Scanner scanner1 = new Scanner(System.in);
		System.out.println("The ID Card should be verified by the Head of the Institution");
		System.out.println("ID card can be AADHAR, PAN, VOTER, SMART Card or Company/School id card");
		System.out.println("Enter name of ID to submit: ");
		ID_Name = scanner1.next();
		System.out.println("NOTE: NAME IN THE ID SHOULD BE SAME AS IN THE TICKET");
		Scanner scanner11 = new Scanner(System.in);
		System.out.println("Enter the "+ID_Name+" Number");
		ID_Number = scanner11.next();
		
		System.out.println("Enter bus no: ");
		busNo = scanner11.nextInt();
		
		System.out.println("Enter date dd-mm-yyyy");
		String dateInput = scanner11.next();
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		
		try {
			date = dateFormat.parse(dateInput);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public boolean isAvailable(ArrayList<Booking> bookings, ArrayList<Bus> buses) {
		int capacity = 0;
		for(Bus bus:buses) {
			if(bus.getBusNo() == busNo)
				capacity = bus.getCapacity();
		}
		
		int booked = 0;
		for(Booking b:bookings) {
			if(b.busNo == busNo && b.date.equals(date)) {
				booked++;
			}
		}
		
		return booked<capacity?true:false;
		
	}
}