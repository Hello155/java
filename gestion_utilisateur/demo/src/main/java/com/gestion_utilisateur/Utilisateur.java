package com.gestion_utilisateur;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Date;

public class Utilisateur {
    private int id;
    private String nom;
    private String email;
    private Calendar dateCreation;
    private Calendar dateUpdate;

    public void setId (int userId) {
        id = userId;
    }

    public int getId () {
        return id;
    }

    public void setNom (String userNom) {
        nom = userNom;
    }

    public String getNom () {
        return nom;
    }

    public void setEmail (String userEmail) {
        email = userEmail;
    }

    public String getEmail () {
        return email;
    }

    public void setDateCreation (Date userDateCreation) {
        if (userDateCreation != null) {
            dateCreation = Calendar.getInstance();
            dateCreation.setTime(userDateCreation);
        }
    }

    public Calendar getDateCreation () {
        return dateCreation;
    }

    public void setDateUpdate (Date userDateUpdate) {
        if (userDateUpdate != null) {
            dateUpdate = Calendar.getInstance();
            dateUpdate.setTime(userDateUpdate);
        }
    }

    public Calendar getDateUpdate () {
        return dateUpdate;
    }
}
