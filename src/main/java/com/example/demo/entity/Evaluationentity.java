package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "evaluations")
public class Evaluationentity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String objectif;

    // Constructeur vide
    public Evaluationentity() {
    }

    // Constructeur
    public Evaluationentity(
            Long id,
            String titre,
            String objectif
    ) {
        this.id = id;
        this.titre = titre;
        this.objectif = objectif;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }
}