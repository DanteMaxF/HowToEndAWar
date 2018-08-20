import java.awt.Graphics;

public class GameStateMainMenu implements GameState{
	GameStateContext gc;
	private TextMessage menuLogo;
	private TextMessage pressEnter;

	
	public GameStateMainMenu(GameStateContext gc){
		this.gc = gc;
		menuLogo = new TextMessage(0,0,1280,720,"resources/MM.png");
		pressEnter = new TextMessage(454,120,373,88,"resources/enter.png");
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
		
		
	}


	@Override
	public void render(Graphics g) {
		g.drawString("Main menu", 30, 30);
		menuLogo.paint(g);
		pressEnter.paint(g);
	}
boolean visible = true;
	@Override
	public void update() {
		try{
			Thread.sleep(250);
		}catch(InterruptedException ex){
			Thread.currentThread().interrupt();
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
