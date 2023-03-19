
public class Cat extends Animal {

	private boolean likesToHunt;

	/**
	 * default constructor
	 */
	public Cat() {
		super();
	}

	/**
	 * main constructor for cats
	 * 
	 * @param breed, a string, set in the superclass
	 * @param weightInKilos, a double, set in the superclass
	 * @param likesToHunt, a boolean
	 */
	public Cat(String breed, double weightInKilos, boolean likesToHunt) {
		super(breed, weightInKilos);
		setLikesToHunt(likesToHunt);
	}

	/**
	 * sets if this cat likes to hunt or not
	 * 
	 * @param likesToHunt, a boolean, true for yes false for no
	 */
	public void setLikesToHunt(boolean likesToHunt) {
		this.likesToHunt = likesToHunt;
	}

	/**
	 * Returns whether the cat likes to hunt or not.
	 * 
	 * @return the likesToHunt, a boolean
	 */
	public boolean isLikesToHunt() {
		return likesToHunt;
	}

	/**
	 * overridden display mthod. prints breed, weight, and whether the cat is lazy
	 * or a hunter
	 */
	@Override
	public void display() {
		if (likesToHunt == true) {
			System.out.println("This is a hunter!");
		} else {
			System.out.println("This is one lazy cat!");
		}
		super.display();
		System.out.println();
	}

}

///**
//* overriden tostring method.
//*/
//@Override
//public String toString() {
//	return "Cat [likesToHunt=" + likesToHunt + ", toString()=" + super.toString() + "]";
//}