package it.meltinteractive.game1.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Star extends Block {
	public Star() {
		this.color = Color.YELLOW;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g.setColor(color);
		
		g2D.drawLine(x+10, y+0,  x+5,  y+5);
		g2D.drawLine(x+5,  y+5,  x+0,  y+7);
		g2D.drawLine(x+0,  y+7,  x+5,  y+9);
		g2D.drawLine(x+5,  y+9,  x+4,  y+18);
		g2D.drawLine(x+4,  y+18, x+10, y+12);
		
		g2D.drawLine(x+10, y+12, x+16, y+18);
		g2D.drawLine(x+16, y+18, x+16, y+9);
		g2D.drawLine(x+16, y+9,  x+w,  y+7);
		g2D.drawLine(x+w,  y+7,  x+15, y+5);
		g2D.drawLine(x+15, y+5,  x+10, y+0);
	}
}
