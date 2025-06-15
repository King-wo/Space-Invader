/* ========================================================== */
 /*                  Bibliotheque MoteurDeJeu                  */
 /* --------------------------------------------               */
 /* Bibliotheque pour aider la création de jeu video comme :   */
 /* - Jeux de role                                             */
 /* - Jeux de plateforme                                       */
 /* - Jeux de combat                                           */
 /* - Jeux de course                                           */
 /* - Ancien jeu d'arcade (Pac-Man, Space Invider, Snake, ...) */
 /* ========================================================== */

/**
 *
 * @author Pierre-Frederic Villard
 */

import main.BouclePrincipale;
import afficheur.Afficheur;
import controle.ControleurClavier;
import physique.Monde;
import physique.MoteurPhysique;
import main.JeuPhysique;

public class testSpaceInvader {

    public static void main(String[] args) throws Exception {

        // le moteur physique
        MoteurPhysique moteurPhys;
        // le rendu
        Afficheur affiche;
        // le controleur
        ControleurClavier cClavier = new ControleurClavier(true);

        // Construction du monde
        Monde monMonde = new Monde();

        //////////////////////
        // Les MURS / Bords
        /////////////////////
        // bas
        monMonde.addMur(-10, -20, 620, 20);
        // haut
        monMonde.addMur(-10, 400, 620, 20);
        // gauche
        monMonde.addMur(-10, 0, 10, 400);
        // droite
        monMonde.addMur(600, 0, 10, 400);

        //////////////////////
        // Les ALIENS
        /////////////////////
        monMonde.addMonstre(0.5, 0, 100, 300);
        monMonde.addMonstre(0.5, 0, 200, 300);
        monMonde.addMonstre(0.5, 0, 300, 300);
        monMonde.addMonstre(0.5, 0, 400, 300);
        monMonde.addMonstre(0.5, 0, 500, 300);

        //////////////////////
        // Le Hero - vaisseau
        /////////////////////
        monMonde.balle.px = 300;
        monMonde.balle.py = 30;
        monMonde.balle.sprites.assignNewImage("Sprites/vaisseau.png");

        // on creer le moteur physique
        moteurPhys = new MoteurPhysique();
        // On ajoute le monde au moteur
        moteurPhys.monde = monMonde;
        // on creer l'afficheur du monde
        affiche = new Afficheur(moteurPhys.monde);
        // Changement du decor
        affiche.decor.changeImage("Sprites/Background.png");
        // Gestion de la boucle principale
        BouclePrincipale maBoucle = new BouclePrincipale();
        // Ajout du controleur a la fenetre
        maBoucle.cClavier = cClavier;
        // Ajout du jeu physique
        JeuPhysique MonJeuPhysique = new JeuPhysique();
        maBoucle.jeuPhysique = MonJeuPhysique;
        // Ajout de la vue au jeu
        maBoucle.jeuPhysique.affiche = affiche;
        // Ajout du jeu a la boucle
        maBoucle.jeuPhysique.moteurPhys = moteurPhys;

        maBoucle.lanceBouclePrincipale();
    }
}

