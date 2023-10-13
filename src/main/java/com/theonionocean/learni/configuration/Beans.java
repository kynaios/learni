package com.theonionocean.learni.configuration;

import com.deepl.api.Translator;
import com.theonionocean.learni.repository.FlashCardRepository;
import com.theonionocean.learni.repository.implementation.FlashCardBagRepositoryImpl;
import com.theonionocean.learni.repository.implementation.FlashCardRepositoryImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class Beans {

    @Bean
    public Translator translator() {
        final String apiKey = System.getenv("LEARNI_DEEPL_API_KEY");

        return new Translator(apiKey);
    }
}
