package com.example.demo.dto;

import java.util.List;

public class QcmRequestDto {

    private String sujet;
    private List<String> objectifs;
    private int nombreQuestions;

    public QcmRequestDto() {
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public List<String> getObjectifs() {
        return objectifs;
    }

    public void setObjectifs(List<String> objectifs) {
        this.objectifs = objectifs;
    }

    public int getNombreQuestions() {
        return nombreQuestions;
    }

    public void setNombreQuestions(int nombreQuestions) {
        this.nombreQuestions = nombreQuestions;
    }
}