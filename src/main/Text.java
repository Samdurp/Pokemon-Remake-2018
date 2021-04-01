package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;

import javax.swing.JLabel;

public class Text extends JLabel{

	public Text(int locationX, int locationY, int sizeX, int sizeY, String text) {
		this.setLocation(locationX, locationY);
		this.setSize(sizeX, sizeY);
		this.setText(text);
		this.setFont(Fonts.font.deriveFont(Font.PLAIN, 25f));
		this.setForeground(Color.black);
	}
	
}
