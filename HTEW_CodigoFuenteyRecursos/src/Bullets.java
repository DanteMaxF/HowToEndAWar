import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

public class Bullets{
	private ArrayList<Bullet> bw;
	
	public Bullets(){
		bw=new ArrayList<Bullet>(4);
		for(int i=0;i<4;i++) {
			bw.add(i, new Bullet());
		}
	}
	
	public boolean getFired(int i){
		if(i>=0&&i<=4) {
			return bw.get(i).getFired();
		}
		return false;
	}
	
	public void setFired(int i,boolean fired) {
		bw.get(i).setFired(fired);
	}
	
	public void move(int i) {
		bw.get(i).move();
	}
	
	public void Erase() {
		for(int i=0;i<4;i++) {
			this.setFired(i,false);
		}
	}
	
	public Bullet get(int i) {
		if(i>=0&&i<=4) {
			return bw.get(i);
		}
		else {
			return null;
		}
	}
	
	public void setFired(int direction,int x1c,int wc,int yc,int hc){
		for(int i=0;i<4;i++) {
			if(getFired(i)==false) {
				bw.get(i).setFired(direction,x1c,wc,yc,hc);
				i=5;
			}
		}
	}
	
	public void paint(Graphics g){
		for(int i=0;i<4;i++) {
			bw.get(i).paint(g);
		}
	}
}