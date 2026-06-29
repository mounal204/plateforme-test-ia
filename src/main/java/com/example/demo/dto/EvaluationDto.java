package com.example.demo.dto;

import java.util.List;

public class EvaluationDto {

    private List<ReponseEtudiantDto> reponses;

    public List<ReponseEtudiantDto> getReponses() {
        return reponses;
    }

    public void setReponses(List<ReponseEtudiantDto> reponses) {
        this.reponses = reponses;
    }
}

