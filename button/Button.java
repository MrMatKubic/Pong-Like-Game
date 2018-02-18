package com.matkubik.test.button;

import java.awt.Color;
import java.awt.Graphics;

import com.matkubik.test.GameManager;
import com.matkubik.test.enums.ButtonType;
import com.matkubik.test.enums.MenuState;
import com.matkubik.test.menus.MenuGame;
import com.matkubik.test.menus.MenuGameover;
import com.matkubik.test.menus.MenuMain;
import com.matkubik.test.other.Keyboard;
import com.matkubik.test.other.Mouse;
import com.matkubik.test.other.Texture;

public class Button {

	// FIELDS
	private Texture texture;
	private int x;
	private int y;
	private int width;
	private int height;
	private ButtonType type;
	private boolean isPressed;
	private Color color;
	
	// CONSTRUCTOR
	public Button(String img, int x, int y, int ratio, ButtonType type) {
		this.texture = new Texture(img);
		this.x = x;
		this.y = y;
		this.isPressed = false;
		this.width = this.texture.getWidth() * ratio;
		this.height = this.texture.getHeight() * ratio;
		this.type = type;
		this.color = Color.BLACK;
	}
	
	// METHODS
	
	// GAME METHODS
	public void tick(Keyboard keyboard) {
		if(Mouse.getX() > this.x && Mouse.getX() < this.x + this.width && Mouse.getY() > this.y && Mouse.getY() < this.y + this.height) {
			this.color = Color.GRAY;
			if(Mouse.getB() == 1)
				this.isPressed = true;
			else
				this.isPressed = false;
		}
		else
			this.color = Color.BLACK;
		
		if(this.isPressed) {
		
			switch(this.type) {
			case PLAY:
				GameManager.menuState = MenuState.GAME;
				break;
			case QUIT:
				break;
			case RESTART:
				GameManager.menuState = MenuState.GAME;
				break;
			case HOME:
				GameManager.menuMain = new MenuMain();
				GameManager.menuGame = new MenuGame();
				GameManager.menuGO = new MenuGameover();
				GameManager.menuState = MenuState.MAIN;
				break;
			default:
					break;
			}
			
		}
	}
	
	public void render(Graphics g) {
		g.drawImage(this.texture.getImage(), this.x, this.y, this.width, this.height, this.color, null);
	}
}
