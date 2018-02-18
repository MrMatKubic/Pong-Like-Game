package com.matkubik.test;

import java.awt.Graphics;

import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Mouse;
import com.matkubik.test.other.Point;
import com.matkubik.test.other.Rectangle;
import com.matkubik.test.other.Texture;

public class Player {

	// FIELDS
	public Rectangle dest1;
	public Rectangle dest2;
	private Point mousePos;
	
	private Texture tex;
	private int speed;
	
	// CONSTRUCTOR
	public Player(String img, int x, int y, int ratio) {
		this.tex = new Texture("player.png");
		this.dest1 = new Rectangle(x, y, this.tex.getWidth() * ratio, this.tex.getHeight() * ratio);
		this.dest2 = new Rectangle(750, 0, this.tex.getWidth() * ratio, this.tex.getHeight() * ratio);
		this.speed = 7;
		this.mousePos = new Point(Mouse.getX(), Mouse.getY());
	}
	
	// METHODS
	public int getYY() {
		return this.dest2.getY();
	}
	
	public int getXX() {
		return this.dest2.getX();
	}
	
	public int getX() {
		return this.dest1.getX();
	}
	
	public int getY() {
		return this.dest1.getY();
	}
	
	public Point Middle1() { return new Point(this.dest1.x + (this.dest1.getWidth() / 2), this.dest1.y + (this.dest1.getHeight() / 2)); }
	public Point Middle2() { return new Point(this.dest2.x + (this.dest1.getWidth() / 2), this.dest2.y + (this.dest1.getHeight() / 2)); }	
	public Point Right1() { return new Point(this.dest1.x + this.dest1.getWidth(), this.dest1.y + (this.dest1.getHeight() / 2)); }
	public Point Left2() { return new Point(this.dest2.x, this.dest2.y + (this.dest2.getHeight() / 2)); }
	
	// GAME METHODS
	public void tick(Keyboard keyboard) {
		
		this.mousePos = new Point(Mouse.getX(), Mouse.getY());
		if(this.dest1.Contains(this.mousePos))
			System.out.println("Souris dans le paddle 1 !");
		// MOVES
		if(keyboard.up)
			this.dest2.y -= this.speed;
		if(keyboard.down)
			this.dest2.y += this.speed;
		if(keyboard.z)
			this.dest1.y -= this.speed;
		if(keyboard.s)
			this.dest1.y += this.speed;
		
		// COLLISIONS
		if(this.dest1.y <= 0)
			this.dest1.y = 0;
		if(this.dest1.y + this.dest1.getHeight() >= 570)
			this.dest1.y = 570 - this.dest1.getHeight();
		if(this.dest2.y < 0)
			this.dest2.y = 0;
		if(this.dest2.y + this.dest1.getHeight() > 570)
			this.dest2.y = 570 - this.dest1.getHeight();
	}
	
	public void render(Graphics g) {
		g.drawImage(this.tex.getImage(), this.dest1.x, this.dest1.y, this.dest1.getWidth(), this.dest1.getHeight(), null);
		g.drawImage(this.tex.getImage(), this.dest2.x, this.dest2.y, this.dest1.getWidth(), this.dest1.getHeight(), null);
	}
}
