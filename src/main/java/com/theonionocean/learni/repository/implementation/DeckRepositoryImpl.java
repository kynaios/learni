package com.theonionocean.learni.repository.implementation;

import com.theonionocean.learni.entity.Deck;
import com.theonionocean.learni.entity.DeckMapper;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.entity.FlashCardMapper;
import com.theonionocean.learni.repository.CrudRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Qualifier("DeckRepositoryImpl")
public class DeckRepositoryImpl implements CrudRepository<Deck> {

    JdbcTemplate jdbcTemplate;

    public DeckRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Deck> findAll() {
        return jdbcTemplate.query("SELECT * FROM decks", new DeckMapper());
    }

    @Override
    public Deck find(UUID id) {
        return jdbcTemplate.queryForObject("SELECT * FROM decks WHERE id=?", new DeckMapper(), id);
    }

    @Override
    public void save(Deck deck) {
        jdbcTemplate.update("INSERT INTO decks (name) VALUES (?)", deck.getName());
    }

    @Override
    public void update(Deck deck) {
        jdbcTemplate.update("UPDATE decks SET name=? WHERE id=?", deck.getName(), deck.getId());
    }

    @Override
    public void delete(UUID id) {
        jdbcTemplate.update("DELETE FROM decks WHERE id=?", id);
    }
}
