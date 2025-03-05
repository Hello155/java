package Ex1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Voiture voiture = new Voiture();

        System.out.println("Entrez la couleur de la voiture parmis les couleurs " +voiture.couleurAutorise[0] +"," +voiture.couleurAutorise[1] +"," +voiture.couleurAutorise[2] +" : ");
        voiture.couleur = scanner.nextLine();
        boolean found = false;

        for(String color : voiture.couleurAutorise) {
            if(color.equals(color)) {
                voiture.couleur = color;
                found = true;
                break;
            }
        }

        if(!found) {
            System.out.println("Erreur dans la saisie de la couleur !");
            System.exit(1);
        }
        
        voiture.couleur = "Rouge";
        voiture.marque = "Toyota";
        voiture.modele = "corrolla";

        voiture.demarrer();
    }
}
