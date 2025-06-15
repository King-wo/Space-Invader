/* ========================================================== */
/*                  Bibliotheque MoteurDeJeu                  */
/* --------------------------------------------               */
/* Bibliotheque pour aider la creation de jeu video comme :   */
/* - Jeux de role                                             */
/* - Jeux de plateforme                                       */
/* - Jeux de combat                                           */
/* - Jeux de course                                           */
/* - Ancien jeu d'arcade (Pac-Man, Space Invider, Snake, ...) */
/* ========================================================== */

package physique;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Un alien qui se deplace de maniere collective.
 */
public class ObjetAlien extends ObjetMonstre {

    /** vitesse horizontale commune a tous les aliens */
    public static double vitesse = 0.5;
    /** direction du mouvement horizontal : 1 a droite, -1 a gauche */
    public static int direction = 1;
    /** descente appliquee apres collision avec un bord */
    public static double pasDescente = 10;
    /** limite gauche de l'aire de jeu */
    public static double limiteGauche = 0;
    /** limite droite de l'aire de jeu */
    public static double limiteDroite = 600;

    /** liste des aliens presents */
    private static final ArrayList<ObjetAlien> groupe = new ArrayList<>();

    /** construit un alien par defaut */
    public ObjetAlien() throws IOException {
        super();
        vx = vitesse * direction;
        groupe.add(this);
    }

    /**
     * Deplacement specifique : tous les aliens partagent la meme direction.
     * Lorsqu'un alien atteint un bord, tout le groupe descend et change de
     * direction.
     */
    @Override
    public void evolue() {
        vx = vitesse * direction;
        update();
        if (px <= limiteGauche || px + width >= limiteDroite) {
            descenteEtInverse();
        }
    }

    /**
     * Fait descendre l'ensemble des aliens d'un pas et inverse leur direction.
     */
    private static void descenteEtInverse() {
        for (ObjetAlien a : groupe) {
            // annule le dernier deplacement horizontal
            a.px -= direction * vitesse;
            // deplacement vers le bas
            a.py -= pasDescente;
        }
        direction = -direction;
    }
}
