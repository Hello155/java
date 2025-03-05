package Ex12_02;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        GestionEtudiants gestion = new GestionEtudiants();
        System.out.println("nb étudiants = " + gestion.nombreEtudiants());

        Scanner sc = new Scanner(System.in);
        int choix = 0;
        do {
            System.out.println("Que voulez vous faire ?");
            System.out.println("1-Ajouter un étudiant");
            System.out.println("2-Voir les étudiants");
            System.out.println("3-Quitter");
            choix = sc.nextInt();
            sc.nextLine();

            if (choix == 1) {
                System.out.print("Entrez votre nom : ");
                String nom = sc.nextLine();
                System.out.print("Entrez votre prenom : ");
                String prenom = sc.nextLine();
                System.out.print("Entrez votre classe : ");
                String classe = sc.nextLine();
                Etudiant etudiant = new Etudiant(nom, prenom, classe);
                System.out.print(etudiant.toString());
                sc.nextLine();
                gestion.ajouter(etudiant);
                System.out.println("nb étudiants = " + gestion.nombreEtudiants());
        
            } else if (choix == 2) {
                if (gestion.nombreEtudiants() == 0) {
                    System.out.println("Aucun etudiant est enregistre.");
                } else {
                    System.out.println("Liste des etudiants :");
                    gestion.afficher();
                }
            }
        
        } while (choix != 3 );
        sc.close();
    }
}
