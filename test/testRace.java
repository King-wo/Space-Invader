
import afficheur.Afficheur;
import controle.ControleurClavier;
import main.BouclePrincipale;
import physique.Monde;
import physique.MoteurPhysique;

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
public class testRace {
    public static void main(String[] args) throws Exception {
        
    
        //le moteur physique
	MoteurPhysique moteurPhys;
	//le rendu
	Afficheur affiche;    
        //le controler
        ControleurClavier cClavier=new ControleurClavier(true);    
        //Le monde
        Monde monMonde;
        

        
        
        // Construction du monde
        monMonde= new Monde();
          
        //////////////////////
        // Les MURS
        /////////////////////

        //sol
        monMonde.addMur(-200,-20,1000,20);

   
            
        //////////////////////
        // Le Hero
        /////////////////////  
        monMonde.addHero(0,0,500,20);
        
        
        
        //on creer le moteur physique
	moteurPhys=new MoteurPhysique(); 
        moteurPhys.gravity=false;
        //On ajoute le monde au moteur
        moteurPhys.monde=monMonde;
	//on creer l'afficheur du monde
	affiche=new Afficheur(moteurPhys.monde);
        // Gestion de la boucle principale
        BouclePrincipale maBoucle= new BouclePrincipale();
        // Ajout du controler à le fenêtre
        maBoucle.cClavier=cClavier;
        // Ajout de la vue au jeu
        maBoucle.jeuPhysique.affiche=affiche;
        // Ajout du jeu à la boucle
        maBoucle.jeuPhysique.moteurPhys=moteurPhys;
        
        
        
        maBoucle.lanceBouclePrincipale();
    }
}
