import java.util.Scanner;

public class Ask {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entrez votre nom : ");
        String nom = scanner.nextLine();

        System.out.println("Bonjour, " + nom + "!");

        System.out.print("Entrez votre age : ");
        int age = scanner.nextInt();

        System.out.println("Vous avez " + age + "!");

        if (age < 18) {
            System.out.println("Vous etes mineur!");
        }
        else{
            System.out.println("Vous etes majeur!");
        }
        scanner.close();
    }
}