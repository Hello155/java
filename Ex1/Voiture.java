package Ex1;

public class  Voiture {

    public String[] couleurAutorise = {"Blanc", "Noir", "Gris"};
    public String marque;
    public String modele;
    public String couleur;

    public void demarrer () {
        System.out.println("La voiture a démarrer !");
    }
    public void freiner () {
        System.out.println("La voiture a freiner !");
    }
    public void accelerer () {
        System.out.println("La voiture a accelere !");
    }
}