
public class Animal {

	private String breed;
	private double weightInKilos;

	/**
	 * default constructor
	 */
	public Animal() {
		super();
	}

	/**
	 * main constructor
	 * 
	 * @param breed, a string ,the breed of the animal
	 * @param weightInKilos, a double, the weight of the animal in kilograms
	 */
	public Animal(String breed, double weightInKilos) {

		setBreed(breed);
		setWeightInKilos(weightInKilos);
	}

	/**
	 * sets the breed of the animal
	 * 
	 * @param breed, a string, the breed to be set
	 */
	public void setBreed(String breed) {
		if (breed != null) {
			this.breed = breed;
		}
	}

	/**
	 * sets the animals weight in kilograms
	 * 
	 * @param weightInKilos, a double, the weight to be set
	 */
	public void setWeightInKilos(double weightInKilos) {
		if (weightInKilos > 0.0) {
			this.weightInKilos = weightInKilos;
		}
	}

	/**
	 * Returns the breed of the animal.
	 * 
	 * @return the breed, a string
	 */
	public String getBreed() {
		return breed;
	}

	/**
	 * Returns the weight of the animal in kilograms.
	 * 
	 * @return the weightInKilos, a double
	 */
	public double getWeightInKilos() {
		return weightInKilos;
	}

	/**
	 * displays breed and weight info for the animal.
	 */
	public void display() {
		System.out.println("This is a " + breed + " weighing " + weightInKilos + " kilos.");
	}

}

///** 
//* toString method. 
//*/
//@Override
//public String toString() {
//	return "Animal [breed=" + breed + ", weightInKilos=" + weightInKilos + "]";
//}
