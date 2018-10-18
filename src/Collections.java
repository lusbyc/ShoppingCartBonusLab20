import java.util.ArrayList;
import java.util.Scanner;

public class Collections {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ArrayList<String> fruit = new ArrayList<>();
		fruit.add("guava");
		fruit.add("papaya");
		fruit.add("mango");
		fruit.add("passionfruit");
		fruit.add("jackfruit");
		fruit.add("plantains");
		fruit.add("apple");
		fruit.add("apricot");

		ArrayList<Double> prices = new ArrayList<>();
		prices.add(1.99);
		prices.add(2.49);
		prices.add(0.99);
		prices.add(3.99);
		prices.add(1.49);
		prices.add(4.99);
		prices.add(.29);
		prices.add(.79);

		ArrayList<String> shoppingCartItem = new ArrayList<>();

		ArrayList<Double> shoppingCartPrice = new ArrayList<>();

		System.out.println("Welcome to Charlotte's Market!");
		System.out.println();

		System.out.printf("%-20s %-25s %n", "Item", "Price"); // table header
		System.out.println("==========================");

		for (int i = 0; i < fruit.size(); i++) {
			System.out.printf("%-20s %-25s %n", fruit.get(i), "$" + prices.get(i)); // prints list of fruit and prices
		}

		String cont = "y";
		double avg = 0;

		while (cont.equalsIgnoreCase("y")) {
			System.out.println();
			System.out.println("What item would you like to order? ");
			String userInput = scan.nextLine();

			boolean checkUserInput = fruit.contains(userInput); // determines if the text the user entered matches
																// anything on the fruit list
			if (checkUserInput == true) {
				int x = fruit.indexOf(userInput);
				prices.get(x);
				System.out.println();
				System.out.println("Adding " + fruit.get(x) + " to the cart at $" + prices.get(x));
				System.out.println();
				shoppingCartItem.add(fruit.get(x));
				shoppingCartPrice.add(prices.get(x));


				System.out.println("Would you like to continue? (y/n) ");
				cont = scan.nextLine();
				System.out.println();

				if (cont.equalsIgnoreCase("y")) {

					System.out.printf("%-20s %-25s %n", "Item", "Price");
					System.out.println("==========================");

					for (int i = 0; i < fruit.size(); i++) {
						System.out.printf("%-20s %-25s %n", fruit.get(i), "$" + prices.get(i));
					}
				} else {
					System.out.println("Thanks for your order!");
					System.out.println();
					System.out.println("Here's what you got: ");

					for (int i = 0; i < shoppingCartItem.size(); i++) {
						System.out.printf("%-20s %-25s %n", shoppingCartItem.get(i), "$" + shoppingCartPrice.get(i));
					}

					//  method call
					avg = calculateAverage(shoppingCartPrice, shoppingCartItem);

					System.out.println();
					System.out.println("Average price per item in order was $" + avg);
					System.out.println();
				//	System.out.println("Press any key to continue...");
				}
			} else {
				System.out.println();
				System.out.println("Sorry, we don't have those. Please try again.");
			}
		}
		System.out.println("Thanks for your order! Have a great day.");

	}

	public static double calculateAverage(ArrayList<Double> shoppingCartPrice, ArrayList<String> shoppingCartItem) {
		double avg = 0;
		for (int i = 0; i < shoppingCartItem.size(); i++) {

			double total = shoppingCartPrice.get(i);
			int cartCount = shoppingCartItem.size();
			avg = total / cartCount;
		}
		return avg;
	}
}
