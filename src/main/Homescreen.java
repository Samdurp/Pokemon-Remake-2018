package main;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Homescreen extends JLabel{
	
	//0 is down, 1 is up
	public static int direction = 0;
	
	public static Image logo = new Image(59, 27, 362, 133, "/HomeScreen/pokey.png");
	public static Text subTitle = new Text(100, 150, 300, 50, "Victory Version");
	
	public Homescreen() {
		this.setLocation(0, 0);
		this.setSize(480, 320);
		this.setIcon(new ImageIcon(getClass().getResource("/HomeScreen/background.png")));
		
		this.add(logo);
		this.add(subTitle);
		
		Button start = new Button(173, 220, 134, 50, "PLAY", null);
		this.add(start);
		
		Main.basePanel.add(this);
		
		start.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
	            Main.hs.setVisible(false);
	            Main.ss.setVisible(true);
	        }
		});
	}
	
	public static void moveLogo() {
		if (logo.getLocation().getY() >= 30) {
			direction = 1;
		}
		else if (logo.getLocation().getY() <= 10) {
			direction = 0;
		}
		
		if (direction == 0) {
			logo.setLocation((int) logo.getLocation().getX(), (int) logo.getLocation().getY() + 1);
			subTitle.setLocation((int) subTitle.getLocation().getX(), (int) subTitle.getLocation().getY() + 1);
		}
		else if (direction == 1) {
			logo.setLocation((int) logo.getLocation().getX(), (int) logo.getLocation().getY() - 1);
			subTitle.setLocation((int) subTitle.getLocation().getX(), (int) subTitle.getLocation().getY() - 1);
		}
	}
}
