package com.theonionocean.learni.controller;

import com.deepl.api.DeepLException;
import com.deepl.api.Language;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import com.theonionocean.learni.dto.TranslationDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
public class TranslatorController {

    Translator translator;

    public TranslatorController(Translator translator) {
        this.translator = translator;
    }

    @GetMapping("/translate")
    private TranslationDto translate(@RequestParam(name = "word") String word, @RequestParam(name = "targetLang") String targetLang)
            throws DeepLException, InterruptedException {
        TextResult result = translator.translateText(word, null, targetLang);

        return new TranslationDto(word, result.getText());
    }

    @GetMapping("/targetLanguages")
    private List<Language> getTargetLanguages() throws DeepLException, InterruptedException {

        return translator.getTargetLanguages();
    }
}
