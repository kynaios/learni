package com.theonionocean.learni.repository;

import com.theonionocean.learni.entity.FlashCard;

import java.util.List;
import java.util.UUID;

public interface CrudRepository<T> {
    List<T> findAll();

    T find(UUID id);

    void save(T entity);

    void update(T entity);

    void delete(UUID id);
}
