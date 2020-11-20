package ships;

import ships.Address;

public class Passenger extends Person{

	private String passportID; 
	private int luggagePieces; 
	
	//constructor
	public Passenger(String firstName, String lastName, Gender gender, Address address, String birthdate, String passportID, int luggagePieces) 
	{
		//send to parent class
		super(firstName, lastName, gender, address, birthdate);
		this.passportID = passportID;
		if(luggagePieces<0) {
			throw new IllegalArgumentException("Cannot be a negative amount.");
		}
		this.luggagePieces = luggagePieces;
	}
	
	//copy constructor
	public Passenger(Passenger pass) {
		super(pass);
		this.passportID = pass.passportID;
		this.luggagePieces = pass.luggagePieces;
	}
	

	//toString method
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(super.toString());
		str.append("\nPassport ID: " + passportID);
		str.append("\nAmount of luggage: " + luggagePieces);
		return str.toString();
	}
	
	//equals method
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		if(obj==null) {
			return false;
		}
		if(getClass()!=obj.getClass()) {
			return false;
		}
		Passenger other = (Passenger)obj;
		if(passportID==null) {
			if(other.passportID!=null) {
				return false;
			}
		}
		else if(!passportID.equals(other.passportID)) {
			return false;
		}
		return true;
	}

}
