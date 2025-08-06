package genericCollection.sec09;

import java.util.LinkedList;

public class LinkedListPrdMain {
    public static void main(String[] ignoredArgs) {
        LinkedList<Product> productList = new LinkedList<>();
        productList.add(new Product(101, "Laptop", 75000.0));
        productList.add(new Product(102, "Smartphone", 30000.0));
        productList.add(new Product(103, "Tablet", 20000.0));

        System.out.println("Product List: " + productList);

        // Remove a product
        productList.remove(new Product(102, "Smartphone", 30000.0));
        System.out.println("After removing Smartphone: " + productList);

        // Check if a product exists
        boolean exists = productList.contains(new Product(101, "Laptop", 75000.0));
        System.out.println("Does Laptop exist? " + exists);
    }
}
