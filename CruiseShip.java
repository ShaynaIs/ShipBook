package ships;

import java.util.*;

public class CruiseShip extends Ship{
	private int maxAmntPassengers;
	private ArrayList <Passenger> passengers;
	
	//constructors
	public CruiseShip(ArrayList<Passenger>passengers) {
		this(null,0,0,passengers);
	}
	
	public CruiseShip(int maxAmntPassengers, ArrayList<Passenger>passengers) {
		this(null,0,maxAmntPassengers, passengers);
	}
	
	//main constructor
	public CruiseShip(String name, int year, int maxAmntPassengers, ArrayList<Passenger> passengers) {
		super(name, year);
		if(maxAmntPassengers<0) {
			throw new IllegalArgumentException("Invalid amount of passengers.");
		}
		this.maxAmntPassengers = maxAmntPassengers;
		if(passengers.size()>maxAmntPassengers) {
			throw new IllegalArgumentException("Amount of passengers cannot be greater than max amount allowed.");
		}
		ArrayList<Passenger>pass = new ArrayList<>();
		for(Passenger p:passengers) {
			pass.add(p);
		}
		this.passengers = pass;
		
	}
	
	//setters
	public void setMaxAmntPassengers(int maxAmntPassengers) {
		if(maxAmntPassengers<0) {
			throw new IllegalArgumentException("Invalid amount of passengers.");
		}
		this.maxAmntPassengers = maxAmntPassengers;
	}
	
	public void setMaxAmntPassengers(double maxAmntPassengers) {
		this.setMaxAmntPassengers((int)maxAmntPassengers);
	}
	
	public void setMaxAmntPassengers(String maxAmntPassengers) {
		this.setMaxAmntPassengers(Integer.parseInt(maxAmntPassengers));
	}
	
	public void setPassengers(ArrayList<Passenger>passengers) {
		ArrayList<Passenger>pass = new ArrayList<>();
		for(Passenger p:passengers) {
			pass.add(p);
		}
		this.passengers = pass;
	}
	//method to add a passenger
	public void addPassenger(Passenger p) {
		//send to passenger class's equals method
		if(!passengers.contains(p) && passengers.size()<maxAmntPassengers) {
			passengers.add(p);
		}
		else {
			throw new PassengerExistsException();
		}
	}
	
	//getters
	public int getMaxAmntPassengers() {
		return maxAmntPassengers;
	}
	
	public ArrayList<Passenger> getPassengerList(){
		ArrayList<Passenger> passengerList = new ArrayList<Passenger>();
		for(Passenger passenger:passengers) {
			passengerList.add(passenger);
		}
		return passengerList;
	}
	
	//toString method
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nMax amount of passengers: " + maxAmntPassengers);
		for(int n=0; n<passengers.size(); n++) {
			str.append("\n\nPassenger #" + (n+1) + ": " + passengers.get(n));
		}
		return str.toString();
	}
	
	
}
