import java.util.ArrayList;

public class AnimalHotel {

	private ArrayList<Animal> animalHotel;

	/**
	 * main constructor, initializes the arraylist for the hotel
	 */
	public AnimalHotel() {
		super();
		animalHotel = new ArrayList<Animal>();
	}

	/**
	 * adds an animal object to the hotel.
	 * 
	 * @param newAnimal an animal (or subtype) object to be added to the hotel
	 */
	public void addAnimal(Animal newAnimal) {
		if (newAnimal != null) {
			animalHotel.add(newAnimal);
		}
	}

	/**
	 * displays all info for all guests using the DISPLAY method.
	 */
	public void displayGuests() {
		if (animalHotel != null) {
			for (Animal index : animalHotel) {
				index.display();
			}
		}
	}

}
