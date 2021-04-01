package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Panel extends JLayeredPane {
	
	public Panel(int locationXX, int locationYY, int sizeXX, int sizeYY, Color colorr) {
		this.setLayout(null);
		this.setSize(sizeXX, sizeYY);
		this.setLocation(locationXX, locationYY);
		this.setBackground(colorr);
		this.setOpaque(true);
	}
}
