package com.theonionocean.learni.service;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;

import java.util.List;
import java.util.UUID;

public interface FlashCardService {
    List<FlashCard> findAll();

    FlashCard find(UUID id);

    void save(FlashCardDto flashCardDto);

    void update(FlashCardDto flashCardDto);

    void delete(UUID id);
}
