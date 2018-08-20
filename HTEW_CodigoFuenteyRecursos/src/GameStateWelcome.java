import java.awt.Graphics;
import java.io.FileInputStream;

public class GameStateWelcome implements GameState{
	GameStateContext gc;
	private TextMessage tm;

	
	
	public GameStateWelcome(GameStateContext gc){
		this.gc = gc;
		tm = new TextMessage(270, 720, 735, 1521, "resources/FirstText.png");
		
		
	}
	@Override
	public void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}
	


	@Override
	public void resume() {
		gc.setCurrent(gc.getRun());

	}
	
	@Override
	public void mainMenu() {
		gc.setCurrent(gc.getMainMenu());
	}	

	@Override
	public void render(Graphics g) {
		g.drawString("Welcome State", 30, 30);
		tm.paint(g);
		
		
		
	}

	@Override
	public void update() {
		if(!tm.goUp()){
			mainMenu();
		}
		
	}

	@Override
	public void setDirectionX1(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDirectionX2(int x) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJump1(boolean jump) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJump2(boolean jump) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void take1w() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void take2w() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void drop2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fire2() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageByName1(String string) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setImageByName2(String string) {
		// TODO Auto-generated method stub
		
	}


}
