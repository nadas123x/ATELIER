package com.example.atelier;

import java.util.LinkedList;

public class Etudiant
{
    String name,filiere,email,NumTel,purl;
    Etudiant()
    {

    }
    public Etudiant(String name, String filiere, String email,String NumTel,String purl) {
        this.name = name;
        this.filiere = filiere;
        this.email = email;
        this.purl = purl;

        this.NumTel=NumTel;
    }






    public String getNumTel() {
        return NumTel;
    }

    public void setNumTel(String numTel) {
        NumTel = numTel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getfiliere() {
        return filiere;
    }

    public void setfiliere(String filiere) {
        this.filiere = filiere;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPurl() {
        return purl;
    }

    public void setPurl(String purl) {
        this.purl = purl;
    }

}