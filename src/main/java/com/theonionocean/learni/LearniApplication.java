package com.theonionocean.learni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LearniApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearniApplication.class, args);
    }

}
