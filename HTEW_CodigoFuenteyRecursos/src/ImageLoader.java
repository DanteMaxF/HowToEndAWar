import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable;

import javax.imageio.ImageIO;


public class ImageLoader {
	private Hashtable <String, BufferedImage> sources = new Hashtable<String, BufferedImage>();
	private static ImageLoader instance;
	
	public static synchronized ImageLoader getInstance(){
		if(instance == null){
			instance = new ImageLoader();
		}
		return instance;
	}
	
	private ImageLoader(){
		
		try {
			sources.put("background", ImageIO.read(ImageLoader.class.getResourceAsStream("/resources/fondo1.png")));
			sources.put("background-large", ImageIO.read(ImageLoader.class.getResourceAsStream("/resources/fondo-largo.png")));
			//Personaje 1
			sources.put("GunStRight1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GunStaticRight.png")));
			sources.put("GatlingStRight1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GatlingStaticRight.png")));
			sources.put("NormalStRight1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/NormalStaticRight.png")));
			sources.put("GunStLeft1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GunStaticLeft.png")));
			sources.put("GatlingStLeft1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GatlingStaticLeft.png")));
			sources.put("NormalStLeft1", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/NormalStaticLeft.png")));
			//Personaje 2
			sources.put("GunStRight2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GunStaticRightP2.png")));
			sources.put("GatlingStRight2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GatlingStaticRightP2.png")));
			sources.put("NormalStRight2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/NormalStaticRightP2.png")));
			sources.put("GunStLeft2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GunStaticLeftP2.png")));
			sources.put("GatlingStLeft2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/GatlingStaticLeftP2.png")));
			sources.put("NormalStLeft2", ImageIO.read(ImageLoader.class.getResourceAsStream("resources/NormalStaticLeftP2.png")));
			
		}catch (IOException e){
			e.printStackTrace();
		}
		
	}
	public BufferedImage getImage(String k){
		return sources.get(k);
	}
	
}