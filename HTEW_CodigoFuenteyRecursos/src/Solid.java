import java.awt.Color;
import java.awt.Graphics;

public class Solid extends MyGraphics{
	private static final long serialVersionUID = 1L;
	private boolean damage_player;
	private int type;
	private Color color;
	
	public Solid(){
		super();
		damage_player = false;
		type=0;
		color = new Color(0,0, 200);
	}
	
	public Solid(boolean damage_player, int type, int x1, int y1, int width, int height, Color color){
		super(x1,y1,width,height);
		this.damage_player = damage_player;
		this.type = type;
		this.color = color;
	}

	public boolean isDamage_player() {
		return damage_player;
	}

	public void setDamage_player(boolean damage_player) {
		this.damage_player = damage_player;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	
	public String toString() {
		return "Solid [damage_player=" + damage_player + ", type=" + type + "]";
	}
	
	/*public boolean moveLeft(){
		boolean collision = false;
		int aux = x1 - 2;

		if(aux >= (0 - width)){
			x1 = aux;
			x2 -= 2;
		}
		else{
			x1 = (0 - width);
			x2 = x1 + width;
			collision = true;
		}	
		return collision;
	}
	*/
	
	public void paint(Graphics g){
		g.setColor(color);
		g.fillRect(x1, y1, width, height);
	}
	
}
