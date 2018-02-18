package com.matkubik.test;

import java.awt.Graphics;

import com.matkubik.test.enums.MenuState;
import com.matkubik.test.menus.MenuGame;
import com.matkubik.test.menus.MenuGameover;
import com.matkubik.test.menus.MenuMain;
import com.matkubik.test.other.Keyboard;

public class GameManager {
	
	public static MenuState menuState = MenuState.MAIN;
	public static MenuMain menuMain = new MenuMain();
	public static MenuGame menuGame = new MenuGame();
	public static MenuGameover menuGO = new MenuGameover();
	
	public GameManager(){
		
	}
	
	public static void tick(Keyboard keyboard){
		if(menuState == MenuState.MAIN) {
			menuMain.tick(keyboard);			
		} else if(menuState == MenuState.GAME) {
			menuGame.tick(keyboard);
		} else if(menuState == MenuState.GAMEOVER) {
			menuGO.tick(keyboard);	
		}
	}
	
	public static void render(Graphics g){
		if(menuState == MenuState.MAIN)
			menuMain.render(g);
		else if(menuState == MenuState.GAME)
			menuGame.render(g);
		else if(menuState == MenuState.GAMEOVER)
			menuGO.render(g);
	}
}
