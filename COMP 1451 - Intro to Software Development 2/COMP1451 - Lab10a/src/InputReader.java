import java.util.Scanner;

public class InputReader {
	private Scanner scanner;

	public InputReader() {
		scanner = new Scanner(System.in);
	}

	/**
	 * This method returns the number typed by the user. If the number isnot an
	 * integer it throws a custom checked exception that will be caught by the
	 * calling method.@throws InputMismatchException, NatAnIntegerException
	 */

	public int getNumber() throws NotAnIntegerException {
		int number = 0;

		try {
			number = scanner.nextInt();
		} // catch any non-integer input
		catch (java.util.InputMismatchException exc) {
			scanner.nextLine(); // clear the buffer
			throw new NotAnIntegerException("not a valid number!");
		}
		return number;
	}
}