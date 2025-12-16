package com.example.ProfesseursClasse.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Classe {
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String niveau;
    private String matière;
    private int nombreEleves;

    @ManyToOne
    @JoinColumn(name= "professeur_id")
    @JsonBackReference
    private Professeur professeur;

    public Classe() {
    }

    public Classe(int nombreEleves, String matière, String niveau, String nom,Professeur professeur) {
        this.nombreEleves = nombreEleves;
        this.matière = matière;
        this.niveau = niveau;
        this.nom = nom;
        this.professeur=professeur;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNiveau() {
        return niveau;
    }

    public void setNiveau(String niveau) {
        this.niveau = niveau;
    }

    public String getMatière() {
        return matière;
    }

    public void setMatière(String matière) {
        this.matière = matière;
    }

    public int getNombreEleves() {
        return nombreEleves;
    }

    public void setNombreEleves(int nombreEleves) {
        this.nombreEleves = nombreEleves;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}