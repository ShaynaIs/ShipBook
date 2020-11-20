package ships;

import java.time.*;

import ships.Address;
public class Person {
	private String firstName;
	private String lastName; 
	private Gender gender;
	private LocalDate birthdate;
	private Address address;
	
	//constructors
	public Person(String firstName, String lastName, Gender gender, Address address, String birthdate) {
		this(firstName, lastName, gender, address, LocalDate.parse(birthdate));
	}
	
	public Person(String firstName, String lastName, Gender gender, String street, String city, String state, String zipcode, String birthdate) {
		this(firstName, lastName, gender, new Address(street, city, state, zipcode), LocalDate.parse(birthdate));
	}
	
	//main constructor
	public Person(String firstName, String lastName, Gender gender, Address address, LocalDate birthdate) {
		this.firstName = firstName;
		this.lastName = lastName; 
		this.gender = gender;
		this.address = new Address(address);
		this.birthdate = birthdate;
		
	}
	
	//copy constructor
	public Person(Person p) {
		this(p.firstName, p.lastName, p.gender, p.address, p.birthdate);
	}
	
	//getters
	public String getFirstName() {
		return firstName;
	}
	
	public String getLastName() {
		return lastName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public Address getAddress() {
		return new Address(address);
	}
	
	public LocalDate getBirthdate() {
		return birthdate;
	}
	
	//setters
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public void setAddress(Address address) {
		this.address = new Address(address);
	}
	
	//toString method
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nFirst name: " + firstName);
		str.append("\nLast name: " + lastName);
		str.append("\nGender: " + gender);
		str.append("\nAddress: " + address.toString());
		str.append("\nDOB: " + birthdate);
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
		Person other = (Person)obj;
		if(firstName==null) {
			if(other.firstName!=null) {
				return false;
			}
		}
		else if(!firstName.equals(other.firstName)) {
			return false;
		}
		if(lastName==null) {
			if(other.lastName!=null) {
				return false;
			}
		}
		else if(!lastName.equals(other.lastName)) {
			return false;
		}
		if(birthdate==null) {
			if(other.birthdate!=null) {
				return false;
			}
		}
		else if(!birthdate.equals(other.birthdate)) {
			return false;
		}
		
		return true;
	}
	
	
}

