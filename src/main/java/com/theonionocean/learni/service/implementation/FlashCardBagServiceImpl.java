package com.theonionocean.learni.service.implementation;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.repository.CrudRepository;
import com.theonionocean.learni.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
@Qualifier("FlashCardBagServiceImpl")
public class FlashCardBagServiceImpl implements CrudService<FlashCardDto> {

    CrudRepository<FlashCard> repository;

    @Autowired
    public FlashCardBagServiceImpl(@Qualifier("FlashCardBagRepositoryImpl") CrudRepository<FlashCard> repository) {
        this.repository = repository;
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
}
