package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class QuestionEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String question;

    private String choixA;

    private String choixB;

    private String choixC;

    private String choixD;

    private String bonneReponse;

    public QuestionEntity() {
    }

    public Long getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getChoixA() {
        return choixA;
    }

    public void setChoixA(String choixA) {
        this.choixA = choixA;
    }

    public String getChoixB() {
        return choixB;
    }

    public void setChoixB(String choixB) {
        this.choixB = choixB;
    }

    public String getChoixC() {
        return choixC;
    }

    public void setChoixC(String choixC) {
        this.choixC = choixC;
    }

    public String getChoixD() {
        return choixD;
    }

    public void setChoixD(String choixD) {
        this.choixD = choixD;
    }

    public String getBonneReponse() {
        return bonneReponse;
    }

    public void setBonneReponse(String bonneReponse) {
        this.bonneReponse = bonneReponse;
    }
}