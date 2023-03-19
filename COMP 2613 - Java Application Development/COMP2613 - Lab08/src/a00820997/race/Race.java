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
import java.util.ArrayList;
import java.util.Comparator;

public class Race {

	ArrayList<Runner> runners;
	Runner bolt;
	Runner gatlin;
	Runner degrasse;
	Runner blake;
	Runner simbine;
	Runner meite;
	Runner vicaut;
	Runner bromwell;

	public Race() {
		// the list of runners
		runners = new ArrayList<Runner>();
		// runners
		bolt = new Runner(6, 2612, "JAM", "Usain", "BOLT", 115);
		gatlin = new Runner(4, 3069, "USA", "Justin", "GATLIN", 152);
		degrasse = new Runner(7, 2196, "CAN", "Andre", "DE GRASSE", 141);
		blake = new Runner(9, 2611, "JAM", "Yohan", "BLAKE", 145);
		simbine = new Runner(3, 2909, "RSA", "Akani", "SIMBINE", 128);
		meite = new Runner(8, 2245, "CIV", "Ben Youssef", "MEITE", 156);
		vicaut = new Runner(5, 2434, "FRA", "Jimmy", "VICAUT", 140);
		bromwell = new Runner(2, 3054, "USA", "Trayvon", "BROMWELL", 135);
		// to the list
		runners.add(bolt);
		runners.add(gatlin);
		runners.add(degrasse);
		runners.add(blake);
		runners.add(simbine);
		runners.add(meite);
		runners.add(vicaut);
		runners.add(bromwell);
	}

	public static void main(String[] args) throws InterruptedException {
		new Race().run();
	}

	/**
	 * Method to run the race!		
	 * @throws InterruptedException
	 */
	public synchronized void run() throws InterruptedException {
		Instant raceStart = Instant.now();
		System.out.println("And They're Off! " + raceStart);
		for (int i = 0; i < runners.size(); i++) {
			runners.get(i).start();
			runners.get(i).join();
		}

		report(runners);
		Instant raceEnd = Instant.now();
		long raceTime = Duration.between(raceStart, raceEnd).toMillis();
		System.out.println("The race ends at " + raceEnd);
		System.out.println("Race Time: " + raceTime + "ms");
	}

	public void report(ArrayList<Runner> runners) {

		runners.sort(new CompareByResult());
		final String LINE = "----------------------------------------------------------------------------------------------------------";
		final String FORMATTER = "%-6d %-6d %-8d %-8s %-20s %-20s %-15d %-10s%n";
		final String H_FORMATTER = "%-6s %-6s %-8s %-8s %-20s %-20s %-15s %-10s%n";

		System.out.format(H_FORMATTER, "Rank", "Lane", "Bib", "Country", "Last Name", "First Name", "Reaction", "Result");
		System.out.println(LINE);
		for (int i = 0; i < runners.size(); i++) {
			System.out.format(FORMATTER, runners.indexOf(runners.get(i)) + 1, runners.get(i).getLane(), runners.get(i).getBib(),
					runners.get(i).getCountry(), runners.get(i).getLastName(), runners.get(i).getFirstName(),
					runners.get(i).getReaction(), String.format("%.3f", runners.get(i).getResult()));
		}
		System.out.println(LINE);
	}
	
	/**
	 * Class to compare the results.
	 * 
	 * @author Matthew Simpson
	 *
	 */
	public static class CompareByResult implements Comparator<Runner> {

		@Override
		public int compare(Runner o1, Runner o2) {
			float r1 = o1.getResult();
			float r2 = o2.getResult();
			return Float.compare(r1, r2);
		}
		
	}		
	}


