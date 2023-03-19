package com.a00820997.comp1451.lab07a.animals;

/**
 * Animal class - animal has breed and weight.
 * 
 * @author Paul
 * @version 2017.10.01
 */
public class Animal {
	// instance variables
	private String breed;
	private double weightKg;

	/**
	 * default constructor
	 */
	public Animal() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor for objects of class Animal
	 * 
	 * @param breed
	 *            to initialize breed field
	 * @param weight
	 *            to initialize weight field
	 */
	public Animal(String breed, double weightKg) {
		setBreed(breed);
		setWeightKg(weightKg);
	}

	/**
	 * @return the breed as String
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * @param breed
	 *            the breed to set
	 */
	public void setBreed(String breed) {
		if (breed != null) {
			this.breed = breed;
		}
	}

	/**
	 * @return the weightKg as double
	 */
	public double getWeightKg() {
		return weightKg;
	}

	/**
	 * @param weightKg
	 *            the weightKg to set
	 */
	public void setWeightKg(double weightKg) {
		if (weightKg > 0.0) {
			this.weightKg = weightKg;
		}
	}

	/**
	 * displays Animal breed and weight
	 */
	public void display() {

		System.out.println(String.format("This is a %s weighing %.1f kilos.", breed, weightKg));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Animal [breed=" + breed + ", weightKg=" + weightKg + "]";
	}

}
