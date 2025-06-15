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

package physique;

import java.io.IOException;
import java.util.ArrayList;

import afficheur.Repere;
import controle.Controle;

//gere les objets du monde

/**
 *
 * @author Pierre-Frederic Villard
 */
public class Monde {


    /**
     * le controleur
     */
	public Controle c;
	

    /**
     *la balle pour une vue subjective
     */
        public ObjetHeros balle;
	

    /**
     *les murs
     */
	public ArrayList<Objet> objets=new ArrayList<Objet>();
	
        
        public int nbMurs=0;

    /**
     * les monstres
     */
        public ArrayList<ObjetMonstre> monstres=new ArrayList<ObjetMonstre>();

        /**
         * missiles tires par le heros
         */
        public ArrayList<ObjetMissile> missilesHeros = new ArrayList<ObjetMissile>();

        /**
         * missiles tires par les monstres
         */
        public ArrayList<ObjetMissile> missilesAliens = new ArrayList<ObjetMissile>();
	

        public int nbHeros=0;

    /**
     * les heros
     */
        public ArrayList<ObjetHeros> heros=new ArrayList<ObjetHeros>();

        /** score du joueur */
        public int score = 0;

        /** nombre de vies disponibles */
        public int vies = 3;

        public int nbMonstres=0;
    /**
     *
     * @throws IOException
     */
            /**
     *un monde par defaut
     * @throws java.io.IOException
     */
	public Monde() throws IOException
	{
		//getsion du controleur
		balle=new ObjetHeros();
		
                //gere la vision subjective
                Repere.h=balle;

                score = 0;
                vies = 3;

	}
	
        /** Ajouter un mur
     * @param x
     * @param y
     * @param dx
     * @param dy */
	public void addMur(int x, int y, int dx, int dy){
            objets.add(new ObjetMur(x,y,dx,dy));
            objets.get(nbMurs).index=nbMurs;
            nbMurs++;
            
        }
        
        /** ajouter monstre
     * @param vx
     * @param vy
     * @param px
     * @param py
     * @throws java.io.IOException */
        public void addMonstre(double vx, double vy, int px, int py) throws IOException{
            monstres.add(new ObjetMonstre());
            //penser a le lier au monde
            monstres.get(nbMonstres).m=this;
            // propriétés du monstre
            monstres.get(nbMonstres).vx=vx;
            monstres.get(nbMonstres).vy=vy;
            monstres.get(nbMonstres).px=px;
            monstres.get(nbMonstres).py=py;
            monstres.get(nbMonstres).index=nbMonstres;

            nbMonstres++;
        }

        /** ajouter un alien
     * @param px
     * @param py
     * @throws java.io.IOException */
        public void addAlien(int px, int py) throws IOException{
            ObjetAlien a = new ObjetAlien();
            monstres.add(a);
            a.m=this;
            a.px=px;
            a.py=py;
            a.index=nbMonstres;
            nbMonstres++;
        }
        
        public void addObjet(Objet monObjet){ 
            objets.add(monObjet);
        }
             
                /** ajouter heros
     * @param vx
     * @param vy
     * @param px
     * @param py
     * @throws java.io.IOException */
        public void addHero(double vx, double vy, int px, int py) throws IOException{
            heros.add(new ObjetHeros(px, py));
            // propriétés du monstre
            heros.get(nbHeros).vx=vx;
            heros.get(nbHeros).vy=vy;
            heros.get(nbHeros).px=px;
            heros.get(nbHeros).py=py;
            heros.get(nbHeros).index=nbHeros;

            nbHeros++;
        }

        /** ajouter un missile du heros */
        public void addMissileHero(double px, double py, double vx, double vy){
            missilesHeros.add(new ObjetMissile(px, py, vx, vy));
        }

        /** ajouter un missile alien */
        public void addMissileAlien(double px, double py, double vx, double vy){
            missilesAliens.add(new ObjetMissile(px, py, vx, vy));
        }
}

