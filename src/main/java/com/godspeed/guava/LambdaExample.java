package com.godspeed.guava;

import java.util.Objects;
import java.util.TreeSet;

public class LambdaExample {
    
    public static void main(String[] args) {
        LambdaExample x = new LambdaExample();
        
        TreeSet<Book> bookSet = new TreeSet<Book>((b1, b2) -> b1.getTitle().compareTo(b2.getTitle()));
        Book a = x.new Book("Bible", "GOD", "ooooo");
        Book b = x.new Book("ACIM", "JESUS", "XXX");
        Book c = x.new Book("Thicking in java", "Tob", "qes");
        bookSet.add(a);
        bookSet.add(b);
        bookSet.add(c);
        
        System.out.print(false);
    }
    
    class Book {
        
        public Book(String title, String author, String isbn) {
            super();
            this.title = title;
            this.author = author;
            this.isbn = isbn;
        }
        
        private String title;
        private String author;
        private String isbn;
        private Integer price;
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + Objects.hash(title);
            return result;
        }
        

        
        public String getTitle() {
            return title;
        }
        
        public void setTitle(String title) {
            this.title = title;
        }
        
        public String getAuthor() {
            return author;
        }
        
        public void setAuthor(String author) {
            this.author = author;
        }
        
        public String getIsbn() {
            return isbn;
        }
        
        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }
        
        public Integer getPrice() {
            return price;
        }
        
        public void setPrice(Integer price) {
            this.price = price;
        }
        
        

    }
}
