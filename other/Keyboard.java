package com.matkubik.test.other;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[120];
	public boolean up, down, left, right, z, s, escape;
	
	public void tick() {
		this.up = keys[KeyEvent.VK_UP];
		this.down = keys[KeyEvent.VK_DOWN];
		this.z = keys[KeyEvent.VK_Z];
		this.s = keys[KeyEvent.VK_S];
		this.escape = keys[KeyEvent.VK_ESCAPE];
	}
	
	public void keyPressed(KeyEvent e) {
		this.keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		this.keys[e.getKeyCode()] = false;		
	}

	public void keyTyped(KeyEvent e) {
		
	}

}
