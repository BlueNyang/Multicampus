package com.mc.f_builder;

public class Run {
    public static void main(String[] args) {
        Book book = new Book.Builder()
                .title("Harrary Potter")
                .author("J.K. Rowling")
                .price(90000)
                .page(300)
                .build();
        System.out.println(book);
    }
}
