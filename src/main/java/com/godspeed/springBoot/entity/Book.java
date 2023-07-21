package com.godspeed.springBoot.entity;

import java.util.Objects;

import com.google.common.collect.ComparisonChain;

public class Book implements Comparable<Book> {
    
    private String name;
    private String author;
    private int price;
    
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(String author) {
        this.author = author;
    }
    
    public Book(String name, String author, int price) {
        super();
        this.name = name;
        this.author = author;
        this.price = price;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(author, name, price);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Book other = (Book) obj;
        return Objects.equals(author, other.author) && Objects.equals(name, other.name) && price == other.price;
    }
    
    @Override
    public String toString() {
        return "Book [name=" + name + ", author=" + author + ", price=" + price + "]";
    }
    
    @Override
    public int compareTo(Book other) {
        return ComparisonChain
                .start()
                .compare(name, other.name)
                .compare(author, other.author)
                .compare(price, other.price)
                .result();
    }
    

    
}
