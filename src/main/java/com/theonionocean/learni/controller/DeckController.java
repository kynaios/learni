package com.theonionocean.learni.controller;

import com.theonionocean.learni.dto.DeckDto;
import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.service.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/deck")
public class DeckController {

    CrudService<DeckDto> deckService;

    public DeckController(@Qualifier("DeckServiceImpl") CrudService<DeckDto> deckService) {
        this.deckService = deckService;
    }

    @GetMapping("/all")
    public List<DeckDto> findAll() {
        return deckService.findAll();
    }

    @GetMapping("/get/{id}")
    public DeckDto find(@PathVariable(name = "id") String requestId) {
        UUID id = UUID.fromString(requestId);

        return deckService.find(id);
    }

    @PostMapping("/create")
    public void save(@RequestBody DeckDto deckDto) {
        deckService.save(deckDto);
    }

    @PutMapping("/update")
    public void update(@RequestBody DeckDto deckDto) {
        deckService.update(deckDto);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable(name = "id") String requestId) {
        UUID id = UUID.fromString(requestId);

        deckService.delete(id);
    }
}
