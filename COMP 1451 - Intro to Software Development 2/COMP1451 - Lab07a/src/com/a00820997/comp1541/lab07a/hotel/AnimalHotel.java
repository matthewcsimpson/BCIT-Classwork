package com.a00820997.comp1541.lab07a.hotel;
import java.util.ArrayList;

import com.a00820997.comp1451.lab07a.animals.Animal;

/**
 * AnimalHotel where critters go on holiday.
 * 
 * @version 2017.10.01
 */
public class AnimalHotel {
	// instance variables
	private ArrayList<Animal> hotel;

	/**
	 * Constructor for objects of class AnimalHotel
	 */
	public AnimalHotel() {
		hotel = new ArrayList<Animal>();
	}

	/**
	 * Register a guest in the hotel
	 * 
	 * @param guest the Animal to add to the List.
	 */
	public void registerGuest(Animal guest) {
		if (guest != null) {
			hotel.add(guest);
		}
	}

	/**
	 * Show all the guests.
	 */
	public void showGuests() {
		if (hotel.size() > 0) {
			for (Animal guest : hotel) {
				guest.display();
			}
		}
	}

}
