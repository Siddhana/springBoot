package com.godspeed.springBoot.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.godspeed.springBoot.entity.User;

@Component
public class UserDAOServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(UserDAOServiceCommandLineRunner.class);
    @Autowired
    private UserDAOService userDaoService;
    
    @Override
    public void run(String... args) throws Exception {
        logger.info("ApplicationStartupRunner run method Started !!");
        User a = new User("Marco", "Admin");
        User b = new User("John", "Admin");
        User c = new User("Moss", "Common");
        userDaoService.insert(a);
        userDaoService.insert(b);
        userDaoService.insert(c);
        
    }
    
}
