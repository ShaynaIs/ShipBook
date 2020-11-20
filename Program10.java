package ships;


import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;

import ships.Address;
public class Program10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner (System.in);
		int choice=0;
		System.out.print("Hey there, sailor.\nWhat's your name? ");
		String name = keyboard.nextLine();
		System.out.println("\nAhoy, " + name + "! \nNeed somewhere to store all your ship info?\nYou came aboard the right place.");
		//offer use to choose which type of ship to input info about first
		do {
		System.out.print("\nEnter '1' to first give info about cargo ships,\nenter '2' to first give info about cruise ships: ");
			try {
				choice = keyboard.nextInt();
				if(choice != 1 && choice != 2) {
					System.out.println("\nSon of biscuit eater! Try and follow the directions, will ye?");
				}
			}
			catch(InputMismatchException e) {
				System.out.println("\nOnly use numeric values, ye scallywag. Re-enter choice.");
				keyboard.nextLine();
			}
		}while(choice!=1 && choice!=2);
		//create arrayLists for ships
		ArrayList<CargoShip> cargoShips = new ArrayList<CargoShip>();
		ArrayList<CruiseShip> cruiseShips = new ArrayList<CruiseShip>();
		switch(choice) {
			case 1: 
				cargoShipInfo(keyboard, cargoShips);
				cruiseShipInfo(keyboard, cruiseShips);
				break;
			case 2: 
				cruiseShipInfo(keyboard, cruiseShips);
				cargoShipInfo(keyboard, cargoShips);
				break;
		}
		
		int option=0;
		//offer user to choose an option from the menu
		do {
		System.out.println("\nNow that you have entered in all of your information, you can"
				+ "\n1. Display Cargo Ships info and/or add a cargo ship.\n2. Display Cruise Ships info and/or add a cruise ship."
				+ "\n3. Add a passenger to a cruise ship.\n4. Quit the program.");
		do {
		System.out.print("Choose an option from the menu: ");
		try {
			option = keyboard.nextInt();
			if(option!=1 && option!=2 && option!=3 && option!=4) {
				System.out.println("Blimey! Try and follow the directions this time round.");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Only use one of the numeric values listed, ye scallywag. Re-enter choice.");
			option=0;
			keyboard.nextLine();
		}
		}while(option!=1 && option!=2 && option!=3 && option!=4);
		
		switch(option) {
			case 1: 
				displayCargo(cargoShips, keyboard);
				break;
			case 2: 
				displayCruise(cruiseShips, keyboard);
				break;
			case 3: 
				addPassenger(cruiseShips, keyboard);
				break;
		}
		}while(option!=4);
		System.out.println("\nYou have chosen to quit the program. 'Till next time, matey!");
		System.exit(0);
		
	}
	
	private static void addPassenger(ArrayList<CruiseShip> cruiseShips, Scanner keyboard) {
		// TODO Auto-generated method stub
		int choice=0; 
		String name = null;
		int n=0;
		//check if there are any cruise ships listed, if yes, ask for name of ship top add passengers to 
		do {
			if(cruiseShips.size()==0) {
				System.out.println("\nYou have no cruise ships listed to add passengers.");
			}
		else{
			keyboard.nextLine();
			System.out.println("\nThese are the cruise ships you have listed:");
			for(int s=0; s<cruiseShips.size(); s++) {
				System.out.println("\t-" + cruiseShips.get(s).getName());
			}
			System.out.print("\nEnter the name of the cruise ship that you would like to add a passenger/s to: ");
			name = keyboard.nextLine();
		}
		//check if ship exists
		for(int m=0; m<cruiseShips.size(); m++) {
			if(!cruiseShips.get(m).getName().equalsIgnoreCase(name)) {
				if(m==cruiseShips.size()-1) {
					System.out.println("Well, will ye blow me down.\nWe just gave you a list and yet the cruise ship name entered does not exist.\nTry again there, matey.");
				}
			}
			else{
				m=cruiseShips.size();
		
		//check how many spots are available on ship, if there are - ask how many passengers user wants to add
		for(n=0; n<cruiseShips.size(); n++) {
			if(cruiseShips.get(n).getName().equalsIgnoreCase(name)) {
				System.out.println("This ship allows a maximum of " + cruiseShips.get(n).getMaxAmntPassengers() + " passengers.");
				int left = cruiseShips.get(n).getMaxAmntPassengers() - cruiseShips.get(n).getPassengerList().size();
				System.out.println("You have " + left + " spots left.");
				int amnt=0;
				System.out.println("\nHow many passengers would you like to add to the cruise ship?");
				do {
					System.out.print("Enter amount: ");
					try {
					amnt = keyboard.nextInt();
					if(amnt>left) {
						System.out.println("Why, ye can't have more passengers than you have space for!");
					}
					if(amnt<0) {
						System.out.println("Ahoy there, ye can't add a negative amount of passengers to yer ship.");
					}
					}
					catch(IllegalArgumentException | InputMismatchException e) {
						System.out.println("Only use positive numeric values, ye scallywag.");
						keyboard.nextLine();
					}
				}while(amnt>left || amnt<0);
				keyboard.nextLine();
				for(int i=0; i<amnt; i++) {
					int luggagePieces=-1;
					System.out.println("\nEnter information for passenger #" + (i+1) + ": ");
					System.out.print("First name: ");
					String firstName = keyboard.nextLine();
					System.out.print("Last name: ");
					String lastName = keyboard.nextLine();
					String gen = null;
					do {
						System.out.print("Gender (M/F): ");
						gen = keyboard.nextLine().toUpperCase();
					}while(!gen.equals("F") && !gen.equals("M"));
					Gender gender = Gender.valueOf(gen);
					System.out.println("\nAddress information. ");
					System.out.print("\tStreet: ");
					String street = keyboard.nextLine();
					System.out.print("\tCity: ");
					String city = keyboard.nextLine();
					System.out.print("\tState: ");
					String state = keyboard.nextLine();
					System.out.print("\tZipcode: ");
					String zipcode = keyboard.nextLine();
					System.out.print("\nDOB(ex. 2000-01-01 y/m/d): ");
					String birthdate = null;
					boolean date = true;
					do {
					birthdate = keyboard.nextLine();
						try {
							LocalDate.parse(birthdate);
							date=true;
						}
						catch(DateTimeParseException e) {
							System.out.print("Invalid date entered.\nRe-enter DOB: ");
							date=false;
						}
					}while(date==false);
					System.out.print("Passport ID: ");
					String passportID = keyboard.nextLine();
					do {
						System.out.print("Pieces of luggage: ");
						try {
						luggagePieces = keyboard.nextInt();
						if(luggagePieces<0) {
							System.out.println("Ho! I don't think a passenger can have a negative amount of luggage.");
						}
						}
						catch(IllegalArgumentException | InputMismatchException e) {
							System.out.println("Only use positive numeric values, ye scallywag.");
							keyboard.nextLine();
						}
					}while(luggagePieces<0);
					keyboard.nextLine();
					Passenger pass1 = new Passenger(firstName, lastName, gender, new Address(street, city, state, zipcode), birthdate, passportID, luggagePieces);
					try {
						cruiseShips.get(n).addPassenger(pass1);
					}
					catch(PassengerExistsException e) {
						System.out.println(e.getMessage());
						i--;
					}
				}
				n=cruiseShips.size();
			}
		}
			}
		}
		//if there are no cruise ships listed - return user to menu
		if(cruiseShips.size()==0) {
			System.out.println("You will now return to the menu.");
		}
		//offer user to enter another ship name or return to the menu
		else{
			do {
			System.out.print("\nEnter '1' to enter another ship's name to add passengers to.\nEnter any other positive number to return to the menu: ");
			try {
			choice = keyboard.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("Only use positive numeric values, ye scallywag. Re-enter choice.");
				keyboard.nextLine();
				choice=-1;
			}
			}while(choice==-1);
		}
		}while(choice==1);
	}

	private static void displayCruise(ArrayList<CruiseShip> cruiseShips, Scanner keyboard) {
		// TODO Auto-generated method stub
		//attempt to display cruise ship info
		System.out.println("\nCruise Ships information:");
		//if there are no cruise ships listed
		if(cruiseShips.size()==0) {
			System.out.println("You have no cruise ships listed.");
		}
		//display info
		for(int n=0; n<cruiseShips.size(); n++) {
			System.out.println("\nCruise Ship #" + (n+1) + ": " + cruiseShips.get(n));
		}
		int option=0;
		//offer use to add a cruise ship or return to menu
		do {
		System.out.print("\nTo add another cruise ship, enter '1'. \nTo return to menu, enter '2': ");
		try {
		option = keyboard.nextInt();
		}
		catch(InputMismatchException e){
			System.out.println("Only use numeric values, ye scallywag.\nRe-enter choice.");
			keyboard.nextLine();
		}
		}while(option!=1 && option!=2);
		if(option==1) {
			cruiseShipInfo(keyboard, cruiseShips);
		}
	}

	private static void displayCargo(ArrayList<CargoShip> cargoShips, Scanner keyboard) {
		// TODO Auto-generated method stub
		//attempt to display cargo ship info
		System.out.println("\nCargo Ships information:");
		//if there are no cargo ships listed
		if(cargoShips.size()==0) {
			System.out.println("You have no cargo ships listed.");
		}
		//display info
		for(int n=0; n<cargoShips.size(); n++) {
			System.out.println("\nCargo Ship #" + (n+1) + ": " + cargoShips.get(n));
		}
		int option=0;
		//offer use to add a cargo ship or return to menu
		do {
		System.out.print("\nTo add another cargo ship, enter '1'. \nTo return to menu, '2': ");
		try {
		option = keyboard.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.print("Only use numeric values, ye scallywag.\nRe-enter choice: ");
			keyboard.nextLine();
		}
		}while(option!=1 && option!=2);
		if(option==1) {
			cargoShipInfo(keyboard, cargoShips);
		}
	}

	public static void cargoShipInfo(Scanner keyboard, ArrayList<CargoShip>cargoShips) {
		//add cargo ships to arrayList
		System.out.println("\nCargo Ships:");
		int amntCargo=-1;
		do {
			System.out.print("Amount of cargo ships: ");
		try {
			amntCargo = keyboard.nextInt();
			if(amntCargo<0) {
				System.out.println("Sink me! Ye know ye can't own less than 0 of something. (Or at least I hope ye know...)");
			}
		}
		catch(InputMismatchException e) {
			System.out.println("Only use positive numeric values, ye scallywag.");
			keyboard.nextLine();
		}
		}while(amntCargo<0);
		
		keyboard.nextLine();
		for(int n=0; n<amntCargo; n++) {
			int cargoYear = -1;
			int cargoCap = -1;
			String cargoName = null;
			boolean checkName = false;
			System.out.println("\nCargo Ship #" + (n+1) + ": ");
			do {
				checkName = false;
				System.out.print("Name: ");
				cargoName = keyboard.nextLine();
				for(int i=0; i<cargoShips.size(); i++) {
					if(cargoShips.get(i).getName().equalsIgnoreCase(cargoName)) {
						System.out.println("A cargo ship with that name already exists.\nIf you so desire for it to be similarly named, you can re-enter it as " + cargoName + " 2.0");
						checkName = true;
					}
				}
			}while(checkName == true);
			do {
				System.out.print("Year made: ");
				try {
					cargoYear = keyboard.nextInt();
					if(cargoYear>LocalDate.now().getYear()) {
						System.out.println("Shiver me timbers! When did you learn to time travel?");
					}
					if(cargoYear<0) {
						System.out.println("You a bit squiffy? Cause ye can't have a negative year.");
					}
				}
				catch (IllegalArgumentException | InputMismatchException e) {
					System.out.println("Only use positive numeric values, ye scallywag.");
					keyboard.nextLine();
				}
			}while(cargoYear<0 || cargoYear>LocalDate.now().getYear());
			
			do {
				System.out.print("Cargo capacity in tonnage: ");
				try {
					cargoCap = keyboard.nextInt();
					if(cargoCap<0) {
						System.out.println("Are you running a rig? We're at sea, not on the moon.");
					}
				}
				catch(IllegalArgumentException | InputMismatchException e) {
					System.out.println("Only use positive numeric values, ye scallywag.");
					keyboard.nextLine();
				}
			}while(cargoCap<0);
			cargoShips.add(new CargoShip(cargoName, cargoYear, cargoCap));
			keyboard.nextLine();
		}
	}

	public static void cruiseShipInfo(Scanner keyboard, ArrayList<CruiseShip> cruiseShips) {
		//add cruise ship to arrayList
		System.out.println("\nCruise Ships:");
		int amntCruise=-1;
		do {
			System.out.print("Amount of cruise ships: ");
			try {
			amntCruise = keyboard.nextInt();
			if(amntCruise<0) {
				System.out.println("Sink me! Ye know ye can't own less than 0 of something. (Or at least I hope ye know...)");
			}
			}
			catch(InputMismatchException e) {
				System.out.println("Only use positive numeric values, ye scallywag.");
				keyboard.nextLine();
			}
		}while(amntCruise<0);
		
		keyboard.nextLine();
		for(int i=0; i<amntCruise; i++) {
			int year=-1;
			int maxAmntPass=-1;
			boolean checkName = false;
			String name = null;
			System.out.println("\nCruise Ship #" + (i+1));
			//check if ship with that name already exists
			do {
			checkName = false;
			System.out.print("Name: ");
			name = keyboard.nextLine();
			for(int n=0; n<cruiseShips.size(); n++) {
				if(cruiseShips.get(n).getName().equalsIgnoreCase(name)) {
					System.out.println("A cruise ship with that name already exists.\nIf you so desire for it to be similarly named, you can re-enter it as " + name + " 2.0");
					checkName=true;
				}
			}
			}while(checkName==true);
			do {
				System.out.print("Year made: ");
				try {
				year = keyboard.nextInt();
				if(year>LocalDate.now().getYear()) {
					System.out.println("Shiver me timbers! When did you learn to time travel?");
				}
				if(year<0) {
					System.out.println("You a bit squiffy? Cause ye can't have a negative year.");
				}
				}
				catch(IllegalArgumentException | InputMismatchException e) {
					System.out.println("Only use numeric values, ye scallywag.");
					keyboard.nextLine();
				}
			}while(year<0 || year>LocalDate.now().getYear());
			do {
				System.out.print("Max amount of passengers: ");
				try {
				maxAmntPass = keyboard.nextInt();
				if(maxAmntPass<0) {
					System.out.println("Blimey! Doesn't every ship have space for at least 1?\nDefinitely, can't be a negative amount then.");
				}
				}
				catch(IllegalArgumentException | InputMismatchException e) {
					System.out.println("Only use numeric values, ye scallywag.");
					keyboard.nextLine();
				}
			}while(maxAmntPass<0);
			keyboard.nextLine();
			ArrayList<Passenger>passengers = new ArrayList<>();
			cruiseShips.add(new CruiseShip(name,year,maxAmntPass,passengers));
		}
	}
}
