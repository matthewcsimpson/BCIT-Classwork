/**
 * Project: COMP2613 - 08 - Lab 08
 * File: Race.java
 * Date: June 12, 2019
 *
 * @author Matthew Simpson / A00820997
 */

package a00820997.race;

import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class Runner extends Thread {

	private int rank;
	private int lane;
	private int bib;
	private String country;
	private String firstName;
	private String lastName;
	private long reaction;
	private float result;

	public static final int RACE_LENGTH = 100;

	public Runner(int lane, int bib, String country, String firstName, String lastName, long reaction) {
		this.lane = lane;
		this.bib = bib;
		this.country = country;
		this.firstName = firstName;
		this.lastName = lastName;
		this.reaction = reaction;
	}

	public int getRank() {
		return rank;
	}

	public int getLane() {
		return lane;
	}

	public int getBib() {
		return bib;
	}

	public String getCountry() {
		return country;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public long getReaction() {
		return reaction;
	}

	public float getResult() {
		return result;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public void setLane(int lane) {
		this.lane = lane;
	}

	public void setBib(int bib) {
		this.bib = bib;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setReaction(long reaction) {
		this.reaction = reaction;
	}

	public void setResult(float result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "Runner [rank=" + rank + ", lane=" + lane + ", bib=" + bib + ", country=" + country + ", firstName="
				+ firstName + ", lastName=" + lastName + ", reaction=" + reaction + ", result=" + result + "]";
	}

	public void run() {
		// System.out.println("The runner in lane " + this.lane + " has started!");
		Instant start = Instant.now();
		try {
			Thread.sleep(reaction);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		for(int i = 0; i<100; i++) {
			Random delay = new Random();
			try {
				Thread.sleep(delay.nextInt(16));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		Instant end = Instant.now();
		long milliTime = Duration.between(start, end).toMillis();
		float raceTime = milliTime / 100f;
		// System.out.println("The runner in lane " + this.lane + " has finished!");

		setResult(raceTime);
	}

}
