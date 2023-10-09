package com.theonionocean.learni.repository.implementation;

import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.entity.FlashCardMapper;
import com.theonionocean.learni.repository.FlashCardRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FlashCardRepositoryImpl implements FlashCardRepository {

    private final JdbcTemplate jdbcTemplate;

    public FlashCardRepositoryImpl(final JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<FlashCard> findAll() {
        return jdbcTemplate.query("SELECT * FROM flash_cards", new FlashCardMapper());
    }

    @Override
    public FlashCard find(UUID id) {
        return jdbcTemplate.queryForObject("SELECT * FROM flash_cards WHERE id=?", new FlashCardMapper(), id);
    }

    @Override
    public void save(FlashCard flashCard) {
        jdbcTemplate.update("INSERT INTO flash_cards (word, translation) VALUES (?, ?)", flashCard.getWord(), flashCard.getTranslation());
    }

    @Override
    public void update(FlashCard flashCard) {
        jdbcTemplate.update("UPDATE flash_cards SET word=?, translation=? WHERE id=?", flashCard.getWord(), flashCard.getTranslation(), flashCard.getId());
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM flash_cards WHERE id=?", id);
    }
}
