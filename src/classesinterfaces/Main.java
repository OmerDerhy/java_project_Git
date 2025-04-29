package classesinterfaces;

import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		Product[] products = new Product[5];
		products[0] = new SprayDeodorant("110", 199.95, 50, "Thick");
		products[1] = new SprayDeodorant("98", 50.00, 50, "Thin");

		products[2] = new BallDeodorant("105", 199.50, 60);
		products[3] = new BallDeodorant("100", 250.50, 30);

		products[4] = new Perfume("93", 450.99, 100, "France");

		System.out.println("Before Sorting:");
		printProducts(products);

		Arrays.sort(products);
		System.out.println("Sorted by Price:");
		printProducts(products);

		Arrays.sort(products, new SortBySKU());
		System.out.println("Sorted by SKU:");
		printProducts(products);
	}

	private static void printProducts(Product[] products) {
		System.out.printf("%-15s %-10s %-10s %-5s %-5s\n", "Category", "SKU", "Price", "SIze", "Made In");
		System.out.println(" = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = ");
		for (Product p : products) {
			p.printAttributes();
		}
		System.out.println(" = = = = = = = = = = = = = = = = = = = = = = = = = = = = = = \n");

	}

}
