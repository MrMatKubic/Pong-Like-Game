package com.matkubik.test.other;

public class Rectangle {

	public int x;
	public int y;
	private int width;
	private int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public boolean Contains(Point point) {
		return point.getX() > this.x && point.getX() < this.x + this.width && point.getY() > this.y && point.getY() < this.y + this.height;
	}
}
