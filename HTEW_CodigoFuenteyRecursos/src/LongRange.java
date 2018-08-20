import java.awt.Color;
import java.awt.Graphics;
import java.util.ListIterator;

public class LongRange extends MyGraphics {
	private int jump;
	private boolean isTaken;
	private String name;
	private int number;
	private String charname;
	
	public LongRange(){
		super();
		isTaken = false;
		name = "Sword";
	}
	public LongRange(int n1){
		super();
		if(n1==1){
			this.width = 30;
			this.height=20;
			this.y1=445;
			this.x1=525;
			setImageByName("resources/Guns/DesertEagle.png");
		}
		else{
			this.width=60;
			this.height=40;
			this.y1=435;
			this.x1=720;
			setImageByName("resources/Guns/AK.png");
		}
		isTaken = false;
		name = "Sword";
		number=n1;
	}
	public LongRange(boolean isTaken, String name, int x1, int y1){
		super();
		this.width=10;
		this.height=10;
		this.y1=y1;
		this.x1=x1;
		this.x2=x1+width;
		this.y2=y1+height;
		this.isTaken = isTaken;
		this.name = name;
		this.charname="No player";
	}
	public boolean getTaken() {
		return isTaken;
	}
	public void setTaken(boolean isTaken) {
		this.isTaken = isTaken;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCharname(){
		return charname;
	}
	
	public void setCharname(String charname){
		this.charname=charname;
	}
	
	public String toString() {
		return "Short Range [isTaken=" + isTaken+ ", name=" + name + "]";
	}
	
	
	public boolean hasCollisionAndMove(MyGraphics mg, int x1, int y1, int x2, int y2){
		boolean collision = false;
		
		if(hasCollision(mg, x1, y1, x2, y2)){
			if(x2 > this.x2){
				this.x1 = mg.getX1() - width;
				this.x2 = mg.getX1();
			}
			if(x1 < this.x1){
				this.x1 = mg.getX2();
				this.x2 = mg.getX2() + width;
			}
			if(y2 > this.y2){
				if(y2 > mg.getY1()){
					this.y1 = mg.getY1() - height;
					this.y2 = mg.getY1();
				}
			}
			if(y2 < this.y2){
				if(y1 < mg.getY2()){
					this.y1 = mg.getY2();
					this.y2 = mg.getY2() + height;
				}
			}				
			collision = true;
		}
		
		return collision;
	}	
	
	public void paint(Graphics g, Color c1){
		if(!this.isTaken) {
			g.drawImage(image, x1, y1, width, height, null);
		}
	}
	public void chagePositionLevel(int level) {
		if(level==1) {
			if(number==1) {
				this.width = 30;
				this.height=20;
				this.y1=650;
				this.x1=450;				
			}
			else {
				this.width=60;
				this.height=40;
				this.y1=635;
				this.x1=1075;				
			}
		}
		else if(level==3) {
			if(number==1) {
				this.width = 30;
				this.height=20;
				this.y1=645;
				this.x1=450;
			}
			else {
				this.width=60;
				this.height=40;
				this.y1=635;
				this.x1=775;				
			}			
		}
		else if(level==2) {
			if(number==1) {
				this.width = 30;
				this.height=20;
				this.y1=445;
				this.x1=525;				
			}
			else {
				this.width=60;
				this.height=40;
				this.y1=435;
				this.x1=920;
			}
		}
		else if(level==4) {
			if(number==1) {
				this.width = 30;
				this.height=20;
				this.y1=270;
				this.x1=775;
			}
			else {
				this.width=60;
				this.height=40;
				this.y1=260;
				this.x1=350;
			}
		}
		else if(level==5) {
			if(number==1) {
				this.width = 30;
				this.height=20;
				this.y1=370;
				this.x1=625;
			}
			else {
				this.width=60;
				this.height=40;
				this.y1=155;
				this.x1=335;
			}
		}
		this.x2=this.x1+this.width;
		this.y2=this.y1+this.height;
	}

}