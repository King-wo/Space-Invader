package afficheur;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.File;
import java.util.HashMap;

import javax.imageio.ImageIO;


//distributeur de sprites
public class DecorFixe {
	
	//IMage
	BufferedImage im;
	
	//taille
	int wx,wy;
	
	//construit le sprite
	public DecorFixe() 
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
        
	//afficheur de sprite
	public void affiche(Graphics g)
	{
		g.drawImage(im,0 ,0 , wx, wy, 0, 0, wx, wy,null);
	}
	
	
}
