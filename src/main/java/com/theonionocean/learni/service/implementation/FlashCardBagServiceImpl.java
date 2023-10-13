package com.theonionocean.learni.service.implementation;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.repository.FlashCardRepository;
import com.theonionocean.learni.service.FlashCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Qualifier("FlashCardBagServiceImpl")
public class FlashCardBagServiceImpl implements FlashCardService {

    FlashCardRepository repository;

    @Autowired
    public FlashCardBagServiceImpl(@Qualifier("FlashCardBagRepositoryImpl") FlashCardRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FlashCard> findAll() {
        return repository.findAll();
    }

    @Override
    public FlashCard find(UUID id) {
        return repository.find(id);
    }

    @Override
    public void save(FlashCardDto flashCardDto) {
        FlashCard flashCard = flashCardDto.map();

        repository.save(flashCard);
    }

    @Override
    public void update(FlashCardDto flashCardDto) {
        FlashCard flashCard = flashCardDto.map();
        repository.update(flashCard);
    }

    @Override
    public void delete(UUID id) {
        repository.delete(id);
    }
}
