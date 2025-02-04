import java.util.Scanner;

public class moyenne {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int moyenne=0;
        for (int i=0; i<5; i++) {
            System.out.print("Entrez un nombre : ");
            int nb = scanner.nextInt();
            moyenne = moyenne + nb;
            int a, max, min;
            if (i == 0  ) {
                a = nb;
            }
            if (a < nb) {
                max = a;
            }
            if (a > nb) {
                
            }
        }
        moyenne = moyenne / 5;
        System.out.println("la moyenne est : " + moyenne + "!");



        scanner.close();
    }
}