package com.theonionocean.learni.controller;

import com.deepl.api.DeepLException;
import com.deepl.api.TextResult;
import com.deepl.api.Translator;
import com.theonionocean.learni.dto.TranslationDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class TranslatorController {

    Translator translator;

    @GetMapping("/translate")
    private TranslationDto translate(@RequestParam(name = "word") String word, @RequestParam(name = "targetLang") String targetLang)
            throws DeepLException, InterruptedException {
        String authKey = System.getenv("LEARNI_DEEPL_API_KEY");
        translator = new Translator(authKey);
        TextResult result = translator.translateText(word, null, targetLang);

        return new TranslationDto(word, result.getText());
    }
}
