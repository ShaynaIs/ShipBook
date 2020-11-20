package ships;


public class Address {
	private String street;
	private String city; 
	private String state;
	private String zipcode;

	//constructor
	public Address(String street, String city, String state, String zipcode) {
		this.street = street;
		this.city = city; 
		this.state = state; 
		this.zipcode = zipcode;
	}
	
	//copy constructor
	public Address(Address a) {
		this(a.street, a.city, a.state, a.zipcode);
	}

	//getters
	public String getStreet() {
		return street;
	}
	
	public String getCity() {
		return city;
	}
	
	public String getState() {
		return state;
	}
	
	public String getZipcode() {
		return zipcode;
	}
	
	//toString method
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nStreet: " + street);
		str.append("\nCity: " + city);
		str.append("\nState: " + state);
		str.append("\nZipcode: " + zipcode);
		return str.toString();
	}

}