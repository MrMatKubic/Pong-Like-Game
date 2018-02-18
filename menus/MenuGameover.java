package com.matkubik.test.menus;

import java.awt.Graphics;

import com.matkubik.test.button.Button;
import com.matkubik.test.enums.ButtonType;
import com.matkubik.test.other.Keyboard;

public class MenuGameover extends Menu {

	// FIELDS
	private Button home;
	
	// CONSTRUCTOR
	public MenuGameover() {
		super();
		this.home = new Button("home.png", 280, 150, 3, ButtonType.HOME); 
	}
	
	// METHODS
	
	// GAME METHODS
	public void tick(Keyboard keyboard) {
		super.tick(keyboard);
		this.home.tick(keyboard);
	}
	
	public void render(Graphics g) {
		super.render(g);
		this.home.render(g);
	}
	
}
