package com.theonionocean.learni.controller;

import com.theonionocean.learni.dto.FlashCardDto;
import com.theonionocean.learni.entity.FlashCard;
import com.theonionocean.learni.service.CrudService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/v1/flashCardBag")
public class FlashCardBagController {

    CrudService<FlashCardDto> flashCardService;

    public FlashCardBagController(@Qualifier("FlashCardBagServiceImpl") CrudService<FlashCardDto> flashCardService) {
        this.flashCardService = flashCardService;
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
