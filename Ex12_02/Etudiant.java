package Ex12_02;

public class Etudiant {
    private String nom;
    private String prenom;
    private String classe;

    public Etudiant(String pnom, String pprenom, String pclasse) {
        this.nom = pnom;
        this.prenom = pprenom;
        this.classe = pclasse;
    }

    public String toString() {
        return this.prenom + " " + this.nom + " (" + this.classe + ")";
    }

}
