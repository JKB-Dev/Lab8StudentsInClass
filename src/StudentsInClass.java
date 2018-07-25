import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentsInClass {

	public static void main(String[] args) {

		String[] names = { "Alejandro", "Barbara", "Shelly", "Roberto", "Meiko",
							"Carl", "Ibante", "Jules", "DeShawn", "Tamar",
							"Oscar", "Sierra", "Drew", "Marta", "Julia",
							"Waylon", "Cindy", "George", "Louise", "Sean"};
		String[] hometown = { "Caracas", "Seoul", "Portland", "Los Angeles", "Yokohama",
							"Atlanta", "Kinshasa", "Helsinki", "Dubai", "Ulon Bator",
							"Delhi", "Pittsburgh", "Moscow", "Oakland", "Bueons Aires",
							"Beijing", "Geneva", "Billings", "Madrid", "Luanda"};
		String[] faveFood = { "churros", "bibimbap", "tacos", "pad thai", "hamburgers",
							"potato chips", "paella", "poutine", "calimari", "tofu",
							"beef jerky", "bread", "yogurt", "soup", "salad",
							"sushi", "popcorn", "curry", "hummus", "ice cream"};
		System.out.println("Welcome to our Java class.");
		Scanner scan = new Scanner(System.in);
		int userNum = 0;

		String cont = "y";

		while (cont.equalsIgnoreCase("y")) {

			try {
				System.out.println("Which student would you like to know more about? enter a number 1 - 20: ");
				userNum = scan.nextInt();
				if ((userNum < 1) || (userNum > 20)) {
					scan.nextLine();
					throw new ArrayIndexOutOfBoundsException();
				}
			} catch (ArrayIndexOutOfBoundsException e) {
				System.out.println("Please enter a number between 1 and 20!");
				continue;

			} catch (InputMismatchException e) {

				System.out.println("Please enter a valid number!");
				scan.nextLine();
				continue;
			}
			
			System.out.println("Student " + userNum + " is " + names[userNum - 1]);

			while (cont.equalsIgnoreCase("y")) {
			
			try {
				System.out.println("What would you like to know about " + names[userNum - 1] + "?");

				System.out.print("Enter \"hometown\" or \"favorite food\": ");
				scan.nextLine();
				String userInput = scan.nextLine();

				if ((!userInput.equalsIgnoreCase("hometown")) && (!userInput.equalsIgnoreCase("favorite food"))) {
					throw new IllegalArgumentException();
				
				} else if (userInput.equalsIgnoreCase("hometown")) {
					System.out.println(names[userNum - 1] + "'s hometown is " + hometown[userNum - 1] + ".");
				
				} else if (userInput.equalsIgnoreCase("favorite food")) {
					System.out.println(names[userNum - 1] + "'s favorite food is " + faveFood[userNum - 1] + ".");
				}

			} catch (IllegalArgumentException f) {
				System.out.println("Please choose \"hometown\" or \"favorite food\"! ");
				continue;
			}
			}
			
			System.out.println("Would you like to know more? (y/n): ");
			cont = scan.nextLine();
			
		}
		
		System.out.println("Goodbye!");
		scan.close();
	}
}