
public class Dog extends Animal {

	private boolean likesToWalk;

	/**
	 * default constructor
	 */
	public Dog() {
		super();
	}

	/**
	 * main constructor for dogs
	 * 
	 * @param breed, a string, set in the superclass
	 * @param weightInKilos, a double, set in the superclass
	 * @param likesToWalk, a boolean
	 */
	public Dog(String breed, double weightInKilos, boolean likesToWalk) {
		super(breed, weightInKilos);

		setLikesToWalk(likesToWalk);
	}

	/**
	 * sets if the dog likes to walk
	 * 
	 * @param likesToWalk, a boolean, true for yes false for no
	 */
	public void setLikesToWalk(boolean likesToWalk) {
		this.likesToWalk = likesToWalk;
	}

	/**
	 * returns whether the dog likes to walk.
	 * 
	 * @return the likesToWalk, a boolean.
	 */
	public boolean isLikesToWalk() {
		return likesToWalk;
	}

	/**
	 * overridden display method. prints breed, weight, and whether the dog is lazy
	 * or likes to walk
	 */
	@Override
	public void display() {
		super.display();
		if (likesToWalk == true) {
			System.out.println("This dog likes to walk.");
		} else {
			System.out.println("This is a lazy dog!");
		}
		System.out.println();
	}

}

///**
//* overridden toString method.
//*/
//@Override
//public String toString() {
//	return "Dog [likesToWalk=" + likesToWalk + ", toString()=" + super.toString() + "]";
//}
