package com.example.demo.dto;


public class ResultatDto {

    private int bonnesReponses;
    private int totalQuestions;
    private double note;

    public ResultatDto() {
    }

    public ResultatDto(int bonnesReponses,
                       int totalQuestions,
                       double note) {

        this.bonnesReponses = bonnesReponses;
        this.totalQuestions = totalQuestions;
        this.note = note;
    }

    public int getBonnesReponses() {
        return bonnesReponses;
    }

    public void setBonnesReponses(int bonnesReponses) {
        this.bonnesReponses = bonnesReponses;
    }

    public int getTotalQuestions() {
        return totalQuestions;
    }

    public void setTotalQuestions(int totalQuestions) {
        this.totalQuestions = totalQuestions;
    }

    public double getNote() {
        return note;
    }

    public void setNote(double note) {
        this.note = note;
    }
}
