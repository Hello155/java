package Ex12_02;

import java.util.Iterator;
import java.util.ArrayList;

public class GestionEtudiants {

    private ArrayList<Etudiant> etudiants;

    public GestionEtudiants() {
        etudiants = new ArrayList<>();
    }

    public void ajouter (Etudiant etudiant) {
        etudiants.add(etudiant);
    }

    public void afficher () {
        for (Etudiant etudiant : etudiants) {
            System.out.println(etudiant);
        }
    }

    public int nombreEtudiants () {
        return etudiants.size();
    }
}
