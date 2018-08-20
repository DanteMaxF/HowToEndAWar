/*
 * GameStateRunning.java
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

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;


public class GameStateRunning implements GameState{
	GameStateContext gc;
	private Character chara1;
	private Character chara2;
	public int directionX1, auxHeightChar1, duck1;
	public int directionX2, auxHeightChar2, duck2;
	private int level;
	private LongRange w3,w4;
	private Solids solids;
	private Bullet bw1;

	private Bullets bw;
	private int iter=0;
	private BufferedImage background;
	private BufferedImage background2;
	private boolean transition;
	private int drawcorner;
	private int directionScroll;
	private boolean winner; //True = presidente X // False = Presidente Y


	private MusicPlayer2 mp2;
	
	
	
	
	
	
	public GameStateRunning(GameStateContext gc){
		this.gc = gc;
		chara1 = new Character("Player 1","resources/NormalStaticLeft.png");
		chara2 = new Character("Player 2","resources/NormalStaticRightP2.png");
		//chara1.setX1(1280 - (chara1.getWidth()));
		
		this.auxHeightChar1 = chara1.getHeight();
		this.auxHeightChar2 = chara2.getHeight();
		w3=new LongRange(1);
		w4=new LongRange(2);
		
		bw1=new Bullet();
		bw=new Bullets();
		
		solids = new Solids();
		solids.addSolidsLvl3();
		
		level=3;
		w3.chagePositionLevel(3);
		w4.chagePositionLevel(3);
		chara1.changePositionLevel(3);
		chara2.changePositionLevel(3);
		background2=ImageLoader.getInstance().getImage("background-large");
		background=background2.getSubimage(2560, 0, 1280, 700);
		transition=false;
		directionScroll=1;
		drawcorner=2560;
		
		try {
			mp2 = new MusicPlayer2(new FileInputStream("resources/Music/07 We_re the Resistors.mp3"));
			mp2.play();
			mp2.pause();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	public void startMusic(){
		//mp.start();
		try {
			mp2.resume();
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	
	
	private void createMusic(){
		try{
			mp2 = new MusicPlayer2(new FileInputStream("resources/Music/07 We_re the Resistors.mp3"));
			mp2.play();

		}catch (final Exception e){
			throw new RuntimeException(e);
		}
	}
	
	public void end(){
		gc.setCurrent(gc.getGameOver());
	}
	
	public void pause(){
		gc.setCurrent(gc.getPause());
	}
	
	public void resume(){
		System.out.println("No se puede hacer resume en Play");
	}
	
	public void render(Graphics g){
		
		g.drawImage(background, 0, 0, 1280, 700, null);
		//g.drawString("Running",20,20);
		g.drawString("Level: "+level+"/5",400,20);
		if(transition&&drawcorner<=6400-1280) {
			g.setColor(Color.black);
			drawcorner+=5*directionScroll;
			background=background2.getSubimage(drawcorner, 0, 1280, 700);
			g.drawImage(background, 0, 0, 1280, 700, null);
			g.drawString("Scrolling",20,20);
			if(drawcorner%640==0) {
				transition=false;
				if(directionScroll==1) {
					levelUp();
				}
				else {
					levelDown();
				}
			}
		}
		else {
			g.setColor(Color.black);
			
			
			solids.paint(g);
			chara1.paint(g, Color.red);
			chara2.paint(g, Color.blue);
			w3.paint(g,Color.green);
			w4.paint(g,Color.green);
			bw1.paint(g);
			bw.paint(g);
		}
		g.drawString("Points player 1: "+chara1.getPoints(), 1100, 650);
		g.drawString("Points player 2: "+chara2.getPoints(), 20, 650);
	}
	
	
	public void update(){
		
		if(mp2.checkFinished()){
			createMusic();
		}
		
		
		////-----------------------------------------BULLETS-------------------------------------------------------------------////
		
		if(bw1.getFired()){
			bw1.move();
			if(bw1.getX1()<0||bw1.getX1()>1280||solids.hasCollision(bw1)){
				bw1.setFired(false);
			}
			if((bw1.hasCollision(chara1)||chara1.hasCollision(bw1))&&w3.getCharname()!=chara1.getName()) {
				bw1.setFired(false);
				bw.Erase();
				//levelDown();
				transition=true;
				directionScroll=-1;
			}
			if((bw1.hasCollision(chara2)||chara2.hasCollision(bw1))&&w3.getCharname()!=chara2.getName()) {
				bw1.setFired(false);
				bw.Erase();
				//levelUp();
				transition=true;
				directionScroll=1;
			}
		}
		for(int i=0;i<4;i++) {
			if(bw.getFired(i)) {
				bw.move(i);
				if(bw.get(i).getX1()<0||bw.get(i).getX1()>1280||solids.hasCollision(bw.get(i))){
					bw.setFired(i,false);
				}
				if((bw.get(i).hasCollision(chara1)||chara1.hasCollision(bw.get(i)))&&w4.getCharname()!=chara1.getName()) {
					bw1.setFired(false);
					bw.Erase();
					//levelDown();
					transition=true;
					directionScroll=-1;
					System.out.println("HERE");
				}
				if((bw.get(i).hasCollision(chara2)||chara2.hasCollision(bw.get(i)))&&w4.getCharname()!=chara2.getName()) {
					System.out.println("HERE2");
					System.out.println("Chara2: "+chara2.getX1()+" "+chara2.getX2()+" "+chara2.getY1()+" "+chara2.getY2());
					System.out.println("Bullet: "+bw.get(i).getX1()+" "+bw.get(i).getX2()+" "+bw.get(i).getY1()+" "+bw.get(i).getY2());
					bw1.setFired(false);
					bw.Erase();
					//levelUp();
					transition=true;
					directionScroll=1;
				}
			}
		}

		
	////-----------------------------------------JUGADOR 1-------------------------------------------------------------------////
			if(directionX1==1 && chara1.getX2() < 1280-(chara1.getWidth())){
				if(solids.hasCollision2(chara1)==false){
					chara1.moveRight();
					//System.out.println(chara1.getWidth());
				}
				chara1.setLastd(1);
			}
			if(directionX1== -1 && chara1.getX1() > 0){
				if(solids.hasCollision3(chara1)==false){
					//System.out.println("Changing direction: "+chara1.getWidth());
					chara1.moveLeft();
				}
				chara1.setLastd(-1);
			}
			if(duck1 == 1){
				chara1.duck(true, auxHeightChar1);
			}else{
				chara1.duck(false, auxHeightChar1);
			}
			if(chara1.getJumpb() == true){
				if(chara1.getCountjump()>0){	
					chara1.setJumping(true);	
					chara1.jump();
				}
				else{
					chara1.setJumping(false);
					chara1.setJumpb(false);
					chara1.setFall(true);
				}
			}
			if(solids.hasCollision4(chara1)) {
				chara1.setFall(true);
				chara1.fall(true);
				chara1.setCountjump(0);
			}
			if(chara1.getCountjump()==0 || chara1.getJumping() == false){
				if(solids.hasCollision(chara1)==false){
					chara1.fall(true);
				}
				else{
					chara1.setFall(false);
					chara1.setCountjump(55);
				}
			}
			

	////-----------------------------------------JUGADOR 2-------------------------------------------------------------------////
		
			if(directionX2 == 1 && chara2.getX2() < 1280-(chara2.getWidth())){
				if(solids.hasCollision2(chara2)==false){
					chara2.moveRight();
				}
				chara2.setLastd(1);
			}
			if(directionX2 == -1 && chara2.getX1() > 0){
				if(solids.hasCollision3(chara2)==false){
					chara2.moveLeft();
				}
				chara2.setLastd(-1);
			}
			if(duck2 == 1){
				chara2.duck(true, auxHeightChar2);
			}else{
				chara2.duck(false, auxHeightChar2);
			}
			if(chara2.getJumpb() == true){
				if(chara2.getCountjump()>0){	
					chara2.setJumping(true);	
					chara2.jump();
				}else{
					chara2.setJumping(false);
					chara2.setJumpb(false);
					chara2.setFall(true);
				}
			}
			if(solids.hasCollision4(chara2)) {
				chara2.setFall(true);
				chara2.fall(true);
				chara2.setCountjump(0);
			}
			if(chara2.getCountjump()==0 || chara2.getJumping() == false){
				if(solids.hasCollision(chara2)==false){
					chara2.fall(true);
				}
				else{
					chara2.setFall(false);
					chara2.setCountjump(55);
				}
			}
			
		if(chara2.getY1()>700) {
			//levelUp();
			System.out.println("FALLEN2, width: "+chara2.getWidth());
			transition=true;
			directionScroll=1;
		}
		if(chara1.getY1()>700) {
			//levelDown();
			transition=true;
			directionScroll=-1;
		}
		if(chara1.getY1()<0) {
			chara1.setFall(true);
			chara1.fall(true);
			chara1.setCountjump(0);
		}
		if(chara2.getY1()<0) {
			chara2.setFall(true);
			chara2.fall(true);
			chara2.setCountjump(0);
		}
	}
	

	
	
	
	public void setDirectionX1(int x){
		this.directionX1 = x;
		
		if(w3.getTaken()&&w3.getCharname()==chara1.getName()) {
			chara1.setImg(1,x);
		}
		else if(w4.getTaken()&&w4.getCharname()==chara1.getName()){
			chara1.setImg(2,x);
		}
		else {
			chara1.setImg(0,x);
		}
	}
	
	public int getDirectionX1(){
		return directionX1;
	}
	
	public void setDirectionX2(int x){
		this.directionX2 = x;
		
		
		if(w3.getTaken()&&w3.getCharname()==chara2.getName()) {
			chara2.setImg(1,x);
		}
		else if(w4.getTaken()&&w4.getCharname()==chara2.getName()){
			chara2.setImg(2,x);
		}
		else {
			chara2.setImg(0,x);
		}
	}
	
	public int getDirectionX2(){
		return directionX2;
	}
	public void setJump1(boolean jump){
		if(chara1.getFall()==false) {
			chara1.setJumpb(jump);
		}
	}
	public boolean getJump1(){
		return chara1.getJumpb();
	}
	public void setJump2(boolean jump){
		if(chara2.getFall()==false) {
			chara2.setJumpb(jump);
		}		
	}
	public boolean getJump2(){
		return chara2.getJumpb();
	}
	

	@Override
	public void take1w() {
		if((chara1.hasCollision(w3)==true||w3.hasCollision(chara1)==true)&&w3.getTaken()==false){
			w3.setTaken(true);
			w3.setCharname(chara1.getName());
			//chara1.addWidthWeapon();
			chara1.setImg(1, directionX1);
			if(w4.getCharname()==chara1.getName()){
				w4.setTaken(false);
				w4.setName("No player");
				//System.out.println(chara1.getX1());
				w4.setX1(chara1.getX1());
			}
		}
		else if((chara1.hasCollision(w4)||w4.hasCollision(chara1))==true&&w4.getTaken()==false){
			w4.setTaken(true);
			w4.setCharname(chara1.getName());
			//chara1.addWidthWeapon();
			chara1.setImg(2, directionX1);
			System.out.println("Player 2 getting weapon 1");
			System.out.println(chara1.getWidth());
			if(w3.getCharname()==chara1.getName()){
				w3.setTaken(false);
				w3.setName("No player");
				//System.out.println(chara1.getX1());
				w4.setX1(chara1.getX1());
			}
		}
	}
	@Override
	public void take2w() {
		if((chara2.hasCollision(w3)||w3.hasCollision(chara2))==true&&w3.getTaken()==false){
			w3.setTaken(true);
			w3.setCharname(chara2.getName());
			//chara2.addWidthWeapon();
			chara2.setImg(1, directionX2);
			if(w4.getCharname()==chara2.getName()){
				w4.setTaken(false);
				w4.setName("No player");
				w4.setX1(chara2.getX1());
			}
		}
		else if((chara2.hasCollision(w4)||w4.hasCollision(chara2))==true&&w4.getTaken()==false){
			w4.setTaken(true);
			w4.setCharname(chara2.getName());
			chara2.setImg(2, directionX2);
			//chara2.addWidthWeapon();
			if(w3.getCharname()==chara2.getName()){
				w3.setTaken(false);
				w3.setName("No player");
				w4.setX1(chara2.getX1());
			}
		}
	}

	@Override
	public void drop1() {
		if(w3.getCharname()==chara1.getName()){
			chara1.setImg(0, directionX1);
			w3.setTaken(false);
			w3.setCharname("No player");
			w3.setX1(chara1.getX1());
			w3.setY1(chara1.getY1());
		}
		else if(w4.getCharname()==chara1.getName()){
			w4.setTaken(false);
			chara1.setImg(0, directionX1);
			w4.setCharname("No player");
			w4.setX1(chara1.getX1());
			w4.setY1(chara1.getY1());
		}
	}
	
	@Override
	public void drop2() {
		if(w3.getCharname()==chara2.getName()){
			w3.setTaken(false);
			chara2.setImg(0, directionX2);
			w3.setCharname("No player");
			w3.setX1(chara2.getX1());
			w3.setY1(chara2.getY1());
		}
		else if(w4.getCharname()==chara2.getName()){
			w4.setTaken(false);
			chara2.setImg(0, directionX2);
			w4.setCharname("No player");
			w4.setX1(chara2.getX1());
			w4.setY1(chara2.getY1());
		}
	}
	@Override
	public void fire1() {
		//if(w1.getCharname()==chara1.getName()){
			
		//}
		if(w3.getCharname()==chara1.getName()){
			bw1.setFired(chara1.getLastd(),chara1.getX1(),chara1.getWidth(),chara1.getY1(),chara1.getHeight()/3);
			
		}
		else if(w4.getCharname()==chara1.getName()){
			bw.setFired(chara1.getLastd(),chara1.getX1(),chara1.getWidth(),chara1.getY1(),chara1.getHeight()/3);
		}
		
	}
	
	@Override
	public void fire2() {
		if(w3.getCharname()==chara2.getName()){
			bw1.setFired(chara2.getLastd(),chara2.getX1(),chara2.getWidth(),chara2.getY1(),chara2.getHeight()/3);
		}
		else if(w4.getCharname()==chara2.getName()){
			bw.setFired(chara2.getLastd(),chara2.getX1(),chara2.getWidth(),chara2.getY1(),chara2.getHeight()/3);
		}
	}

	@Override
	public void setImageByName1(String string) {
		if(string == "derecha_caminando"){
			if(w3.getTaken() && w3.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GunRight.gif");
			}else if(w4.getTaken() && w4.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GatlingRight.gif");
			}
			
			else{
				//System.out.println("Here");
				chara1.setWidth(30);
				chara1.setImageByName("resources/NormalRight.gif");
			}
		}
		else if(string == "izquierda_caminando"){
			if(w3.getTaken() && w3.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GunLeft.gif");
			}
			else if(w4.getTaken() && w4.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GatlingLeft.gif");
			}
			else{
				chara1.setWidth(30);
				chara1.setImageByName("resources/NormalLeft.gif");
			}
		}
		else if(string == "derecha_parado"){
			if(w3.getTaken() && w3.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GunStaticRight.png");
			}
			else if(w4.getTaken() && w4.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GatlingStaticRight.png");
			}
			else{
				chara1.setWidth(30);
				chara1.setImageByName("resources/NormalStaticRight.png");			
			}
		}
		else if(string == "izquierda_parado"){
			if(w3.getTaken() && w3.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GunStaticLeft.png");
			}
			else if(w4.getTaken() && w4.getCharname() == chara1.getName()){
				chara1.setWidth(50);
				chara1.setImageByName("resources/GatlingStaticLeft.png");
			}
			else{
				chara1.setWidth(30);
				chara1.setImageByName("resources/NormalStaticLeft.png");
			}
		}
		
	}

	@Override
	public void setImageByName2(String string) {
		if(string == "derecha_caminando"){
			if(w3.getTaken() && w3.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GunRightP2.gif");
			}else if(w4.getTaken() && w4.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GatlingRightP2.gif");
			}
			
			else{
				chara2.setWidth(30);
				chara2.setImageByName("resources/NormalRightP2.gif");
			}
		}
		else if(string == "izquierda_caminando"){
			if(w3.getTaken() && w3.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GunLeftP2.gif");
			}
			else if(w4.getTaken() && w4.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GatlingLeftP2.gif");
			}
			else{
				chara2.setWidth(30);
				chara2.setImageByName("resources/NormalLeftP2.gif");
			}
		}
		else if(string == "derecha_parado"){
			if(w3.getTaken() && w3.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GunStaticRightP2.png");
			}
			else if(w4.getTaken() && w4.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GatlingStaticRightP2.png");
			}
			else{
				chara2.setWidth(30);
				chara2.setImageByName("resources/NormalStaticRightP2.png");			
			}
		}
		else if(string == "izquierda_parado"){
			if(w3.getTaken() && w3.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GunStaticLeftP2.png");
			}
			else if(w4.getTaken() && w4.getCharname() == chara2.getName()){
				chara2.setWidth(50);
				chara2.setImageByName("resources/GatlingStaticLeftP2.png");
			}
			else{
				chara2.setWidth(30);
				chara2.setImageByName("resources/NormalStaticLeftP2.png");
			}
		}
	}
	
	public void levelUp() {
		if(level==5) {
			System.out.println("GAME OVER");
			winner = true;
			end();
		}
		else {
			chara1.addPoints();
			chara2.minusPoints();
			this.drop1();
			this.drop2();
			if(level==4) {
				solids.addSolidsLvl5();
			}
			if(level==3) {
				solids.addSolidsLvl4();
			}
			if(level==2) {
				solids.addSolidsLvl3();
			}
			if(level==1) {
				solids.addSolidsLvl2();
			}
			level++;
			w3.chagePositionLevel(level);
			w4.chagePositionLevel(level);
			chara1.changePositionLevel(level);
			chara2.changePositionLevel(level);
			//directionScroll=1;
			//transition=true;
		}
	}
	
	public void levelDown() {
		if(level==1) {
			System.out.println("GAME OVER");
			winner = false;
			end();
		}
		else {
			chara2.addPoints();
			chara1.minusPoints();
			this.drop1();
			this.drop2();
			if(level==5) {
				solids.addSolidsLvl4();
			}
			if(level==4) {
				solids.addSolidsLvl3();
			}
			if(level==3) {
				solids.addSolidsLvl2();
			}
			if(level==2) {
				solids.addSolidsLvl1();
			}
			level--;
			w3.chagePositionLevel(level);
			w4.chagePositionLevel(level);
			chara1.changePositionLevel(level);
			chara2.changePositionLevel(level);
			//directionScroll=-1;
			//transition=true;
		}
	}

	public boolean getWinner(){
		return winner;
	}
	
	@Override
	public void mainMenu() {
		// TODO Auto-generated method stub
		
	}

}

