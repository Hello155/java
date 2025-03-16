package com.gestion_utilisateur;

import java.text.SimpleDateFormat;
import java.util.Vector;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.event.EventHandler;

/**
 * class controller de la gestion des utilisateurs
 */
public class App extends Application {

/**
 * main
 * @param args
 */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * méthode javafx de lancement de la fenêtre
     */
    @Override
    public void start(Stage primaryStage) throws Exception {

        Scene scene = null;

        scene = setMenu(scene); // init scene par le menu

        primaryStage.setTitle("Gestion des utilisateurs");
        primaryStage.setScene(scene);
        primaryStage.show(); // affichage fenêtre
    }

    /**
     * affichage du menu
     * @param scene
     * @return
     * @throws Exception
     */
    private Scene setMenu (Scene scene) throws Exception {
        System.out.println("affichage menu");
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/menu.fxml"));

        VBox root = fxmlLoader.<VBox>load();

        // Créer ou récupère la scène
        if (scene == null) {
            scene = new Scene(root, 800, 600);
        } else {
            scene.setRoot(root);
        }
        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());

        return scene;
    }

    /**
     * action quitter l'application
     * @param event
     */
    @FXML protected void quitterAction (ActionEvent event) {
        System.out.println("quitter");
        Platform.exit();
    }

    /**
     * action affichage du formulaire de création d'un utilisateur
     * @param event
     * @throws Exception
     */
    @FXML protected void creerFormAction (ActionEvent event) throws Exception {
        System.out.println("affichage formulaire creer");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        setFormCreer(scene);
    }

    /**
     * action affichage du formulaire de recherche par mail
     * @param event
     * @throws Exception
     */
    @FXML protected void rechercherParMailFormAction (ActionEvent event) throws Exception {
        System.out.println("affichage formulaire rechercher par mail");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        setFormRechercherParMail(scene);
    }

    /**
     * action affichage du formulaire par nom
     * @param event
     * @throws Exception
     */
    @FXML protected void rechercherParNomFormAction (ActionEvent event) throws Exception {
        System.out.println("affichage formulaire rechercher par nom");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        setFormRechercherParNom(scene);
    }

    /**
     * action création d'un utilisateur
     * @param event
     * @throws Exception
     */
    @FXML protected void creerAction (ActionEvent event) throws Exception {
        System.out.println("creer");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        // récupération des valeurs saisies
        String nom = ((TextField)scene.lookup("#nom")).getText();
        String email = ((TextField)scene.lookup("#email")).getText();
        Connexion connexion = new Connexion();
        GestionUser.add(connexion, nom, email); // enregistrement en BD
        connexion.close();
        setMenu(scene);
    }

    /**
     * action recherche par mail
     * @param event
     * @throws Exception
     */
    @FXML protected void rechercherParMailAction (ActionEvent event) throws Exception {
        System.out.println("rechercher par mail");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        String email = ((TextField)scene.lookup("#email")).getText();
        Connexion connexion = new Connexion();
        Vector<Utilisateur> utilisateurs = GestionUser.rechercherParMail(connexion, email); // recherche par mail
        connexion.close();

        setListe(scene, utilisateurs); // affichage de la liste des utilisateurs
    }

    /**
     * action recherche par nom
     * @param event
     * @throws Exception
     */
    @FXML protected void rechercherParNomAction (ActionEvent event) throws Exception {
        System.out.println("rechercher par nom");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        String nom = ((TextField)scene.lookup("#nom")).getText();
        Connexion connexion = new Connexion();
        Vector<Utilisateur> utilisateurs = GestionUser.rechercherParNom(connexion, nom); // recherche par nom
        connexion.close();

        setListe(scene, utilisateurs); // affichage de la liste des utilisateurs
    }

    /**
     * action recherche des utilisateurs modifiés
     * @param event
     * @throws Exception
     */
    @FXML protected void rechercherModifieAction (ActionEvent event) throws Exception {
        System.out.println("rechercher modifie");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        Connexion connexion = new Connexion();
        Vector<Utilisateur> utilisateurs = GestionUser.rechercherModifie(connexion); // recherche des utilisateurs modifies
        connexion.close();

        setListe(scene, utilisateurs); // affichage de la liste des utilisateurs
    }

    /**
     * action mise à jour d'un utilisateur
     * @param event
     * @throws Exception
     */
    @FXML protected void updateAction (ActionEvent event) throws Exception {
        System.out.println("modifier");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        // récupération des valeurs saisies
        int id = Integer.parseInt(((TextField)scene.lookup("#id")).getText());
        String nom = ((TextField)scene.lookup("#nom")).getText();
        String email = ((TextField)scene.lookup("#email")).getText();
        Connexion connexion = new Connexion();
        GestionUser.modifier(connexion, id, nom, email); // modif d'un utilisateur en BD
        connexion.close();
        setMenu(scene);
    }

    /**
     * action navigation vers menu
     * @param event
     * @throws Exception
     */
    @FXML protected void menuAction (ActionEvent event) throws Exception {
        System.out.println("menu");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();
        setMenu(scene);
    }

    /**
     * action liste des utilisateurs
     * @param event
     * @throws Exception
     */
    @FXML protected void listerAction (ActionEvent event) throws Exception {
        System.out.println("lister");
        Node source = (Node) event.getSource();
        Scene scene = source.getScene();

        Connexion connexion = new Connexion();
        Vector<Utilisateur> utilisateurs = GestionUser.lister(connexion); // lecture de tous les utilsateurs en BD
        connexion.close();

        setListe(scene, utilisateurs); // affichage des utilisateurs
    }

    /**
     * méthode complète la vue lister.fxml (liste des utilisateurs) et affichage des utilisateurs (liste et recherches)
     * @param scene
     * @param utilisateurs
     * @throws Exception
     */
    private void setListe (Scene scene, Vector<Utilisateur> utilisateurs) throws Exception {
        System.out.println("affichage lister");
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/lister.fxml"));

        GridPane root = fxmlLoader.<GridPane>load();

        Label idTitre = new Label();
        idTitre.setText("id");
        root.add(idTitre, 0, 0);
        Label nomTitre = new Label();
        nomTitre.setText("nom");
        root.add(nomTitre, 1, 0);
        Label emailTitre = new Label();
        emailTitre.setText("email");
        root.add(emailTitre, 2, 0);
        Label dateCreationitre = new Label();
        dateCreationitre.setText("date creation");
        root.add(dateCreationitre, 3, 0);
        Label dateUpdateTitre = new Label();
        dateUpdateTitre.setText("date update");
        root.add(dateUpdateTitre, 4, 0);


        for (Integer i = 0; i < utilisateurs.size(); i++)
        {
            Label id = new Label();
            id.setText(Integer.toString(utilisateurs.get(i).getId())); 
            root.add(id, 0, i+1);
            Label nom = new Label();
            nom.setText(utilisateurs.get(i).getNom()); 
            root.add(nom, 1, i+1);
            Label email = new Label();
            email.setText(utilisateurs.get(i).getEmail()); 
            root.add(email, 2, i+1);
            Label dateCreation = new Label();
            SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy");
            dateCreation.setText(formatDate.format(utilisateurs.get(i).getDateCreation().getTime())); 
            root.add(dateCreation, 3, i+1);
            Label dateUpdate = new Label();
            if (utilisateurs.get(i).getDateUpdate() != null) {
                dateUpdate.setText(formatDate.format(utilisateurs.get(i).getDateUpdate().getTime())); 
            } else {
                dateUpdate.setText("-");
            }
            root.add(dateUpdate, 4, i+1);
            Button update = new Button();
            update.setId("update_" + utilisateurs.get(i).getId());
            // bouton et action de mise à jour de chaque utilisateur
            update.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Button button = (Button)event.getSource();
                        String[] tokens = button.getId().split("_");
                        int idUtilisateur = Integer.parseInt(tokens[1]);
                        setFormUpdate(button.getScene(), idUtilisateur);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            update.setText("update");
            root.add(update, 5, i+1);
            Button supprimer = new Button();
            supprimer.setId("supprimer_" + utilisateurs.get(i).getId());
            // bouton et action de suppression de chaque utilisateur
            supprimer.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    try {
                        Button button = (Button)event.getSource();
                        String[] tokens = button.getId().split("_");
                        int idUtilisateur = Integer.parseInt(tokens[1]);
                        supprimerAction(button.getScene(), idUtilisateur);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            });
            supprimer.setText("supprimer");
            root.add(supprimer, 6, i+1);
        }

        // Créer la scène et afficher la fenêtre
        scene.setRoot(root);

        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());

    }

    /**
     * méthode supprssion d un utilisateur
     * @param scene
     * @param idUtilisateur
     * @throws Exception
     */
    private void supprimerAction (Scene scene, int idUtilisateur) throws Exception {
        System.out.println("supprimer");
        Connexion connexion = new Connexion();
        GestionUser.supprimer(connexion, idUtilisateur); // suppression de l'utilisateur en BD
        setMenu(scene);
    }

    /**
     * méthode formulaire de création de l utilisateur
     * @param scene
     * @throws Exception
     */
    private void setFormCreer (Scene scene) throws Exception {
        System.out.println("formulaire creer");
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/creer.fxml"));

        GridPane root = fxmlLoader.<GridPane>load();

        // Créer la scène et afficher la fenêtre
        scene.setRoot(root);

        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());
        
    }

    /**
     * méthode formulaire de recherche par mail
     * @param scene
     * @throws Exception
     */
    private void setFormRechercherParMail (Scene scene) throws Exception {
        System.out.println("formulaire rechercher par mail");
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/rechercherParMail.fxml"));

        GridPane root = fxmlLoader.<GridPane>load();

        // Créer la scène et afficher la fenêtre
        scene.setRoot(root);

        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());
        
    }

    /**
     * méthode formulaire de recherche par nom
     * @param scene
     * @throws Exception
     */
    private void setFormRechercherParNom (Scene scene) throws Exception {
        System.out.println("formulaire rechercher par nom");
        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/rechercherParNom.fxml"));

        GridPane root = fxmlLoader.<GridPane>load();

        // Créer la scène et afficher la fenêtre
        scene.setRoot(root);

        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());
        
    }

    /**
     * méthode formulaire de mise à jour d un utilisateur
     * @param scene
     * @param idUtilisateur
     * @throws Exception
     */
    private void setFormUpdate (Scene scene, int idUtilisateur) throws Exception {
        System.out.println("formulaire modifier");
        Connexion connexion = new Connexion();
        Utilisateur utilisateur = GestionUser.get(connexion, idUtilisateur); // lecture de l'utilisateur en BD pour remplir les champs de modifications
        connexion.close();

        FXMLLoader fxmlLoader = new FXMLLoader();

        fxmlLoader.setLocation(getClass().getResource("/update.fxml"));

        GridPane root = fxmlLoader.<GridPane>load();

        // Créer la scène et afficher la fenêtre
        scene.setRoot(root);
        TextField idForm = (TextField)scene.lookup("#id");
        idForm.setText(Integer.toString(utilisateur.getId()));
        idForm.setEditable(false);
        ((TextField)scene.lookup("#nom")).setText(utilisateur.getNom());
        ((TextField)scene.lookup("#email")).setText(utilisateur.getEmail());

        scene.getStylesheets().add(getClass()
        .getResource("/styles.css")
        .toExternalForm());
        
    }
}