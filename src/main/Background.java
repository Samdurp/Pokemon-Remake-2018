package main;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Background extends JLabel {
	
	public Background(String filePath, int posX, int posY) {
		this.setIcon(new ImageIcon(getClass().getResource(filePath)));
		this.setLocation(posX, posY);
		try {  
			BufferedImage bimg = ImageIO.read(getClass().getResource(filePath));
			this.setSize(bimg.getWidth(), bimg.getHeight());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
