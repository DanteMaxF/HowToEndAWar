/*
 * GameStatePaused.java
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
import java.awt.*;
import java.awt.event.KeyEvent;

public class GameStatePaused implements GameState {
	GameStateContext gc;
	//private static GameStatePaused instance=null;
	
	public GameStatePaused(GameStateContext gc){
		this.gc = gc;
	}

	public void end(){
		System.out.println("No se puede dar end en pausado");
	}
	
	public void pause(){
		System.out.println("Ya está pausado");
	}
	
	public void resume(){
		gc.setCurrent(gc.getRun());
	}
	
	public void render(Graphics g){
		g.setColor(Color.black);
		g.fillRect(0, 0, 1300, 800);
		g.setColor(Color.red);
		g.drawString("Esta pausado carnal", ((1280/2)-50), ((720/2)-50));
	}
	
	public void update(){
	
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

	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		
	}	
}

