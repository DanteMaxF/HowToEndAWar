/*
 * GameState.java
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
interface GameState {

	
	public void end();
	public void pause();
	public void resume();
	public void mainMenu();
	public void render(Graphics g);
	public void update();
	
	public void setDirectionX1(int x);
	public void setDirectionX2(int x);
	public void setJump1(boolean jump);
	public void setJump2(boolean jump);
	public void take1w();
	public void take2w();
	public void drop1();
	public void drop2();
	public void fire1();
	public void fire2();
	public void setImageByName1(String string);
	public void setImageByName2(String string);

	
}

