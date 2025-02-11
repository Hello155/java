package Teste;
import java.util.Scanner;

public class Moyenne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double moyenne = 0; // Utilisation d'un double pour éviter la troncature
        int max = Integer.MIN_VALUE; // Initialisation avec la plus petite valeur possible
        int min = Integer.MAX_VALUE; // Initialisation avec la plus grande valeur possible

        for (int i = 0; i < 5; i++) {
            System.out.print("Entrez un nombre : ");
            int nb = scanner.nextInt();
            moyenne += nb;

            // Mise à jour de max et min
            if (nb > max) {
                max = nb;
            }
            if (nb < min) {
                min = nb;
            }
        }
        int median = max - min;

        moyenne /= 5; // Calcul de la moyenne

        // Affichage des résultats
        System.out.println("La moyenne est : " + moyenne);
        System.out.println("La median est : " + median);
        System.out.println("Le minimum est : " + min);

        scanner.close();
    }
}
