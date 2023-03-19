package com.a00820997.comp1451.lab07a.animals;

/**
 * Cat likes to hunt or not
 * 
 * @author Paul
 * @version 2017.10.01
 */
public class Cat extends Animal
{
    // instance variables 
    private boolean hunts;
    

    /**
     * default constructor
     */
    public Cat() {
		super();
		// TODO Auto-generated constructor stub
	}

    /**
	 * Constructor for objects of class Dog
	 * @param breed to initialize breed field
	 * @param weight to initialize weight field
	 * @param hunts to initialize hunts field
	 * 
	 */
    public Cat(String breed, double weight, boolean hunts)
    {
        super(breed, weight);
        this.hunts = hunts;
    }

	/**
	 * @return the hunts as boolean
	 */
	public boolean isHunts() {
		return hunts;
	}

	/**
	 * @param hunts the hunts to set
	 */
	public void setHunts(boolean hunts) {
		this.hunts = hunts;
	}
	
	/**
	 * displays whether or not the cat is a hunter
	 */
	public void display(){
		
		if(hunts){
			System.out.println("This is a hunter!");
			
		}else{
			System.out.println("This is one lazy cat!");
			
		}
		
		super.display();
	} 
		

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Cat [hunts=" + hunts + ", toString()=" + super.toString() + "]";
	}
  
}




