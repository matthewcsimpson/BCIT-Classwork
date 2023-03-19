
public class NumberReader {

	InputReader reader = new InputReader();
	
	public void userInputSum() {
		
		int numberSum = 0;
		boolean userContinues = true;
		
		do {
			try {
				System.out.print("Enter a whole number:");
				int value = reader.getNumber();
				if(value != 0) {
					numberSum += value;
				}else {
					System.out.println("ending the loop");
					System.out.println("things add up to " + numberSum);
					userContinues = false;
				}
			}
			catch(NotAnIntegerException exc) {
				System.out.println(exc.getMessage());
			}
		}while(userContinues);
		
		
	}
	
}

