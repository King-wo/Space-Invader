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
import miscellaneous.MurCool;
import afficheur.Afficheur;
import afficheur.Repere;
import controle.ControleurClavier;
import physique.Monde;
import physique.MoteurPhysique;
import physique.ObjetMur;
import afficheur.Sprites;
import main.JeuPhysique;
import miscellaneous.BouclePrincipaleCool;
import miscellaneous.MonMondeCool;

public class testMario {
    
    
    public static void main(String[] args) throws Exception {
        
    
        //le moteur physique
	MoteurPhysique moteurPhys;
	//le rendu
	Afficheur affiche;    
        //le controler
        ControleurClavier cClavier=new ControleurClavier(true);    
        

        
        
        // Construction du monde
        
        // Essai de changement d'apparence pour collisions
        MonMondeCool monMonde= new MonMondeCool();
        // Monde monMonde= new Monde();
         
        //////////////////////
        // Les MURS
        /////////////////////
        //gros block
        monMonde.addMur(100,20,50,50);

        //sol
        monMonde.addMur(0,-20,600,20);

        //mur vertical centre 
        //MurCool monMur=new MurCool(250,65,50,200);
        //monMonde.addObjet(monMur);
        monMonde.addMur(200,60,50,200);
        monMonde.addMur(0,00,20,1500);
        monMonde.addMur(800,00,1500,20);
        monMonde.addMur(0,150,50,20);

        monMonde.addMur(250,00,10,5);
        monMonde.addMur(280,60,100,20);
        monMonde.addMur(350,00,10,5);
        monMonde.addMur(450,0,50,5);


        monMonde.addMur(200,200,600,20);    
           
        //////////////////////
        // Les MONSTRES
        /////////////////////   
        monMonde.addMonstre(0.5,0,200,0);
        monMonde.addMonstre(-0.1,0,300,0);
            
        //////////////////////
        // Le Hero
        /////////////////////  
        
        
        //on creer le moteur physique
	moteurPhys=new MoteurPhysique(); 
        //On ajoute le monde au moteur
        moteurPhys.monde=monMonde;
	//on creer l'afficheur du monde
	affiche=new Afficheur(moteurPhys.monde);
        // Gestion de la boucle principale
        BouclePrincipale maBoucle= new BouclePrincipale();
        //BouclePrincipaleCool maBoucle= new BouclePrincipaleCool();
        // Ajout du controler à le fenêtre
        maBoucle.cClavier=cClavier;
        // Ajout du jeu physique
        JeuPhysique MonJeuPhysique = new JeuPhysique();
        maBoucle.jeuPhysique=MonJeuPhysique;       
        // Ajout de la vue au jeu
        maBoucle.jeuPhysique.affiche=affiche;
        

        // Ajout du jeu à la boucle
        maBoucle.jeuPhysique.moteurPhys=moteurPhys;
        // Change l'image de fond
        //affiche.decor.changeImage("background2.jpg");
        // Passage à une vue non subjective
        //Repere.isSubjective=false;
        
        // Test to change the image
        //monMonde.balle.sprites.assignNewImage("hero2.png");
        // Test to change the gravity value
        //moteurPhys.gravityValue=-0.4f;
        // Test to remove the gravity
        //moteurPhys.gravity=true;
        
        
        maBoucle.lanceBouclePrincipale();
    }
}
