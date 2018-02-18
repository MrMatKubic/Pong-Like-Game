package com.matkubik.test;

import java.awt.Color;
import java.awt.Graphics;

import com.matkubik.test.enums.Direction;
import com.matkubik.test.enums.MenuState;
import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Point;

public class Ball extends Sprite {

	// FIELDS
	private Direction direction;
	private int speedX;
	private int speedY;
	
	// CONSTRUCTOR
	public Ball(int x, int y, int ratio) {
		super("ball.png", x, y, ratio);
		this.direction = Direction.UL;
		this.speedX = 4;
		this.speedY = 4;
	}

	// METHODS	
	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Direction getDirection() {
		return this.direction;
	}
	
	public boolean isDirectionEqualTo(Direction direction) { 
		return this.direction == direction;
	}
	
	public Point Left() { return new Point(this.destination.x, this.destination.y + (this.destination.getHeight() / 2)); }
	public Point Right() { return new Point(this.destination.x + this.destination.getWidth(), this.destination.y + (this.destination.getHeight() / 2)); }
	
	// GAME METHODS
	@Override
	public void tick(Keyboard keyboard) {
		super.tick(keyboard);
	
		if(this.direction == Direction.DR) {
			this.destination.x += this.speedX;
			this.destination.y += this.speedY;
		} else if(this.direction == Direction.DL) {
			this.destination.x -= this.speedX;
			this.destination.y += this.speedY;
		} else if(this.direction == Direction.UL) {
			this.destination.x -= this.speedX;
			this.destination.y -= this.speedY;
		} else if(this.direction == Direction.UR) {
			this.destination.x += this.speedX;
			this.destination.y -= this.speedY;
		}
		
		if(this.destination.y < 0 && this.direction == Direction.UR) {
			this.direction = Direction.DR;
		} else if(this.destination.y < 0 && this.direction == Direction.UL) {
			this.direction = Direction.DL;
		}
		
		if(this.destination.x < 0 && this.direction == Direction.UL) {
			GameManager.menuState = MenuState.GAMEOVER;
		} else if(this.destination.x < 0 && this.direction == Direction.DL) {
			GameManager.menuState = MenuState.GAMEOVER;
		}
		
		if(this.destination.x + this.destination.getWidth() > 795 && this.direction == Direction.DR) {
			GameManager.menuState = MenuState.GAMEOVER;
		} else if(this.destination.x + this.destination.getWidth() > 795 && this.direction == Direction.UR) {
			GameManager.menuState = MenuState.GAMEOVER;
		}
		
		if(this.destination.y + this.destination.getHeight() > 570 && this.direction == Direction.DL) {
			this.direction = Direction.UL;
		} else if(this.destination.y + this.destination.getHeight() > 570 && this.direction == Direction.DR) {
			this.direction = Direction.UR;
		}
	}
	
	@Override
	public void render(Graphics g) {
		g.setColor(Color.GREEN);
		super.render(g);
	}
}
