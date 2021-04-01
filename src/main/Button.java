package main;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Button extends JButton{
	
	public Button(int locationX, int locationY, int sizeX, int sizeY, String text, String imageDir) {
		this.setLocation(locationX, locationY);
		this.setSize(sizeX, sizeY);
		this.setText(text);
		this.setFocusPainted(false);
		this.setBorderPainted(false);
		this.setContentAreaFilled(false);
		this.setFont(Fonts.font.deriveFont(Font.PLAIN, 25f));
		this.setForeground(Color.black);
		this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		if (imageDir != null) {
			this.setIcon(new ImageIcon(getClass().getResource(imageDir)));
		}
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Sound.playSound("/audio/select.wav", false);
			}
		});
	}
}
