package com.theonionocean.learni.controller;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.service.CrudService;
import com.theonionocean.learni.service.FlashCardDeckRelationService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/flashCard")
public class FlashCardController {

    CrudService<FlashCardDto> flashCardService;
    FlashCardDeckRelationService flashCardDeckRelation;
    CrudService<FlashCardDto> flashCardBagService;

    public FlashCardController(@Qualifier("FlashCardServiceImpl") CrudService<FlashCardDto> flashCardService, FlashCardDeckRelationService flashCardDeckRelation, @Qualifier("FlashCardBagServiceImpl") CrudService<FlashCardDto> flashCardBagService) {
        this.flashCardService = flashCardService;
        this.flashCardDeckRelation = flashCardDeckRelation;
        this.flashCardBagService = flashCardBagService;
    }

    @GetMapping("/all")
    public List<FlashCardDto> findAll() {
        return flashCardService.findAll();
    }

    @GetMapping("/get/{id}")
    public FlashCardDto find(@PathVariable(name = "id") String requestId) {
        UUID id = UUID.fromString(requestId);

        return flashCardService.find(id);
    }

    @GetMapping("/get/deck/{deckId}")
    public List<FlashCardDto> findAllDeckFlashcards(@PathVariable(name = "deckId") String deckId) {
        UUID id = UUID.fromString(deckId);

        return flashCardDeckRelation.findAllDeckFlashcards(id);
    }

    @PostMapping("/create")
    public void save(@RequestBody FlashCardDto flashCardDto) {
        flashCardService.save(flashCardDto);
        flashCardBagService.delete(flashCardDto.getId());
    }

    @PutMapping("/update")
    public void update(@RequestBody FlashCardDto flashCardDto) {
        flashCardService.update(flashCardDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String requestId) {
        UUID id = UUID.fromString(requestId);

        flashCardService.delete(id);
    }
}
