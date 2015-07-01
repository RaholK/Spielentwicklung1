//Rahol

package MoveTest;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
//Spiel läuft in Frames ab --> 1 Frame besteht aus einer Berechnung
// und einer Zeichnung
public class Frame extends JFrame{
	private Screen screen;
	//Anfangsposition
	float player_posx = 300;
	float player_posy = 300;
	private int player_size = 50;
	
	private boolean key_up = false;
	private boolean key_down = false;
	private boolean key_right = false;
	private boolean key_left = false;
	
	public Frame() {
		super("MoveTest");
		screen = new Screen();
		//Anfangsauflösung und größe der Spielwelt
		screen.setBounds(0, 0, 800, 600);
		add(screen);
		addKeyListener(new KeyHandler());
	}
	
	public boolean getUp() {
		return key_up;
	}
	
	public boolean getDown() {
		return key_down;
	}
	public boolean getLeft() {
		return key_left;
	}
	public boolean getRight() {
		return key_right;
	}
	
	
	
	public void repaintScreen() {
		screen.repaint();
	}
	private class Screen extends JLabel {
		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			g.setColor(Color.red); //rote Farbe
			g.fillRect((int)player_posx, (int)player_posy, player_size, player_size);
		}
	}
	private class KeyHandler implements KeyListener {

		@Override
		
		//hier wird angegeben wie man das Quadrat steuert
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S) {
				key_down = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_W) {
				key_up = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_D) {
				key_right = true;
			}
			if(e.getKeyCode() == KeyEvent.VK_A) {
				key_left = true;
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_S) {
				key_down = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_W) {
				key_up = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_D) {
				key_right = false;
			}
			if(e.getKeyCode() == KeyEvent.VK_A) {
				key_left = false;
			}
			
		}

		
		
		
		
		
		
		//unnötig
		public void keyTyped(KeyEvent arg0) {
			
		}
		
	}
}
