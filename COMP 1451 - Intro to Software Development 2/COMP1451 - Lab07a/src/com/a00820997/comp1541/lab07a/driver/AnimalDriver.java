package com.a00820997.comp1541.lab07a.driver;
import com.a00820997.comp1451.lab07a.animals.Cat;
import com.a00820997.comp1451.lab07a.animals.Dog;
import com.a00820997.comp1541.lab07a.hotel.AnimalHotel;

public class AnimalDriver {

	public AnimalDriver() {
		super();

	}

	public static void main(String[] args) {
		
		new AnimalDriver().test();

	}

	public void test() {
		
		AnimalHotel hotel = new AnimalHotel();
		
		hotel.registerGuest(new Dog("German Shepherd", 47.0, true));
		hotel.registerGuest(new Dog("German Shepherd", 40.0, false));
		hotel.registerGuest(new Cat("Tri-Colour", 5.0, false));
		
		hotel.showGuests();
		

	}

}
