package physique;

import java.awt.Color;
import java.awt.Graphics;
import afficheur.Repere;

/**
 * Projectile tiré par le héros
 */
public class ObjetTir extends Objet {

    public ObjetTir(double x, double y) {
        px = x;
        py = y;
        width = 2;
        height = 6;
        vx = 0;
        vy = 3;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.red);
        int[] tab = Repere.changeRepere(this);
        g.fillRect(tab[0], tab[1], tab[2], tab[3]);
    }
}
