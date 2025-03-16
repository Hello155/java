package com.gestion_utilisateur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Vector;

public class GestionUser {
    
    /**
     * insert un nouvel utilisateur
     * @param connect
     * @param nom
     * @param email
     */
    public static void add(Connexion connect, String nom, String email) {
        try {
            String sqlInsert = "INSERT INTO utilisateur (nom, email,date_creation) VALUES (?, ?, ?)";
            PreparedStatement pstmtInsert = connect.connexion.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, nom);
            pstmtInsert.setString(2, email);
            Calendar aujourdhui = Calendar.getInstance();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            pstmtInsert.setString(3, formatDate.format(aujourdhui.getTime()));

            int rowsAffected = pstmtInsert.executeUpdate();
            System.out.println("Insertion réussie, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    /**
     * lit les utilisateurs en BD
     * @param connect
     * @return
     */
    public static Vector<Utilisateur> lister(Connexion connect) {
        Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>();
        try {
            String sqlSelect = "SELECT * FROM utilisateur";
            PreparedStatement pstmtSelect = connect.connexion.prepareStatement(sqlSelect);
            ResultSet rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Date dateCreation = rs.getDate("date_creation");
                Date dateUpdate = rs.getDate("date_update");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setDateCreation(dateCreation);
                utilisateur.setDateUpdate(dateUpdate);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return utilisateurs;
    }

    /**
     * lit un utilisateur
     * @param connect
     * @param idUtilisateur
     * @return
     */
    public static Utilisateur get(Connexion connect, int idUtilisateur) {
        Utilisateur utilisateur = new Utilisateur();
        try {
            String sqlSelect = "SELECT * FROM utilisateur WHERE id = ?";
            PreparedStatement pstmtSelect = connect.connexion.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idUtilisateur);
            ResultSet rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Date dateCreation = rs.getDate("date_creation");
                Date dateUpdate = rs.getDate("date_update");
                utilisateur.setId(id);
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setDateCreation(dateCreation);
                utilisateur.setDateUpdate(dateUpdate);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return utilisateur;
    }

    /**
     * supprimer un utilisateur en BD
     * @param connect
     * @param idUtilisateur
     */
    public static void supprimer(Connexion connect, int idUtilisateur) {
        try {
            String sqlInsert = "DELETE FROM utilisateur WHERE id = ?";
            PreparedStatement pstmtInsert = connect.connexion.prepareStatement(sqlInsert);
            pstmtInsert.setInt(1, idUtilisateur);

            int rowsAffected = pstmtInsert.executeUpdate();
            System.out.println("Suppression reussie, lignes affectees : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }

    /**
     * modifier un utilisateur en BD
     * @param connect
     * @param id
     * @param nom
     * @param email
     */
    public static void modifier(Connexion connect, int id, String nom, String email) {
        try {
            String sqlInsert = "UPDATE utilisateur SET nom = ?, email = ?, date_update = ? WHERE id = ?";
            PreparedStatement pstmtInsert = connect.connexion.prepareStatement(sqlInsert);
            pstmtInsert.setString(1, nom);
            pstmtInsert.setString(2, email);
            Calendar aujourdhui = Calendar.getInstance();
            SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
            pstmtInsert.setString(3, formatDate.format(aujourdhui.getTime()));
            pstmtInsert.setInt(4, id);

            int rowsAffected = pstmtInsert.executeUpdate();
            System.out.println("Mise a jour réussie, lignes affectées : " + rowsAffected);
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
    }
    
    /**
     * recherche des utilisateurs par mail en BD
     * @param connect
     * @param emailCherche
     * @return
     */
    public static Vector<Utilisateur> rechercherParMail(Connexion connect, String emailCherche) {
        Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>();
        try {
            String sqlSelect = "SELECT * FROM utilisateur WHERE email LIKE ?";
            PreparedStatement pstmtSelect = connect.connexion.prepareStatement(sqlSelect);
            pstmtSelect.setString(1, "%" + emailCherche + "%");
            ResultSet rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Date dateCreation = rs.getDate("date_creation");
                Date dateUpdate = rs.getDate("date_update");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setDateCreation(dateCreation);
                utilisateur.setDateUpdate(dateUpdate);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return utilisateurs;
    }

    /**
     * recherche des utilisateur par nom en BD
     * @param connect
     * @param nomCherche
     * @return
     */
    public static Vector<Utilisateur> rechercherParNom(Connexion connect, String nomCherche) {
        Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>();
        try {
            String sqlSelect = "SELECT * FROM utilisateur WHERE nom LIKE ?";
            PreparedStatement pstmtSelect = connect.connexion.prepareStatement(sqlSelect);
            pstmtSelect.setString(1, "%" + nomCherche + "%");
            ResultSet rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Date dateCreation = rs.getDate("date_creation");
                Date dateUpdate = rs.getDate("date_update");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setDateCreation(dateCreation);
                utilisateur.setDateUpdate(dateUpdate);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return utilisateurs;
    }

    /**
     * recherche des utilisateurs modifiés en BD
     * @param connect
     * @return
     */
    public static Vector<Utilisateur> rechercherModifie(Connexion connect) {
        Vector<Utilisateur> utilisateurs = new Vector<Utilisateur>();
        try {
            String sqlSelect = "SELECT * FROM utilisateur WHERE date_update IS NOT NULL";
            PreparedStatement pstmtSelect = connect.connexion.prepareStatement(sqlSelect);
            ResultSet rs = pstmtSelect.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                String email = rs.getString("email");
                Date dateCreation = rs.getDate("date_creation");
                Date dateUpdate = rs.getDate("date_update");
                Utilisateur utilisateur = new Utilisateur();
                utilisateur.setId(id);
                utilisateur.setNom(nom);
                utilisateur.setEmail(email);
                utilisateur.setDateCreation(dateCreation);
                utilisateur.setDateUpdate(dateUpdate);
                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getMessage());
        }
        return utilisateurs;
    }
}