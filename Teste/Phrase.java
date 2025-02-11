package Teste;
import java.util.Scanner;

public class Phrase {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez un texte : ");
        String phrase = scanner.nextLine();
        int nb = phrase.length();

        System.out.println("Bonjour, le nombre de caractere dans la phrase est de " + nb);

        int nbs;
        for(int i=0; i<phrase.length(); i++) {
            if (Phrase.length() = " ")
            nbs++;
        }
        nbs = nbs + 1;
        System.out.println("Bonjour, le nombre de mots dans la phrase est de " + nbs);

        scanner.close();
    }
}