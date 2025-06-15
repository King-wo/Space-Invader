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

package afficheur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.InputStream;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import controle.Controle;

import physique.ObjetHeros;

//distributeur de sprites

/**
 *
 * @author Pierre-Frederic Villard
 */
public class SpritesHeros extends Sprites {

	ObjetHeros heros;
        String imageFile="hero.png";

	// constructeur de table de sprites

    /**
     *
     * @param b
     * @throws IOException
     */
	public SpritesHeros(ObjetHeros b) throws IOException {
		this.heros = b;

                try (InputStream is = getClass().getClassLoader().getResourceAsStream(imageFile)) {
                        if (is == null) {
                                throw new IOException("Resource not found: " + imageFile);
                        }
                        im = ImageIO.read(is);
                }
		activite = "fixe";
		sprites = new HashMap<String, Sprite>();
		sprites.put("fixe", new Sprite(0, 0, im.getWidth(), im.getHeight()));

	}

	// afficheur de sprite
	public void affiche(int x, int y, Graphics g) {
		//Sprite s = sprites.get(chaine());
                Sprite s = sprites.get("fixe");
		if (s == null)
			s = sprites.get("erreur");

		// regarde la direction du personnage

		if (heros.vx >= 0) {
			//affichage normal
			g.drawImage(im, x, y, x + s.tx, y + s.ty, s.xmin, s.ymin, s.xmax,
					s.ymax, null);
		}
		else {
			//inverse gauche et droite
			g.drawImage(im,  x + s.tx, y,x,y + s.ty,  s.xmin, s.ymin, s.xmax,
					s.ymax, null);
		}

	}

    /**
     *
     */
    @Override
	public void anime() {
		iteration++;

		if (activite.equals("fixe")) {

		}
		
		if (activite.equals("saut")) {

		}

		if (activite.equals("course")) {
			if (iteration > 9) {
				num++;
				iteration = 0;
			}

			if (num > 9)
				num = 0;
		}

	}

}
