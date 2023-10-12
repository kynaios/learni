package com.theonionocean.learni.dto;

import java.util.Objects;

public class TranslationDto {
    private String word;
    private String translation;

    public TranslationDto(String word, String translation) {
        this.word = word;
        this.translation = translation;
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
        if (!(o instanceof TranslationDto that)) return false;
        return Objects.equals(getWord(), that.getWord()) && Objects.equals(getTranslation(), that.getTranslation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getWord(), getTranslation());
    }
}
