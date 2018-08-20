import java.awt.Color;
import java.awt.Graphics;
import java.io.FileInputStream;
import java.util.ListIterator;

public class Bullet extends MyGraphics{
	private boolean fired;
	private int direction;
	
	private MusicPlayer2 weaponSound;
	
	public Bullet(){
		super();
		fired=false;
		this.width=5;
		this.height=5;
	}
	
	public boolean getFired(){
		return fired;
	}

	public void setFired(boolean fired){
		this.fired=fired;
	}
	
	public void createSound(){
		try{
			weaponSound = new MusicPlayer2(new FileInputStream("resources/Music/gunshot.mp3"));
			weaponSound.play();
		}catch (final Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void setFired(int direction,int x1c,int wc,int yc,int hc){
		if(fired==false) {
			this.setDirection(direction);
			this.fired=true;
			if(this.direction==1) {
				this.setX1(x1c+wc);
			}
			else {
				this.setX1(x1c);
			}
			this.setY1(yc+hc);
			createSound();
		}
	}
	public int getDirection(){
		return direction;
	}
	public void setDirection(int direction){
		this.direction=direction;
	}
	
	public void move() {
		x1=x1+direction*5;
		x2=x2+direction*5;
	}
	
	public void paint(Graphics g){
		g.setColor(Color.yellow);
		if(this.fired&&this.x1>=0&&this.x1<=1280) {
			g.drawRect(x1, y1, width, height);
			g.fillRect(x1, y1, width, height);	
		}
	}
}