import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import java.awt.Image;


public class ImageLoadergifs {
	private Hashtable <String, Image> sources = new Hashtable<String, Image>();
	private static ImageLoadergifs instance;
	
	public static synchronized ImageLoadergifs getInstance(){
		if(instance == null){
			instance = new ImageLoadergifs();
		}
		return instance;
	}
	
	private ImageLoadergifs(){
		
			//Personaje 1
			
			
			sources.put("GunRight1", new ImageIcon("resources/GunRight.gif").getImage());
			sources.put("GatlingRight1", new ImageIcon("resources/GatlingRight.gif").getImage());
			sources.put("NormalRight1", new ImageIcon("resources/NormalRight.gif").getImage());
			sources.put("GunLeft1", new ImageIcon("resources/GunLeft.gif").getImage());
			sources.put("GatlingLeft1", new ImageIcon("resources/GatlingLeft.gif").getImage());
			sources.put("NormalLeft1", new ImageIcon("resources/NormalLeft.gif").getImage());
			
			
			//Personaje 2
			sources.put("GunRight2", new ImageIcon("resources/GunRightP2.gif").getImage());
			sources.put("GatlingRight2", new ImageIcon("resources/GatlingRightP2.gif").getImage());
			sources.put("NormalRight2", new ImageIcon("resources/NormalRightP2.gif").getImage());
			sources.put("GunLeft2", new ImageIcon("resources/GunLeftP2.gif").getImage());
			sources.put("GatlingLeft2", new ImageIcon("resources/GatlingLeftP2.gif").getImage());
			sources.put("NormalLeft2", new ImageIcon("resources/NormalLeftP2.gif").getImage());
			
		
	}
	public Image getImage(String k){
		return sources.get(k);
	}
	
}