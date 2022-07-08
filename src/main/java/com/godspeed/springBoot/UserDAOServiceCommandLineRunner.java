package com.godspeed.springBoot;

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
        User user = new User("Jack", "Admin");
        // New User is created : User [id=1, name=Jack, role=Admin]
        long insert = userDaoService.insert(user);
        logger.info("New User is created : " + user);
    }
    
}
