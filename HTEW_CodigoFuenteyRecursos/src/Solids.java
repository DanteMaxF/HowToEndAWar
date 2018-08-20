import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.ListIterator;

public class Solids {
	
	ArrayList<Solid> solids;
	private Solid sol;
	
	
	
	public Solids(){
		solids=new ArrayList<Solid>();
	}
	
	public ArrayList<Solid> getSolids() {
		return solids;
	}
	
	public void setSolids(ArrayList<Solid> solids) {
		this.solids = solids;
	}
	
	
	public String toString(){
		String str = "";
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			str += solid.toString() + "\n\n";
		}
		return str;
	}
	
	public void getSolid(){
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
		}
	}
	
	public boolean hasCollision(Character c){
		boolean collision=false;
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.hasCollision(c)==true){
				collision=true;
			}
		}		
		return collision;
	}
	
	
	public boolean hasCollision(Bullet b){
		boolean collision=false;
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.hasCollision(b)==true){
				collision=true;
			}
		}		
		return collision;
	}
	
	public boolean hasCollision2(Character c){
		boolean collision=false;
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.hasCollision2(c)==true){
				collision=true;
			}
		}		
		return collision;
	}
	
	public boolean hasCollision3(Character c){
		boolean collision=false;
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.hasCollision3(c)==true){
				collision=true;
			}
		}		
		return collision;
	}
	
	public boolean hasCollision4(Character c){
		boolean collision=false;
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid = itr.next();
			if(solid.hasCollision4(c)==true){
				collision=true;
			}
		}		
		return collision;
	}	
	
	public void addSolidsLvl1(){
		solids.clear();

		sol = new Solid(false, 0, 0, 670, 1280, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 520, 600, 200, 70, Color.gray );
		solids.add(sol);
		
	}
	
	public void addSolidsLvl2(){
		solids.clear();

		sol = new Solid(false, 0, 0, 670, 1280, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 60, 620, 1160, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 120, 570, 1040, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 180, 520, 920, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 240, 470, 800, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 400, 370, 50, 100, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 825, 370, 50, 100, Color.gray );
		solids.add(sol);
		
		
	}
	
	public void addSolidsLvl3(){
		solids.clear();

		sol = new Solid(false, 0, 0, 670, 1280, 50, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 182, 600, 182, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 546, 600, 182, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 910, 600, 182, 80, Color.gray );
		solids.add(sol);
		
	}
	
	public void addSolidsLvl4(){
		solids.clear();

		sol = new Solid(false, 0, 150, 297, 960, 40, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 0, 445, 50, 30, Color.gray );
		solids.add(sol);
		sol = new Solid(false,0, 1230, 445, 50, 30, Color.gray );
		solids.add(sol);
	
	
	}
	
	public void addSolidsLvl5(){
	
		solids.clear();

		sol = new Solid(false, 0, 182, 600, 182, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 546, 600, 182, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 910, 600, 182, 80, Color.gray );
		solids.add(sol);
		
		sol = new Solid(false, 0, 0, 395, 182, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 200, 395, 100, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 400, 395, 100, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 600, 395, 100, 80, Color.gray );
		solids.add(sol);
		
		sol = new Solid(false, 0, 100, 195, 100, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 300, 195, 100, 80, Color.gray );
		solids.add(sol);
		sol = new Solid(false, 0, 500, 195, 100, 80, Color.gray );
		solids.add(sol);
	}
	
	
	
	
	
	
	
	public void paint(Graphics g){
		ListIterator<Solid> itr = solids.listIterator();
		while(itr.hasNext()){
			Solid solid=itr.next();
			solid.paint(g);
		}
	}
}
