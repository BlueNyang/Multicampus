package oopClass.sec04;

import java.text.NumberFormat;
import java.util.Scanner;

public class Product {
    private String prdName;
    private int prdPrice;
    private int prdSold;
    private int prdStock;

    void inputPrdInfo() {
        try (Scanner sc = new Scanner(System.in)) {
            System.out.print("Enter product name: ");
            prdName = sc.nextLine();
            System.out.print("Enter product price: ");
            prdPrice = sc.nextInt();
            System.out.print("Enter product sold quantity: ");
            prdSold = sc.nextInt();
            System.out.print("Enter product stock quantity: ");
            prdStock = sc.nextInt();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter valid product information.");
        }
    }

    void showPrdInfo() {
        if (prdName == null || prdPrice <= 0 || prdSold < 0 || prdStock < 0) {
            System.out.println("Product information is incomplete or invalid.");
            return;
        }
        System.out.println("\n**** Product Information ****");
        System.out.println("Product Name: " + prdName);
        System.out.println("Product Price: " + prdPrice);
        System.out.println("Product Sold Quantity: " + prdSold);
        System.out.println("Product Stock Quantity: " + prdStock);
    }

    String showSalesAmount() {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format((long) prdPrice * prdSold);
    }

    String showStockAmount() {
        NumberFormat nf = NumberFormat.getInstance();
        return nf.format((long) prdPrice * prdStock);
    }

    public static void main(String[] args) {
        Product product = new Product();
        product.inputPrdInfo();
        product.showPrdInfo();
        System.out.println("Sales Amount: " + product.showSalesAmount());
        System.out.println("Stock Amount: " + product.showStockAmount());
    }
}
