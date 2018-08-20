public class statefactory{
	private static statefactory instance=null;
	private statefactory(){
		
	}
	public static statefactory getInstance(){
		if(instance==null){
			instance=new statefactory();
		}
		return instance;
	}
	public GameState makestate(String type,GameStateContext gc){
		if(type=="running"){
			return new GameStateRunning(gc);
		}
		else if(type=="pause"){
			return new GameStatePaused(gc);
		}
		else if(type=="game over"){
			return new GameStateGameOver(gc);
		}
		else if(type=="welcome"){
			return new GameStateWelcome(gc);
		}
		else if(type=="mainMenu"){
			return new GameStateMainMenu(gc);
		}
		else{
			return null;
		}
	}
}