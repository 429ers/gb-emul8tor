package org.the429ers.gameboy;

import java.awt.Color;

public class ColorPalette {
	private Color[] colors;
	
	public ColorPalette() {
		colors = new Color[4];
		for (int i = 0; i < 4; i++) {
			colors[i] = Color.black;
		}
	}
	
	public Color getColor(int colorNum) {
		return colors[colorNum];
	}
	
	public void setRed(int colorNum, int data) {
		int green = colors[colorNum].getGreen();
		int blue = colors[colorNum].getBlue();
		int red = (int) (BitOps.extract(data, 4, 0) * 8);
		colors[colorNum] = new Color(red, green, blue);
	}
	
	public void setLowGreen(int colorNum, int data) {
		int green = colors[colorNum].getGreen() / 8;
		green = green & 0x24;
		green += BitOps.extract(data, 7, 5);
		green *= 8;
		int red = colors[colorNum].getRed();
		int blue = colors[colorNum].getBlue();
		colors[colorNum] = new Color(red, green, blue);
	}
	
	public void setHighGreen(int colorNum, int data) {
		int green = colors[colorNum].getGreen() / 8;
		green = green & 0x7;
		green += BitOps.extract(data, 1, 0);
		green *= 8;
		int red = colors[colorNum].getRed();
		int blue = colors[colorNum].getBlue();
		colors[colorNum] = new Color(red, green, blue);
	}
	
	public void setBlue(int colorNum, int data) {
		int red = colors[colorNum].getRed();
		int blue = colors[colorNum].getBlue();
		int green = (int) (BitOps.extract(data, 6, 2) * 8);
		colors[colorNum] = new Color(red, green, blue);
	}
}