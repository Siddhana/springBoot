package com.godspeed.springBoot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godspeed.bean.Book;

@RestController
public class AppAction {
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/Books")
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book a = new Book("Genesis", "Moss", "100-777");
        Book b = new Book("Gospel of John", "John", "100-888");
        Book c = new Book("Gospel of Marco", "Marco", "100-888");
        books.add(b);
        books.add(a);
        books.add(c);
        return books;
    }
}
