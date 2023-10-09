package com.theonionocean.learni.controller;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.service.FlashCardService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/flashCard")
public class FlashCardController {
    FlashCardService flashCardService;

    public FlashCardController(FlashCardService flashCardService) {
        this.flashCardService = flashCardService;
    }

    @GetMapping("/all")
    public List<FlashCard> findAll() {
        return flashCardService.findAll();
    }

    @GetMapping("/get/{id}")
    public FlashCard find(@PathVariable(name = "id") String requestId) {
        UUID id = UUID.fromString(requestId);

        return flashCardService.find(id);
    }

    @PostMapping("/create")
    public void save(@RequestBody FlashCardDto flashCardDto) {
        flashCardService.save(flashCardDto);
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
