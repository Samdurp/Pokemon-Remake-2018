package main;

import java.awt.Color;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Rectangle;
import java.util.List;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class GamePlay{
	
	public static Background bg = new Background("/map/test/basic.png", 0, 0);
	public static PlayerImage pi = new PlayerImage();
	public static Panel bp = new Panel(0,0, 4000, 4000, Color.black);
	
	public static int offsetX = 7; //Higher = left, lower = right
	public static int offsetY = -7; //Higher = right, lower = left
	
	public static boolean play = true;
	
	public static int poseCounter = 0;
	
	public static char keyPressed;
	public static char up = 'w';
	public static char down = 's';
	public static char left = 'a';
	public static char right = 'd';
	
	public static boolean collision = false;
	
	public static String direction = null;
	
	public static boolean allowWalkUp = true;
	public static boolean allowWalkDown = true;
	public static boolean allowWalkLeft = true;
	public static boolean allowWalkRight = true;
	
	public static List<Collision> collisions = new ArrayList<Collision>();

	public GamePlay() {
		bg.setLocation(bg.getX() + (offsetX * 32), bg.getY() + (offsetY * 32));
		createCollisions(bg.getWidth()/32, bg.getHeight()/32);
		Main.frame.remove(Main.basePanel);
		Main.frame.add(bp);
		for (int i = 0; i < collisions.size(); i++) {
			bp.add(collisions.get(i));
		}
		bp.add(bg);
		bp.add(pi, 5,0);
		KeyEventDispatcher keyEventDispatcher = new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					keyPressed = (char) e.getKeyChar();
					checkCollision();
					if (e.getKeyChar() == up && play && allowWalkUp) { 	
						direction = "up";
						bg.setLocation((int) bg.getLocation().getX(), (int) bg.getLocation().getY() + 32);
						for (int i = 0; i < collisions.size(); i++) {
							collisions.get(i).setLocation(collisions.get(i).getX(), collisions.get(i).getY() + 32);
						}
					}
					else if (e.getKeyChar() == down && play && allowWalkDown) { 
						direction = "down";
						bg.setLocation((int) bg.getLocation().getX(), (int) bg.getLocation().getY() - 32);
						for (int i = 0; i < collisions.size(); i++) {
							collisions.get(i).setLocation(collisions.get(i).getX(), collisions.get(i).getY() - 32);
						}
					}
					else if (e.getKeyChar() == left && play && allowWalkLeft) { 
						direction = "left";
						bg.setLocation((int) bg.getLocation().getX() + 32, (int) bg.getLocation().getY());
						for (int i = 0; i < collisions.size(); i++) {
							collisions.get(i).setLocation(collisions.get(i).getX() + 32, collisions.get(i).getY());	
						}
					}
					else if (e.getKeyChar() == right && play && allowWalkRight) { 
						direction = "right";
						bg.setLocation((int) bg.getLocation().getX() - 32, (int) bg.getLocation().getY());
						for (int i = 0; i < collisions.size(); i++) {
							collisions.get(i).setLocation(collisions.get(i).getX() - 32, collisions.get(i).getY());
						}
					}
					checkForEnables();
					changePose();
				}
				return false;
			}
		};
		//Honestly dunno what this does but the program needs it
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(keyEventDispatcher);
		return;
	}
	
	public static void changePose() {
		if (poseCounter == 0) {
			pi.setIcon(new ImageIcon(Main.class.getResource("/char/still.png")));
			poseCounter = 1;
		}
		else if (poseCounter == 1) {
			pi.setIcon(new ImageIcon(Main.class.getResource("/char/left.png")));
			poseCounter = 2;
		}
		else if (poseCounter == 2) {
			pi.setIcon(new ImageIcon(Main.class.getResource("/char/still.png")));
			poseCounter = 3;
		}
		else if (poseCounter == 3) {
			pi.setIcon(new ImageIcon(Main.class.getResource("/char/right.png")));
			poseCounter = 0;
		}
	}
	
	public static void checkCollision() {
		for (int i = 0; i < collisions.size(); i++) {
			//Up
			if (new Rectangle(pi.getX(), pi.getY() - 32, 32, 32).intersects(collisions.get(i).getBounds())) {
				allowWalkUp = false;
			}
			//Down
			if (new Rectangle(pi.getX(), pi.getY() + 32, 32, 32).intersects(collisions.get(i).getBounds())) {
				allowWalkDown = false;
			}
			//Left
			if (new Rectangle(pi.getX() - 32, pi.getY(), 32, 32).intersects(collisions.get(i).getBounds())) {
				allowWalkLeft = false;
			}
			//Right
			if (new Rectangle(pi.getX() + 32, pi.getY(), 32, 32).intersects(collisions.get(i).getBounds())) {
				allowWalkRight = false;
			}
		}
	}
	
	public static void checkForEnables() {
		for (int i = 0; i < collisions.size(); i++) {
			//Up
			if (!(new Rectangle(pi.getX(), pi.getY() - 32, 32, 32).intersects(collisions.get(i).getBounds()))) {
				allowWalkUp = true;
			}
			//Down
			if (!(new Rectangle(pi.getX(), pi.getY() + 32, 32, 32).intersects(collisions.get(i).getBounds()))) {
				allowWalkDown = true;
			}
			//Left
			if (!(new Rectangle(pi.getX() - 32, pi.getY(), 32, 32).intersects(collisions.get(i).getBounds()))) {
				allowWalkLeft = true;
			}
			//Right
			if (!(new Rectangle(pi.getX() + 32, pi.getY(), 32, 32).intersects(collisions.get(i).getBounds()))) {
				allowWalkRight = true;
			}
		}
	}
	
	public static void checkBorderCollision() {
	}
	
	public static void createCollisions(int borderLengthX, int borderLengthY) {
		int x1 = -32 + (offsetX * 32);
		int y1 = 0 + (offsetY * 32);
		int x2 = 0 + (offsetX * 32);
		int y2 = -32 + (offsetY * 32);
		int x3 = 0 + (offsetX * 32);
		int y3 = bg.getHeight() + (offsetY * 32);
		int x4 = bg.getWidth() + (offsetX * 32);
		int y4 = 0 + (offsetY * 32);
		//Top border
		for (int i = 0; i < borderLengthX; i++) {
			collisions.add(new Collision(x2, y2));
			x2 += 32;
		}
		//Left border
		for (int i = 0; i < borderLengthY; i++) {
			collisions.add(new Collision(x1, y1));
			y1 += 32;
		}
		//Bottom border
		for (int i = 0; i < borderLengthX; i++) {
			collisions.add(new Collision(x3, y3));
			x3 += 32;
		}
		//Right border
		for (int i = 0; i < borderLengthY; i++) {
			collisions.add(new Collision(x4, y4));
			y4 += 32;
		}
	}
}
	
	



			
		


