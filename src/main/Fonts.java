package main;

import java.awt.Font;
import java.awt.GraphicsEnvironment;

public class Fonts {

	public static Font font;
	
	public Fonts() {
		try {
			font = Font.createFont(Font.TRUETYPE_FONT, Main.class.getResource("/font.ttf").openStream());
			GraphicsEnvironment genv = GraphicsEnvironment.getLocalGraphicsEnvironment();
			genv.registerFont(font);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}
	
	
}
