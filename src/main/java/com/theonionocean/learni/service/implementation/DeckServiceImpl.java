package com.theonionocean.learni.service.implementation;

import com.theonionocean.learni.dto.DeckDto;
import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.Deck;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.repository.CrudRepository;
import com.theonionocean.learni.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Qualifier("DeckServiceImpl")
public class DeckServiceImpl implements CrudService<DeckDto> {

    CrudRepository<Deck> repository;

    @Autowired
    public DeckServiceImpl(@Qualifier("DeckRepositoryImpl") CrudRepository<Deck> repository) {
        this.repository = repository;
    }

    @Override
    public List<DeckDto> findAll() {
        return repository.findAll()
                .stream()
                .map(deck -> new DeckDto(deck.getId(), deck.getName()))
                .toList();
    }

    @Override
    public DeckDto find(UUID id) {
        Deck deck = repository.find(id);

        return new DeckDto(deck.getId(), deck.getName());
    }

    @Override
    public void save(DeckDto deckDto) {
        Deck deck = deckDto.map();

        repository.save(deck);
    }

    @Override
    public void update(DeckDto deckDto) {
        Deck deck = deckDto.map();
        repository.update(deck);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }
}
