
public class GroceryItem {
	private String name;
	private String unit;
	private double pricePerUnit;
	private double quantity;

	private static final String itemNames[] = { "Oreo", "HideAndSeek", "Britannia", "Tomato", "Potato", "Brinjal",
			"Carrot", "Beetroot", "Onion", "Orange", "Apple", "Mango", "Pomogranate", "Guava" };
	private static final String units[] = { "packet", "packet", "Kg", "Kg", "Kg", "Kg", "Kg", "Kg", "Kg", "Kg", "Kg",
			"Kg", "Kg" };
	private static final double prices[] = { 25.0, 30.0, 10.0, 35.0, 45.0, 25.0, 65.0, 45.0, 70.0, 120.0, 130.0, 90.0,
			150.0, 60.0 };

	GroceryItem(String name, double quantity) {
		this.name = name;
		this.quantity = quantity;

		for (int i = 0; i < itemNames.length; i++) {
			if (itemNames[i].equalsIgnoreCase(name)) {
				this.pricePerUnit = prices[i];
				this.unit = units[i];
				break;
			}
		}
	}

	public double calculatePrice() {
		return pricePerUnit * quantity;
	}

	public void displayItemDetails(int sNo) {
		System.out.printf("| %-3d | %-12s | %-9.1f | %-9.1f | %-9.1f |%n", sNo, name, quantity, pricePerUnit,
				(pricePerUnit * quantity));
	}
}