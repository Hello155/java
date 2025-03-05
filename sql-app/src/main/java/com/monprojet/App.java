package com.monprojet;

import java.util.Scanner;


public class App 
{
    public static void main( String[] args )
    {
        System.out.println("Hello");
        Connexion connexion = new Connexion();
        int choix = 0;
        Scanner sc = new Scanner(System.in);
        GestionUser gUser = new GestionUser();

        do {
            System.out.println("Que voulez vous faire ?");
            System.out.println("1 - Ajouter un utilisateur");
            System.out.println("2 - Afficher un utilisateur");
            System.out.println("3 - Supprimer un utilisateur");
            System.out.println("0 - quitter");

            switch (choix) {
                case 1:
                    
                    break;
            
                default:
                    System.out.println("L'action demandé n'existe pas !");
                    break;
        } while (choix != 0); 
            connexion.close();
            sc.close();      
            System.exit(status:0);
        }
    }
}