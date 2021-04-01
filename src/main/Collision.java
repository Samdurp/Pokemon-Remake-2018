package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Collision extends JLabel{
	
	public Collision(int posX, int posY) {
		this.setIcon(new ImageIcon(getClass().getResource("/map/test/collision.png")));
		this.setSize(32, 32);
		this.setLocation(posX, posY);
		//this.setVisible(false);
	}
	
}
