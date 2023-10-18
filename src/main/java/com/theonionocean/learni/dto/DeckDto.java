package com.theonionocean.learni.dto;

import com.theonionocean.learni.entity.Deck;

import java.util.Objects;
import java.util.UUID;

public class DeckDto {
    private UUID id;
    private String name;

    public Deck map() {
        return new Deck(id, name);
    }

    public DeckDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeckDto category)) return false;
        return Objects.equals(getId(), category.getId()) && Objects.equals(getName(), category.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }

}
