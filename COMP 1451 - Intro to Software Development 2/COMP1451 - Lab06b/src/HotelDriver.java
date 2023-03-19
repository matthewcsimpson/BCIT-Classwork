
public class HotelDriver {

	public static void main(String[] args) {

		// make to cats
		Cat cat1 = new Cat("Siamese", 12.0, false);
		Cat cat2 = new Cat("domestic short hair", 14.3, true);

		// make two dogs
		Dog dog1 = new Dog("Collie", 41.3, true);
		Dog dog2 = new Dog("Great Dane", 89.5, false);

		// make a new hotel
		AnimalHotel myHotel = new AnimalHotel();

		// add everyone to the hotel
		myHotel.addAnimal(cat1);
		myHotel.addAnimal(cat2);
		myHotel.addAnimal(dog1);
		myHotel.addAnimal(dog2);

		// display everyone in the hotel
		myHotel.displayGuests();

	}

}
