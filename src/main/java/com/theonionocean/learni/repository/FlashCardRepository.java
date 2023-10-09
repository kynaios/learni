package com.theonionocean.learni.repository;

import com.theonionocean.learni.entity.FlashCard;

import java.util.List;
import java.util.UUID;

public interface FlashCardRepository {
    List<FlashCard> findAll();

    FlashCard find(UUID id);

    void save(FlashCard flashCard);

    void update(FlashCard flashCard);

    void delete(UUID id);
}
