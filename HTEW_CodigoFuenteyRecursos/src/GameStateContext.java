/*
 * GameStateContext.java
 * 
 * Copyright 2017 Edgar Daniel Fernández Rodríguez <edgar.fernandez@me.com>
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 * 
 * 
 */

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.FileInputStream;
public class GameStateContext{
	
	protected int height, width;
	private GameStateRunning run;
	private GameStatePaused pause;
	private GameStateGameOver go;
	private GameStateWelcome welcome;
	private GameStateMainMenu mainMenu;
	
	private GameState current;
	
	private MusicPlayer2 mpWelcome;
	 
	public GameStateContext(int width, int height){
		run = (GameStateRunning)statefactory.getInstance().makestate("running",this);
		pause = (GameStatePaused)statefactory.getInstance().makestate("pause", this);
		go = (GameStateGameOver)statefactory.getInstance().makestate("game over", this);
		welcome = (GameStateWelcome)statefactory.getInstance().makestate("welcome", this);
		mainMenu = (GameStateMainMenu)statefactory.getInstance().makestate("mainMenu", this);
		this.height = height;
		this.width = width;
		current=welcome;
		//current = statefactory.getInstance().makestate("running",this);
		
		createMusic();
		
	}
	
	private void createMusic(){
		try{
			mpWelcome = new MusicPlayer2(new FileInputStream("resources/Music/Prologue.mp3"));
			mpWelcome.play();

		}catch (final Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public GameState getRun(){
		mpWelcome.close();
		run.startMusic();
		return run;
	}
	
	public GameState getPause(){
		return pause;
	}
	
	public GameState getGameOver(){
		go.setWinner(run.getWinner());
		return go;
	}
	
	public GameState getMainMenu(){
		return mainMenu;
	}
	
	public void setCurrent(GameState gs){
		current = gs;
	}
	
	public void end(){
		current.end();
		//current=statefactory.getInstance().makestate("game over", this);
	}
	
	public boolean resume(){
		current.resume();
		//current=statefactory.getInstance().makestate("running", this);
		return true;
	}
	
	public boolean pause(){
		current.pause();
		//current=statefactory.getInstance().makestate("pause", this);
		return true;
	}
	
	public boolean mainMenu(){
		current.mainMenu();
		
		return true;
	}
	
	public void update() {
		current.update();
		if(current instanceof GameStateWelcome && current instanceof GameStateMainMenu){	
			if(mpWelcome.checkFinished()){
				createMusic();
			}
		}
	}
	
	public void render(Graphics g){
		current.render(g);
	}
	
	
	
	
	public void setDirectionX1(int x){
		current.setDirectionX1(x);
	}
	
	public void setDirectionX2(int x){
		current.setDirectionX2(x);
	}
	
	public void setJump1(boolean jump){
		current.setJump1(jump);
	}
	
	public void setJump2(boolean jump){
		current.setJump2(jump);
	}
	
	public void take1w(){
		current.take1w();
	}
	
	public void take2w(){
		current.take2w();
	}

	public void drop1(){
		current.drop1();
	}

	public void drop2(){
		current.drop2();
	}
	
	public void fire1(){
		current.fire1();
	}
	public void fire2(){
		current.fire2();
	}

	public void setImageByName1(String string) {
		current.setImageByName1(string);
	}

	public void setImageByName2(String string) {
		current.setImageByName2(string);
	}	
}

