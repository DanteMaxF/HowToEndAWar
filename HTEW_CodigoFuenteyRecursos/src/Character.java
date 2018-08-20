import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ListIterator;

import javax.imageio.ImageIO;


public class Character extends MyGraphics {
	private int jump,lastd;
	private boolean isDead, falling, jumping,fall,jumpb;
	private int speed;
	private String name;
	private int counter=0;
	private int countjump;
	private BufferedImage todraw;
	private int points;
	
	public Character(int num){
		super();
		isDead = false;
		speed = 1;
		jump = 5;
		name = "Player1";
		falling = true;
		jumping = false;
		points=0;
	}
	
	public int getPoints() {
		return points;
	}
	
	public void addPoints() {
		points+=500;
	}
	
	public void minusPoints() {
		points-=200;
	}
	
	public int getLastd() {
		return lastd;
	}
	
	public void setLastd(int d) {
		lastd=d;
	}
	
	public void setJumpb(boolean jumpb) {
		this.jumpb=jumpb;
	}
	
	public boolean getJumpb() {
		return this.jumpb;
	}
	
	public void setFall(boolean fall) {
		this.fall=fall;
	}
	
	public boolean getFall() {
		return this.fall;
	}
	
	public void addWidthWeapon1(int x) {
		this.width=50;
	}
	
	public Character(String name, String imageSource){
		super();
		isDead = false;
		speed = 1;
		jump = 5;
		this.name = name;
		falling = true;
		jumping = false;
		fall=false;
		jumpb=false;
		if(name=="Player 1") {
			lastd=-1;
		}
		else {
			lastd=1;
		}
		setImageByName(imageSource);
		countjump=0;
	}
	
	public void setImg(int gun,int standing) {
		if(name=="Player 1") {
			if(standing==0) {
				if(gun==1) {
					width=50;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("GunStRight1");
					}
					else {
						image=ImageLoader.getInstance().getImage("GunStLeft1");
					}
				}
				else if(gun==2) {
					width=50;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("GatlingStRight1");
					}
					else {
						image=ImageLoader.getInstance().getImage("GatlingStLeft1");
					}
				}
				else {
					width=30;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("NormalStRight1");
					}
					else {
						image=ImageLoader.getInstance().getImage("NormalStLeft1");
					}
				}
			}
			else {
				if(standing==1) {
					if(gun==1) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GunRight1");
					}
					else if(gun==2) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GatlingRight1");
					}
					else {
						width=30;
						image=ImageLoadergifs.getInstance().getImage("NormalRight1");
					}
				}
				else {
					//System.out.println("HERE2");
					if(gun==1) {
						System.out.println("HERE2");
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GunLeft1");
					}
					else if(gun==2) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GatlingLeft1");
					}
					else {
						//System.out.println("HERE3");
						width=30;
						image=ImageLoadergifs.getInstance().getImage("NormalLeft1");
					}					
				}
			}
		}
		else {
			if(standing==0) {
				if(gun==1) {
					width=50;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("GunStRight2");
					}
					else {
						image=ImageLoader.getInstance().getImage("GunStLeft2");
					}
				}
				else if(gun==2) {
					width=50;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("GatlingStRight2");
					}
					else {
						image=ImageLoader.getInstance().getImage("GatlingStLeft2");
					}
				}
				else {
					width=30;
					if(lastd==1) {
						image=ImageLoader.getInstance().getImage("NormalStRight2");
					}
					else {
						image=ImageLoader.getInstance().getImage("NormalStLeft2");
					}
				}
			}
			else {
				if(standing==1) {
					if(gun==1) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GunRight2");
					}
					else if(gun==2) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GatlingRight2");
					}
					else {
						width=30;
						image=ImageLoadergifs.getInstance().getImage("NormalRight2");
					}
				}
				else {
					if(gun==1) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GunLeft2");
					}
					else if(gun==2) {
						width=50;
						image=ImageLoadergifs.getInstance().getImage("GatlingLeft2");
					}
					else {
						width=30;
						image=ImageLoadergifs.getInstance().getImage("NormalLeft2");
					}					
				}
			}			
		}
	}
	
	public int getCountjump() {
		return countjump;
	}
	
	public void setCountjump(int countjump) {
		this.countjump=countjump;
	}
	
	public Character(boolean isDead, int speed, int jump, String name, boolean falling, boolean jumpping){
		super();
		this.isDead = isDead;
		this.speed = speed;
		this.jump = jump;
		this.name = name;
		this.falling = falling;
		this.jumping = jumping;
			
	}
	
	
	public boolean getJumping(){
		return jumping;
	}
	public void setJumping(boolean jumping){
		this.jumping = jumping;
	}
	public boolean getFalling(){
		return falling;
	}
	public void setFalling(boolean falling){
		this.falling = falling;
	}
	public int getJump() {
		return jump;
	}
	public void setJump(int jump) {
		this.jump = jump;
	}
	public boolean isDead() {
		return isDead;
	}
	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return "Character [jump=" + jump + ", isDead=" + isDead + ", speed=" + speed + ", name=" + name + "]";
	}
	
	public void jump(){
		y2=y2-6;
		y1=y1-6;
		countjump--;
		//System.out.println("y1: "+y1);
	}
	
	public void fall(boolean con){
		//System.out.println("FALLIIIIIIIIIIIIIIIIIING!!!!!! "+(counter++));
		if(con){
			y1=y1+6;
			y2=y2+6;
			//System.out.println("NOOOO!!!! "+y1+" "+y2+" "+(y1+6)+" "+(y2+6));
			falling = true;
		}else{
			y2 = 720 - this.height;
			y1 = 720;
			falling = false;
		}

	}
	
	public void duck(boolean state, int height){
		
		if(state == true){
			this.height = height/2;
			//System.out.println("//Se agacha");
		}/*else{
			this.height = height;
			if(this.y2 > 671){
				y2 = 670;
				y1 = 620;
				//System.out.println("se arregla");
			}
		}*/
		
		
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
		/*g.setColor(Color.black);
		g.drawRect(x1, y1, width, height);
		g.setColor(c1);
		g.fillRect(x1, y1, width, height);
		*/
		//g.drawImage(todraw, x1, y1, width, height, null);
		g.drawImage(image, x1, y1, width, height, null);
	}
	
	
	public void moveRight(){
		this.setX1(this.getX1() + 3);
		//System.out.println("x1: "+x1 + "\tx2: "+x2 + "\tWidht"+width);
		repaint();
	}
	
	
	public void moveLeft(){
		this.setX1(this.getX1() - 3);
		//System.out.println("x1: "+x1 + "\tx2: "+x2 + "\tWidht"+width);
		repaint();
	}
	
	public void changePositionLevel(int level) {
		this.setImg(0, 0);
		if(this.getName()=="Player 1") {
			lastd=-1;
		}
		else {
			lastd=1;
		}
		if(level==1) {
			if(this.name=="Player 2") {
				this.x1=0;
				this.y1=0;
			}
			else {
				this.x1=1280-this.width;
				this.y1=0;
			}
		}
		else if(level==2) {
			if(this.name=="Player 2") {
				this.x1=0;
				this.y1=0;				
			}
			else {
				this.x1=1280-this.width;
				this.y1=0;				
			}
		}
		else if(level==3) {
			if(this.name=="Player 2") {
				this.x1=0;
				this.y1=0;
			}
			else {
				this.x1=1280-this.width;
				this.y1=0;
			}
		}
		else if(level==4) {
			if(this.name=="Player 2") {
				this.x1=0;
				this.y1=0;
			}
			else {
				this.x1=1280-this.width;
				this.y1=0;
			}
		}
		else if(level==5) {
			if(this.name=="Player 2") {
				this.x1=0;
				this.y1=0;
			}
			else {
				this.x1=1080-this.width;
				this.y1=0;
			}
		}
		this.x2=this.x1+this.width;
		this.y2=this.y1+this.height;
	}

}
