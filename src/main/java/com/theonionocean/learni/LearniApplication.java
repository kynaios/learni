package com.theonionocean.learni;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class LearniApplication implements CommandLineRunner {

	private final JdbcTemplate jdbcTemplate;

	public LearniApplication(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(LearniApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		jdbcTemplate.queryForObject("SELECT 1", Integer.class);
	}
}
