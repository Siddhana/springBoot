package com.godspeed.springBoot.action;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.godspeed.springBoot.entity.Book;
import com.godspeed.springBoot.entity.User;
import com.godspeed.springBoot.service.UserRepository;

@RestController
public class AppAction {
    
    // @Autowired
    // private UserDAOService userDaoService;
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/Books")
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        Book a = new Book("Genesis", "Moss", 70);
        Book b = new Book("Gospel of John", "John", 80);
        Book c = new Book("Gospel of Marco", "Marco", 90);
        books.add(b);
        books.add(a);
        books.add(c);
        return books;
    }
    
    @GetMapping("/Users")
    public List<User> getUsers() {
        return (List<User>) userRepository.findAll();
    }
}
