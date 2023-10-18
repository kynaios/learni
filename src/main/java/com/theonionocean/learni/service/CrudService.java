package com.theonionocean.learni.service;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;

import java.util.List;
import java.util.UUID;

public interface CrudService<T> {
    List<T> findAll();

    T find(UUID id);

    void save(T dto);

    void update(T dto);

    void delete(UUID id);
}
