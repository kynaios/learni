package com.theonionocean.learni.entity;

import java.util.Objects;
import java.util.UUID;

public class FlashCard {
    private UUID id;
    private String word;
    private String translation;
    private UUID deckId;

    public FlashCard(UUID id, String word, String translation, UUID deckId) {
        this.id = id;
        this.word = word;
        this.translation = translation;
        this.deckId = deckId;
    }

    public FlashCard(UUID id, String word, String translation) {
        this.id = id;
        this.word = word;
        this.translation = translation;
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
        if (!(o instanceof FlashCard flashCard)) return false;
        return Objects.equals(getId(), flashCard.getId()) && Objects.equals(getWord(), flashCard.getWord()) && Objects.equals(getTranslation(), flashCard.getTranslation()) && Objects.equals(getDeckId(), flashCard.getDeckId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWord(), getTranslation(), getDeckId());
    }
}

