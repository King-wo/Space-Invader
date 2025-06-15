package afficheur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;


//distributeur de sprites
public class DecorVariable {
	
	//IMage
	BufferedImage im;
	
	//taille
	int wx,wy;
	
	//construit le sprite
	public DecorVariable() 
	{
                try (InputStream is = getClass().getClassLoader().getResourceAsStream("Background.jpg")) {
                        if (is == null) {
                                throw new IOException("Resource not found: Background.jpg");
                        }
                        im = ImageIO.read(is);
                } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        System.out.println("erreur lecture background");
                }
		wx=im.getWidth();
		wy=im.getHeight();
	}
	
        public void changeImage(String image)
        {
                try (InputStream is = getClass().getClassLoader().getResourceAsStream(image)) {
                        if (is != null) {
                                im = ImageIO.read(is);
                        } else {
                                im = ImageIO.read(new File(image));
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                        System.out.println("erreur lecture background");
                }
                wx=im.getWidth();
                wy=im.getHeight();
        }
	
	//afficheur de decor
	//declae en x seulement
	public void affiche(int x,Graphics g)
	{
            if (Repere.isSubjective)
            {
		//on se ramene au repere du plan
		x=(x%wx);
		
		//on affiche sur l'ecran 0 ==> wx-x  image source de x � wx   
		g.drawImage(im, 0 ,0 , wx-x, wy, x, 0, wx, wy,null);
		
		//on affiche sur l'ecran wx-x ==> wx  image source de 0 � x   
		g.drawImage(im, wx-x ,0 , wx, wy, 0, 0, x, wy,null);
            }
            else{
                g.drawImage(im,0 ,0 , wx, wy, 0, 0, wx, wy,null);
            }
		
	}
	
	
}
