package it.meltinteractive.game1.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Block {
	public int x = 0;
	public int y = 0;
	public int w = 20;
	public int h = 20;
	public Color color = Color.RED;
	public boolean inited = false;
	
	public Block() {
	}
	
	// Simple collision model
	public boolean collideTo(Block b) {
		return !((y+h < b.y) || (y > b.y+b.h) || (x > b.x+b.w) || (x+w < b.x));
	}
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g.setColor(color);
		g2D.drawRect(x, y, w, h);
	}
}
