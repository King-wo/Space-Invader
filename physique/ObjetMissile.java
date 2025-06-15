package physique;

import java.awt.Color;
import java.awt.Graphics;

import afficheur.Repere;

/**
 * Missile tire par un heros ou un monstre.
 */
public class ObjetMissile extends Objet {

    /**
     * Cree un missile avec sa position et sa vitesse.
     * 
     * @param px position horizontale
     * @param py position verticale
     * @param vx vitesse horizontale
     * @param vy vitesse verticale
     */
    public ObjetMissile(double px, double py, double vx, double vy) {
        this.px = px;
        this.py = py;
        this.vx = vx;
        this.vy = vy;
        this.width = 5;
        this.height = 5;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.yellow);
        int[] tab = Repere.changeRepere(this);
        g.fillRect(tab[0], tab[1], tab[2], tab[3]);
    }
}
