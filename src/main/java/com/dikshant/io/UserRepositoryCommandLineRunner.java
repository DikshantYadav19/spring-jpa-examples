package com.dikshant.io;

import com.dikshant.io.entity.User;
import com.dikshant.io.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... args) {
        User user = new User("Jill", "Usual");
        userRepository.save(user);
        LOGGER.info("New user created : {}", user);

        Optional<User> optionalUser = userRepository.findById(2L);
        LOGGER.info("User found : {}", optionalUser.get());

        List<User> users = userRepository.findAll();
        LOGGER.info("Users : {}", users);
    }
}
