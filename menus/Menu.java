package com.matkubik.test.menus;

import java.awt.Graphics;

import com.matkubik.test.Sprite;
import com.matkubik.test.other.Keyboard;

public class Menu {
	
	protected Sprite background;
	
	public Menu() {
		this.background = new Sprite("background.png", 0, 0, 1);
	}
	
	public void tick(Keyboard keyboard) {
		
	}
	
	public void render(Graphics g) {
		this.background.render(g);
	}
}
