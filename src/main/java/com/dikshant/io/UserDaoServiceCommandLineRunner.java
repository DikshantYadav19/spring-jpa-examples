package com.dikshant.io;

import com.dikshant.io.entity.User;
import com.dikshant.io.service.UserDAOService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    private UserDAOService userDAOService;

    @Override
    public void run(String... args) throws Exception {
        User user = new User("Jack", "Admin");
        long userId = userDAOService.insert(user);
        LOGGER.info("New user created : {}", user);
    }
}
