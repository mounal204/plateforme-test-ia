package com.example.demo.dto;

public class ReponseEtudiantDto {

    private Long questionId;
    private String reponseChoisie;

    public Long getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Long questionId) {
        this.questionId = questionId;
    }

    public String getReponseChoisie() {
        return reponseChoisie;
    }

    public void setReponseChoisie(String reponseChoisie) {
        this.reponseChoisie = reponseChoisie;
    }
}