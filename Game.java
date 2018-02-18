package com.matkubik.test;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Mouse;

public class Game extends Canvas implements Runnable {
	public static int Width = 800;
	public static int Height = 600;
	
	private static final long serialVersionUID = -2408406005337283541L;
	private Thread thread;
	private Keyboard keyboard;
	private Mouse mouse;
	
	private boolean running;
	
	public Game() {
		new Window(Width, Height, "Game !!!", this);
		this.keyboard = new Keyboard();
		this.mouse = new Mouse();
		
		addKeyListener(this.keyboard);
		addMouseListener(this.mouse);
		addMouseMotionListener(this.mouse);
	}
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		this.running = true;
	}
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				System.out.println("FPS : " + frames);
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		this.keyboard.tick();
		if(this.keyboard.escape)
			System.exit(0);
		GameManager.tick(this.keyboard);
	}

	private void render()  {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.CYAN);
		g.fillRect(0, 0, Width, Height);
		GameManager.render(g);
		
		
		g.dispose();
		bs.show();
	}

	public static void main(String args[]) {
		new Game();
	}
}
