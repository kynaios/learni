package com.theonionocean.learni.service;

import com.theonionocean.learni.dto.FlashCardDto;

import java.util.List;
import java.util.UUID;

public interface FlashCardDeckRelationService {
    List<FlashCardDto> findAllDeckFlashcards(UUID id);
}
