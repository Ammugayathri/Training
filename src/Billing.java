import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Billing {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		boolean isHomeDeliveryNeeded = false;
		boolean isPackagingNeeded = false;
		double packagingCost = 0;
		double homeDeliveryCost = 0;
		System.out.println("Enter the no.of customers:");
		int customers = sc.nextInt();
		List<GroceryItem> items = new ArrayList<>();
		char userChoiceChar = 'Y';
		for (int i = 1; i <= customers; i++) {
			System.out.println("Customer no:" + i);
			System.out.println("Does the customer need Home delivery? true/false");
			isHomeDeliveryNeeded = sc.nextBoolean();
			System.out.println("Does the customer need Packaging? true/false");
			isPackagingNeeded = sc.nextBoolean();
			do {
				System.out.println("Enter the item name:");
				String itemName = sc.next();
				System.out.println("Enter the quantity:");
				double quantity = sc.nextDouble();
				GroceryItem item = new GroceryItem(itemName, quantity);
				items.add(item);
				System.out.println("Add another item?(Y for yes/N for no)");
				String userChoiceString = sc.next();
				userChoiceChar = userChoiceString.charAt(0);

			} while (userChoiceChar == 'Y' || userChoiceChar == 'y');

			double totalBill = 0.0;
			System.out.printf("%35s %n", "POOJA'S SUPER MARKET");
			System.out.println("----------------------------------------------------------");
			LocalDateTime dt = LocalDateTime.now();
			System.out.printf("%s %50s %n", "Date:", dt);
			System.out.println("----------------------------------------------------------");
			System.out.printf("|%-4s | %-12s |%-10s |%-10s |%-10s| %n", "S.No", "Item", "Quantity", "Unit Price",
					"Total Price");
			System.out.println("----------------------------------------------------------");
			int sNo = 1;
			for (GroceryItem item : items) {
				item.displayItemDetails(sNo);
				totalBill += item.calculatePrice();
				sNo++;
			}
			double GST = (18 * totalBill) / 100;
			System.out.println("----------------------------------------------------------");
			System.out.printf("%50s %-9.1f %n", "Total Bill:", totalBill);
			System.out.printf("%50s %-9.1f %n", "GST(18%):", GST);
			if (isHomeDeliveryNeeded)
				homeDeliveryCost = 50;
			if (isPackagingNeeded)
				packagingCost = 20;
			System.out.printf("%50s %-9.1f %n", "Amount for Home Delivery:", homeDeliveryCost);
			System.out.printf("%50s %-9.1f %n", "Amount for Packaging:", packagingCost);
			double finalAmount = totalBill + GST + packagingCost + homeDeliveryCost;
			System.out.printf("%50s %-9.1f %n", "The amount you have to pay:", finalAmount);
			items.clear();
			homeDeliveryCost = 0;
			packagingCost = 0;
		}
		sc.close();
	}

}