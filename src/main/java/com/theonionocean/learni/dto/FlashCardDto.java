package com.theonionocean.learni.dto;

import com.theonionocean.learni.entity.FlashCard;

import java.util.Objects;
import java.util.UUID;

public class FlashCardDto {
    private UUID id;
    private String word;
    private String translation;

    public FlashCard map() {
        return new FlashCard(id, word, translation);
    }

    public FlashCardDto(UUID id, String word, String translation) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FlashCardDto that)) return false;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getWord(), that.getWord()) && Objects.equals(getTranslation(), that.getTranslation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getWord(), getTranslation());
    }
}
