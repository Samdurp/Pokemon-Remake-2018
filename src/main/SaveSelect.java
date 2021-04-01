package main;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

public class SaveSelect extends JLabel {
	
	public static Button save1 = new Button(50, 50, 160, 50, "SAVE1", null), 
						 save2 = new Button(50, 100, 160, 50, "SAVE2", null),
						 back = new Button(50, 150, 160, 50, "BACK", null);
	
	public SaveSelect() {
		this.setLocation(0,0);
		this.setSize(480, 320);
		this.add(save1);
		this.add(save2);
		this.add(back);
		Main.basePanel.add(this);
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.ss.setVisible(false);
				Main.hs.setVisible(true);
			}
		});
		save1.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Main.ss.setVisible(false);
				Main.createGamePlay();
			}
		});
	}
	
}
