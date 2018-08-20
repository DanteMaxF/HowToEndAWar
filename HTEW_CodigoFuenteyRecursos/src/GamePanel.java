
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

import javax.swing.*;
import java.text.DecimalFormat;
import java.util.Random;

public class GamePanel extends JPanel implements Runnable {
	
	private static final int PWIDTH = 1280;
	private static final int PHEIGHT = 700; //tamano del panel
	
	private Thread animator; //controla la animacion
	private volatile boolean running = false;
	private volatile boolean gameOver = false;
	private volatile boolean isPaused = false;
	private GameStateContext context;
	private Image background;
	private BufferedImage background2;
	
	public GamePanel(){
		setBackground(Color.white);
		setPreferredSize(new Dimension(PWIDTH,PHEIGHT));
		setFocusable(true);
		requestFocus();
		readyForTermination();
		
		
		addMouseListener( new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				testPress(e.getX(), e.getY()); }
		});
		
		context = new GameStateContext(PWIDTH, PHEIGHT);
		background = new ImageIcon("resources/fondo1.png"). getImage();
		background2=ImageLoader.getInstance().getImage("background");
		background2=background2.getSubimage(0, 0, 1280, 700);
	} //GamePanel()
	
	public void addNotify()
	{
		super.addNotify();
		startGame();
	}//addNotify
	
	private void startGame()
	{
		if(animator == null || !running){
			animator = new Thread(this);
			animator.start();
		}
	}//startGame()
	
	public void stopGame(){
		running = false;
	}//stopGame()
	
	public void run(){
		running = true;
		while(running){
			
			gameUpdate();
			gameRender();
			paintScreen();
			
			try{
				Thread.sleep(10);
			}catch(InterruptedException ex){}
		}
		System.exit(0);
	}//run()
	
	private void gameUpdate(){
		
		context.update();
		
		if(!isPaused && !gameOver){
			
		}
		
	}//gameUpdate()
	
	private Graphics dbg;
	private Image dbImage = null;
	
	private void gameRender(){
		if(dbImage == null){
			dbImage = createImage(PWIDTH,PHEIGHT);
			if(dbImage == null){
				System.out.println("dbImage is null");
				return;
			}else{
				dbg = dbImage.getGraphics();
			}
		}
		dbg.setColor(Color.red);
		dbg.drawImage(background, 0, 0, null);
		context.render(dbg);
	}//gameRender()
	
	private void gameOverMessage(){
		Graphics g;
		g=this.getGraphics();
		g.drawString("GameOver",10,10);
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
		if(dbImage != null)
			g.drawImage(dbImage, 0, 0, null);
	}
	
	
	boolean isMainMenu = false;
	private void readyForTermination() {
		addKeyListener( new KeyAdapter() { 
			public void keyPressed(KeyEvent e) { 
				int keyCode = e.getKeyCode();
				if ((keyCode == KeyEvent.VK_ESCAPE) ||
					((keyCode == KeyEvent.VK_C) && e.isControlDown()) ) {
					running = false;
				}
				if(keyCode == KeyEvent.VK_P){
					context.pause();
				}
				if(keyCode == KeyEvent.VK_R){
					context.resume();
				}
				if(keyCode == KeyEvent.VK_RIGHT){
					context.setDirectionX1(1);
					//context.setImageByName1("derecha_caminando");
				}
				if(keyCode == KeyEvent.VK_LEFT){
					context.setDirectionX1(-1);
					//context.setImageByName1("izquierda_caminando");
				}
				if(keyCode == KeyEvent.VK_UP){
					context.setJump1(true);
				}
				if(keyCode == KeyEvent.VK_N){
					context.take1w();
				}
				if(keyCode == KeyEvent.VK_L){
					context.drop1();
				}
				if(keyCode==KeyEvent.VK_M){
					//System.out.println("FIRE1!!!");
					context.fire1();
				}
				if(keyCode == KeyEvent.VK_D){
					context.setDirectionX2(1);
					//context.setImageByName2("derecha_caminando");
				}
				if(keyCode == KeyEvent.VK_A){
					context.setDirectionX2(-1);
					//context.setImageByName2("izquierda_caminando");
				}
				if(keyCode == KeyEvent.VK_W){
					context.setJump2(true);
				}
				if(keyCode == KeyEvent.VK_E){
					context.take2w();
				}
				if(keyCode == KeyEvent.VK_F){
					context.drop2();
				}
				if(keyCode==KeyEvent.VK_Q){
					context.fire2();
				}
				if(keyCode == KeyEvent.VK_ENTER){
					if(!isMainMenu){
						//System.out.println(isMainMenu);
						context.mainMenu();
						isMainMenu = true;
						//System.out.println(isMainMenu);
					}else{
						context.resume();
					}
					
				}
			}
			
			public void keyReleased(KeyEvent e){
				int keyCode = e.getKeyCode();
				if(keyCode == KeyEvent.VK_SPACE){

				}
				if(keyCode == KeyEvent.VK_RIGHT){
					context.setDirectionX1(0);
					//context.setImageByName1("derecha_parado");
					
				}
				if(keyCode == KeyEvent.VK_LEFT){
					context.setDirectionX1(0);
					//context.setImageByName1("izquierda_parado");

				}
				if(keyCode == KeyEvent.VK_D){
					context.setDirectionX2(0);
					//context.setImageByName2("derecha_parado");
				}
				if(keyCode == KeyEvent.VK_A){
					context.setDirectionX2(0);
					//context.setImageByName2("izquierda_parado");
				}
			}
			});
	} // end of readyForTermination()
	
	
	
	private void testPress(int x, int y)
   
    {
      if (!gameOver && !isPaused) {
        
        //System.out.println("HELP ADAPTER");
        // Do Something
		} 
	}
	
	private void paintScreen(){
		Graphics g;
		try{
			g = this.getGraphics();
			if((g != null) && (dbImage != null))
				g.drawImage(dbImage,0,0,this);
			Toolkit.getDefaultToolkit().sync();
			g.dispose();
		}
		catch(Exception e){
			System.out.println("Graphics context error: "+e);
		}
	}
	
	public void pauseGame(){
		isPaused = true;
	}
	
	public void resumeGame(){
		isPaused = false;
	}
	
	public static void main(String args[]){
	 JFrame app = new JFrame("Test");
     app.getContentPane().add(new GamePanel(), BorderLayout.CENTER);
     app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

     app.pack();
     app.setResizable(false);  
     app.setVisible(true);
	}
}


