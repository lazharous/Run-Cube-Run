package it.meltinteractive.game1.Blocks;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Grace extends Block {
	public Grace() {
		this.color = Color.PINK;
	}
	
	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g.setColor(this.color);
		g2D.drawOval(x, y, w, h);
		g2D.drawOval(x+2, y+2, 3, 3);
		g2D.drawOval(x+9, y+2, 3, 3);
		g2D.drawArc(x, y+5, 13, 10, -20, -120);
	}
}
