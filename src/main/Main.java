package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Main {

	public static Frame frame;
	public static Panel basePanel;
	public static int fpsCounter = 0;
	public static int tickCounter = 0;
	
	public static Homescreen hs;
	public static SaveSelect ss;
	public static GameLoop gl;
	public static GamePlay gp;
	
	public static JLabel stats;
	
	public static Fonts f = new Fonts();
	
	public static void main(String[] args) {
		frame = new Frame();
		basePanel = new Panel(0, 0, 480, 320, Color.green);
		hs = new Homescreen();
		ss = new SaveSelect();
		ss.setVisible(false);
		
		frame.getContentPane().add(basePanel);
		
		stats = new JLabel("FPS: 0   TPS: 0");
		stats.setLocation(5, 5);
		stats.setSize(140, 10);
		stats.setForeground(Color.BLACK);
		stats.setOpaque(true);
		stats.setBackground(new Color(255,255,255,127));
		frame.add(stats, 10,0);
		
		frame.setVisible(true);	
		
		gl = new GameLoop();
	}
	
	public static void createGamePlay() {
		gp = new GamePlay();
	}
}

	
