package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Image extends JLabel{

	public Image(int locationX, int locationY, int sizeX, int sizeY, String imageDir) {
		if (imageDir != null) {
			this.setIcon(new ImageIcon(getClass().getResource(imageDir)));
		}
		this.setSize(sizeX, sizeY);
		this.setLocation(locationX, locationY);
	}
}
