package com.matkubik.test.menus;

import java.awt.Graphics;

import com.matkubik.test.button.Button;
import com.matkubik.test.enums.ButtonType;
import com.matkubik.test.other.Keyboard;

public class MenuMain extends Menu {
	
	private Button start;
	
	public MenuMain(){
		super();
		this.start = new Button("startButton.png", 370, 280, 3, ButtonType.PLAY);
	}
	
	public void tick(Keyboard keyboard){
		super.tick(keyboard);
		this.start.tick(keyboard);
	}
		
	public void render(Graphics g){
		super.render(g);
		this.start.render(g);
	}
}
