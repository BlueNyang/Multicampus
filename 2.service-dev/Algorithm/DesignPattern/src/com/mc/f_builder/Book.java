package com.mc.f_builder;

public class Book {
    private String title;
    private String author;
    private int page;
    private int price;

    private Book(Builder builder) {
        this.title = builder.title;
        this.author = builder.author;
        this.page = builder.page;
        this.price = builder.price;
    }

    @Override
    public String toString() {
        return "Book [title=" + title + ", author=" + author + ", page=" + page + ", price=" + price + "]";
    }

    public static class Builder {
        private String title;
        private String author;
        private int page;
        private int price;

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder author(String author) {
            this.author = author;
            return this;
        }

        public Builder page(int page) {
            this.page = page;
            return this;
        }

        public Builder price(int price) {
            this.price = price;
            return this;
        }

        public Book build() {
            return new Book(this);
        }
    }
}