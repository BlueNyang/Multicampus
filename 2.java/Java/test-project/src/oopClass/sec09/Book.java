package oopClass.sec09;

public class Book {
    private String title;
    private String author;
    private int price;


    public Book() {
        this("Unknown Title", "Unknown Author", 0);
    }

    public Book(String title, String author, int price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void show() {
        System.out.printf("Title: %s, Author: %s, Price: %d\n", title, author, price);
    }

    public static void main(String[] ignoredArgs) {
        Book bk = new Book("Java", "Jane Doe", 30000);
        Book bk1 = new Book();

        bk.show();
        bk1.show();
    }
}
