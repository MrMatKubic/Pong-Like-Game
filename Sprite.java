package com.matkubik.test;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Rectangle;
import com.matkubik.test.other.Texture;

public class Sprite {

	// FIELDS
	protected Texture texture;
	public Rectangle destination;
	
	// CONSTRUCTOR
	public Sprite(String img, int x, int y, int ratio) { 
		this.texture = new Texture(img);
		this.destination = new Rectangle(x, y, this.texture.getWidth() * ratio, this.texture.getHeight() * ratio);
	}
	
	//METHODS
	public void resetPosition() {
		this.destination.x = 0;
		this.destination.y = 0;
	}
		
	public int getX() {
		return this.destination.x;
	}
	
	public int getY() {
		return this.destination.y;
	}
	
	public int getWidth() {
		return this.destination.getWidth();
	}
	
	public int getHeight() {
		return this.destination.getHeight();
	}
	
	// GAME METHODS
	public void tick(Keyboard keyboard) {
	}
	
	public void render(Graphics g) {
		g.drawImage(this.texture.getImage(), this.destination.x, this.destination.y, this.destination.getWidth(), this.destination.getHeight(), null);
	}
	
}
