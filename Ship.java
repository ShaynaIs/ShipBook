package ships;

import java.time.LocalDate;

public class Ship {
	private String name;
	private int year;

	//constructors
	public Ship() {
		this(null,0);
	}

	public Ship(String name) {
		this(name,0);
	}
	
	public Ship(int year) {
		this(null, year);
	}
	
	public Ship(String name, String year) {
		this(name, Integer.parseInt(year));
	}
	
	public Ship(double year) {
		this(null,(int)year);
	}
	
	public Ship(String name, double year) {
		this(name, (int)year);
	}
	
	//main constructor
	public Ship(String name, int year) {
		this.name = name;
		if(year<0 || year>LocalDate.now().getYear()) {
			throw new IllegalArgumentException ("\nMust be a valid year.");
		}
		this.year = year;
	}
	
	//copy constructor
	public Ship(Ship s) {
		this(s.name, s.year);
	}
	
	//setters
	public void setName(String name) {
		this.name = name;
	}
	
	public void setYear(String year) {
		this.setYear(Integer.parseInt(year));
	}
	
	public void setYear(double year) {
		this.setYear((int)year);
	}
	
	public void setYear(int year) {
		if(year<0 || year>LocalDate.now().getYear()) {
			throw new IllegalArgumentException("\nMust be a valid year."); 
		}
		this.year = year;
	}
	
	//getters
	public String getName() {
		return name;
	}
	
	public int getYear() {
		return year;
	}
	
	//toString method
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nShip name: " + name);
		str.append("\nYear made: " + year);
		return str.toString();
	}
	}