package main;

public class GameLoop {
	
	public static boolean running = true;
	long lastTime = System.nanoTime();
	double amountOfTicks = 60.0;
	double ns = 1000000000 / amountOfTicks;
	double delta = 0;
	static long timer = System.currentTimeMillis();
	static int updates = 0;
	static int frames = 0;
	
	public GameLoop() {
		while(running){
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1){
				tick();
				
				updates++;
				delta--;
			}
			frame();
			frames++;
						
			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				//System.out.println("FPS: " + frames + "  TICKS: " + updates);
				Main.stats.setText("FPS: " + frames + "   TPS: " + updates);
				frames = 0;
				updates = 0;
				second();
			}
		}
	}
	
	public static void frame() {
		Main.frame.repaint();
	}
	public static void tick() {
		Homescreen.moveLogo();
	}
	public static void second() {
	}
}


