package main;

import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class Frame extends JFrame{
	
	public Frame() {
		this.setIconImage(new ImageIcon(getClass().getResource("/icon.png")).getImage());
		this.setLayout(null);
		this.getContentPane().setPreferredSize(new Dimension(480, 320)); //-10 on both y and x so it fits perfectly when it's not resizable (idk why just deal), NORMALLY 480 320
	    this.pack();
		this.setTitle("Pokemon");
		this.setResizable(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
