package com.example.atelier;

import java.util.LinkedList;

public class Professeur
{
    String name,departement,email,NumTel,purl;
    Professeur()
    {

    }
    public Professeur(String name, String departement, String email,String NumTel,String purl) {
        this.name = name;
        this.departement = departement;
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

    public String getdepartement() {
        return departement;
    }

    public void setdepartement(String departement) {
        this.departement = departement;
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