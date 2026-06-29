package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.EvaluationDto;
import com.example.demo.dto.QcmRequestDto;
import com.example.demo.model.Question;
import com.example.demo.service.EvaluationService;
import com.example.demo.service.GroqService;


@CrossOrigin(origins = "http://localhost:51245/")
@RestController
@RequestMapping("/api/ai")
public class AiController {


    private final EvaluationService evaluationService;
    private final GroqService groqService;



    public AiController(
            EvaluationService evaluationService,
            GroqService groqService) {

        this.evaluationService = evaluationService;
        this.groqService = groqService;
    }



    @PostMapping("/generate")
    public List<Question> generate(
            @RequestBody QcmRequestDto request) {

        String prompt =
                evaluationService.buildPrompt(request);

        String response =
                groqService.generateContent(prompt);

        String json =
                groqService.extractContent(response);

        List<Question> questions =
                evaluationService.convertAiResponse(json);

        evaluationService.saveQuestions(questions);

        return questions;
    }




    @PostMapping("/test-groq")
    public String testGroq() {


        return groqService.generateContent(
                "Explique l'héritage en Java en 2 phrases."
        );

    }






    @PostMapping("/corriger")
    public Object corriger(
            @RequestBody EvaluationDto evaluation) {


        try {

            return evaluationService.corriger(evaluation);


        } catch(Exception e) {


            e.printStackTrace();


            return e.getMessage();

        }

    }


}