package genericCollection.ex01;

import java.util.LinkedList;
import java.util.Scanner;

public class ProductMain {
    public static void main(String[] ignoredArgs) {
        final int SIZE = 3;
        LinkedList<Product> list = new LinkedList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            for (int i = 0; i < SIZE; i++) {
                System.out.print("Enter product number: ");
                int pNo = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter product name: ");
                String pName = scanner.nextLine();
                System.out.print("Enter product price: ");
                double price = scanner.nextDouble();

                list.add(new Product(pNo, pName, price));
            }
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid data.");
            return; // Exit if input is invalid
        }

        for (Product product : list) {
            System.out.println(product);
        }
    }
}
