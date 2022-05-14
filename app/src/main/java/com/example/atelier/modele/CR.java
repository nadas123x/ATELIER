package com.example.atelier.modele;

import java.util.LinkedList;

public class CR {
     String heure;
     String description;
     LinkedList<Etudiant> liste_absents; // f chaque creneau j'ajoute les eleves absents.

     public CR(String heure, String description, LinkedList<Etudiant> liste_absents) {
          this.heure = heure;
          this.description = description;
          this.liste_absents = liste_absents;
     }

     public String getHeure() {
          return heure;
     }

     public void setHeure(String heure) {
          this.heure = heure;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public LinkedList<Etudiant> getListe_absents() {
          return liste_absents;
     }

     public void setListe_absents(LinkedList<Etudiant> liste_absents) {
          this.liste_absents = liste_absents;
     }
}
