package com.theonionocean.learni.service.implementation;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.repository.CrudRepository;
import com.theonionocean.learni.repository.FlashCardDeckRelationRepository;
import com.theonionocean.learni.service.CrudService;
import com.theonionocean.learni.service.FlashCardDeckRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Qualifier("FlashCardServiceImpl")
public class FlashCardServiceImpl implements CrudService<FlashCardDto>, FlashCardDeckRelationService {

    CrudRepository<FlashCard> repository;
    FlashCardDeckRelationRepository flashCardDeckRelationRepository;

    @Autowired
    public FlashCardServiceImpl(@Qualifier("FlashCardRepositoryImpl") CrudRepository<FlashCard> repository, FlashCardDeckRelationRepository flashCardDeckRelationRepository) {
        this.repository = repository;
        this.flashCardDeckRelationRepository = flashCardDeckRelationRepository;
    }

    @Override
    public List<FlashCardDto> findAll() {
        return repository.findAll()
                .stream()
                .map(flashCard -> new FlashCardDto(flashCard.getId(), flashCard.getWord(), flashCard.getTranslation()))
                .toList();
    }

    @Override
    public FlashCardDto find(UUID id) {
        FlashCard flashCard = repository.find(id);

        return new FlashCardDto(flashCard.getId(), flashCard.getWord(), flashCard.getTranslation());
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

    @Override
    public List<FlashCardDto> findAllDeckFlashcards(UUID id) {
        return flashCardDeckRelationRepository.findAllDeckFlashcards(id)
                .stream()
                .map(flashCard -> new FlashCardDto(flashCard.getId(), flashCard.getWord(), flashCard.getTranslation()))
                .toList();
    }
}
