package com.theonionocean.learni.dto;

import com.theonionocean.learni.entity.FlashCard;

import java.util.Objects;
import java.util.UUID;

public class FlashCardDto {
    private UUID id;
    private String word;
    private String translation;
    private UUID deckId;

    public FlashCard map() {
        return new FlashCard(id, word, translation, deckId);
    }

    public FlashCardDto(UUID id, String word, String translation, UUID deckId) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.deckId = deckId;
    }

    public FlashCardDto(UUID id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
    }

    public FlashCardDto() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public UUID getDeckId() {
        return deckId;
    }

    public void setDeckId(UUID deckId) {
        this.deckId = deckId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCardDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getWord(), that.getWord()) && Objects.equals(getTranslation(), that.getTranslation()) && Objects.equals(getDeckId(), that.getDeckId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWord(), getTranslation(), getDeckId());
    }
}
