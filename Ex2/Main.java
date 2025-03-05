package Ex2;

public class Main {
    public static void Main(String[] args) {
        CompteBancaire compte1 = new CompteBancaire("Erwan NICOLAS", 2);
        compte1.deposer(10000);
        compte1.retirer(7);
        System.out.println("vous avez " + compte1.solde + " sur votre compte");
    }
}

