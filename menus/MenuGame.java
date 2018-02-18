package com.matkubik.test.menus;

import java.awt.Graphics;
import java.util.Random;

import com.matkubik.test.Ball;
import com.matkubik.test.Player;
import com.matkubik.test.enums.Direction;
import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Mouse;
import com.matkubik.test.other.Point;

public class MenuGame extends Menu {

	// FIELDS
	private Player player;
	private Ball ball;
	private Random random;
	
	// CONSTRUCTOR
	public MenuGame() {
		super();
		this.random = new Random();
		this.player = new Player("player.png", 15, 0, 6);
		this.ball = new Ball(random.nextInt(770), random.nextInt(570), 2);
	}
	
	public MenuGame(int x) {
		
	}
	
	// METHODS
	
	// GAME METHODS
	public void tick(Keyboard keyboard) {
		super.tick(keyboard);
		this.player.tick(keyboard);
		this.ball.tick(keyboard);
		
		// PLAYER COLLISIONS WITH BALL
		// LEFT PLAYER	
		if(this.player.dest1.Contains(this.ball.Left())) {
			if(this.ball.getDirection() == Direction.UL)
				this.ball.setDirection(Direction.UR);
			if(this.ball.getDirection() == Direction.DL)
				this.ball.setDirection(Direction.DR);
		}
		
		if(this.player.dest2.Contains(this.ball.Right())) {
			if(this.ball.getDirection() == Direction.UR)
				this.ball.setDirection(Direction.UL);
			if(this.ball.getDirection() == Direction.DR)
				this.ball.setDirection(Direction.DL);
		}
	}
	
	public void render(Graphics g) {
		super.render(g);
		this.player.render(g);
		this.ball.render(g);
	}
}
