package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class PlayerImage extends JLabel{
	
	public PlayerImage() {
		this.setIcon(new ImageIcon(Main.class.getResource("/char/still.png")));
		this.setSize(32, 32);
		this.setLocation(224, 128);
	}
}
