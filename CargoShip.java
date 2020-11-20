package ships;


public class CargoShip extends Ship{
	private int cargoCap;
	
	public CargoShip() {
		this(null, 0, 0);
	}
	
	public CargoShip(int cargoCap) {
		this(null, 0, cargoCap);
	}

	public CargoShip(String name, int year, int cargoCap) {
		super(name, year);
		if(cargoCap<0) {
			throw new IllegalArgumentException("Invalid amount of cargo capacity.");
		}
		this.cargoCap = cargoCap;
	}
	
	public CargoShip(CargoShip c) {
		super(c);
		this.cargoCap = c.cargoCap;
	}
	
	public void setCargoCap(int cargoCap) {
		if(cargoCap<0) {
			throw new IllegalArgumentException("Invalid amount of cargo capacity.");
		}
		this.cargoCap = cargoCap;
	}
	
	public int getCargoCap() {
		return cargoCap;
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("\nName: " + super.getName());
		str.append("\nCargo capacity in tonnage: " + cargoCap);
		return str.toString();
	}
	
}
