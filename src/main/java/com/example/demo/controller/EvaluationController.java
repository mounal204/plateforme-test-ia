package com.example.demo.controller;

import com.example.demo.entity.Evaluationentity;

import jakarta.validation.Valid;

import com.example.demo.service.EvaluationService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationService service;

    public EvaluationController(EvaluationService service) {
        this.service = service;
    }

    @PostMapping
    public Evaluationentity create(
            @Valid @RequestBody Evaluationentity evaluation
    ) {
        return service.create(evaluation);
    }

    @GetMapping
    public List<Evaluationentity> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Evaluationentity getById(
            @PathVariable Long id
    ) {
        return service.getById(id);
    }

    @PutMapping("/{id}")
    public Evaluationentity update(
            @PathVariable Long id,
            @RequestBody Evaluationentity evaluation
    ) {
        return service.update(id, evaluation);
    }

    @DeleteMapping("/{id}")
    public void delete(
            @PathVariable Long id
    ) {
        service.delete(id);
    }
}