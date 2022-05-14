package com.example.atelier.modele;

import java.util.LinkedList;

public class Groupe {
    private String Titre;
    private String Description;
    LinkedList<Etudiant> liste_etudiants;

    public Groupe(String titre, String description, LinkedList<Etudiant> liste_etudiants) {
this.Titre=new String(Titre);
this.Description=new String(Description);
    Description = description;
        this.liste_etudiants = liste_etudiants;
    }

    public String getTitre() {
        return Titre;
    }

    public void setTitre(String titre) {
        Titre = titre;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public LinkedList<Etudiant> getListe_etudiants() {
        return liste_etudiants;
    }

    public void setListe_etudiants(LinkedList<Etudiant> liste_etudiants) {
        this.liste_etudiants = liste_etudiants;
    }
}
