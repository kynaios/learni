package com.theonionocean.learni.repository;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;

import java.util.List;
import java.util.UUID;

public interface FlashCardDeckRelationRepository {
    List<FlashCard> findAllDeckFlashcards(UUID id);
}
