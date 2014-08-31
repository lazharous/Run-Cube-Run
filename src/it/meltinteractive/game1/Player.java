package it.meltinteractive.game1;

import it.meltinteractive.game1.Blocks.Block;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Player extends Block {
	private static final int JUMPING_HEIGHT = 30;
	private InputManager im;
	public boolean jumping;
	public int toJump;
	public boolean colliding;
	public int score = 0;
	
	public Player(InputManager inputManager) {
		im = inputManager;
		jumping = false;
		colliding = false;
		x = (Game.WIDTH * Game.SCALE)/2 - w/2;
		y = 50;
		inited = true;
		color = Color.WHITE;
	}
	
	public void update() {		
		jumping();
		gravity();
	}
	
	private void gravity() {
		if (!colliding) {
			y += 2;
		}
	}

	private void jumping() {
		if (im.jumped && !jumping && colliding) {
			toJump = JUMPING_HEIGHT;
			jumping = true;
		}
		
		if (jumping) {
			if (toJump-- <= 0) {
				jumping = false;
				colliding = false;
			}
			
			y -= 2;
		}		
	}

	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		g.setColor(color);
		g2D.drawOval(x, y, w, h);
		g2D.drawOval(x+6, y+2, 3, 3);
		g2D.drawOval(x+w-7, y+2, 3, 3);
		g2D.drawArc(x+4, y+5, 13, 10, -20, -120);
	}
}
