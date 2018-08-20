import java.awt.Graphics;

public class TextMessage extends MyGraphics{
	private String path;
	private boolean visible;
	
	public TextMessage(int x, int y, int width, int height, String imageSource){
		super();
		this.x1 = x;
		this.y1 = y;
		this.width = width;
		this.height = height;
		path = imageSource;
		setImageByName(path);
		visible = false;
		

	}
	
	public boolean goUp(){
		
		try{
			Thread.sleep(250);
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
		}
		y1 -= 10;
		y2 = y1 + height;
		
		if(y2 < 0){
			return false;
		}
		return true;
		
	}
	
	public void paint(Graphics g){
		if(path == "resources/enter.png"){
			try{
				Thread.sleep(500);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			if(visible){
				g.drawImage(image, x1, y1, width, height, null);
				visible = false;
			}else{
				visible = true;
			}
		}else{
			g.drawImage(image, x1, y1, width, height, null);
		}
		
	}
}
