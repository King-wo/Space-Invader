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
import physique.ObjetAlien;
import main.JeuPhysique;

public class testSpaceInvader {

    public static void main(String[] args) throws Exception {

        // le moteur physique
        MoteurPhysique moteurPhys;
        // le rendu
        Afficheur affiche;
        // le controler
        ControleurClavier cClavier = new ControleurClavier(true);

        // Construction du monde
        Monde monMonde = new Monde();

        // limites du terrain (murs gauche et droite)
        monMonde.addMur(0, -20, 20, 400);
        monMonde.addMur(580, -20, 20, 400);
        monMonde.addMur(0, -20, 600, 20); // sol

        // un héros pour observer
        monMonde.addHero(0, 0, 300, 20);

        // génération d'une grille d'aliens
        int cols = 8;
        int rows = 5;
        int startX = 60;
        int startY = 300;
        int spacingX = 40;
        int spacingY = 30;
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                monMonde.addAlien(startX + c * spacingX, startY - r * spacingY);
            }
        }

        // création du moteur
        moteurPhys = new MoteurPhysique();
        moteurPhys.monde = monMonde;
        // création de la vue
        affiche = new Afficheur(moteurPhys.monde);
        // Gestion de la boucle principale
        BouclePrincipale maBoucle = new BouclePrincipale();
        maBoucle.cClavier = cClavier;
        maBoucle.jeuPhysique = new JeuPhysique();
        maBoucle.jeuPhysique.affiche = affiche;
        maBoucle.jeuPhysique.moteurPhys = moteurPhys;

        maBoucle.lanceBouclePrincipale();
    }
}
