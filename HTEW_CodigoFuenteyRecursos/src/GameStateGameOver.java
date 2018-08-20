/*
 * GameStateGameOver.java
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

public class GameStateGameOver implements GameState {
	GameStateContext gc;
	private boolean winner;
	//private static GameStateGameOver instance=null;
	
	public GameStateGameOver(GameStateContext gc){
		this.gc = gc;
	}
	
	public void end(){
		System.out.println("No se puede dar end en GameOver");
	}
	
	public void pause(){
		System.out.println("No se puede dar pause en GameOver");
	}
	
	public void resume(){
		System.out.println("No se puede dar resume en GameOver");
	}
	
	public void render(Graphics g){
		g.setColor(Color.yellow);
		g.setFont(new Font("04b03", Font.PLAIN, 40));
		if(winner){
			g.drawString("EL PRESIDENTE X HA TERMINADO LA GUERRA", 250, 360);
		}
		else{
			g.drawString("EL PRESIDENTE Y HA TERMINADO LA GUERRA", 250, 360);
		}
	}
	
	public void update(){
	
	}
	
	public void setWinner(boolean w){
		winner = w;
		System.out.println("winner: "+winner);
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

