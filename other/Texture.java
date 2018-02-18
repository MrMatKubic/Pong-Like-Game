package com.matkubik.test.other;

import java.awt.image.BufferedImage;

import com.matkubik.test.loader.ImageLoader;

public class Texture {

	private BufferedImage image;
	
	public Texture(String img) {
		this.image = ImageLoader.loadImage("/textures/" + img);
	}
	
	public BufferedImage getImage() {
		return this.image;
	}
	
	public int getWidth() {
		return this.image.getWidth();
	}
	
	public int getHeight() {
		return this.image.getHeight();	
	}
	
}
