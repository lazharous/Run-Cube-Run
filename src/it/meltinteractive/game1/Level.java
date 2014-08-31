package it.meltinteractive.game1;

import it.meltinteractive.game1.Blocks.Block;
import it.meltinteractive.game1.Blocks.Grace;
import it.meltinteractive.game1.Blocks.Rock;
import it.meltinteractive.game1.Blocks.SkyBlock;
import it.meltinteractive.game1.Blocks.Star;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Level {
	private int w = Game.WIDTH * Game.SCALE;
	private int h = 180;
	private Player player;
	private List<Block> listBlock = new ArrayList<Block>();
	private boolean lose = false;
	private long timer;
	private boolean graceAdded;
	private boolean win;
	
	public Level() {
		Random r = new Random();
		lose = false;
		win = false;
		
		graceAdded = false;
		timer = System.currentTimeMillis()+r.nextInt(10000)+15000;
	}
	
	public void addPlayer(Player player) {
		this.player = player;
	}
	
	public void update() {
		if (lose || win)
			return;
		
		if ((System.currentTimeMillis() - timer >= 0) && !graceAdded) {
			listBlock.add(new Grace());
			graceAdded = true;
		}
		
		if (player.y == h-player.h)
			player.colliding = true;
		
		generateBlocks();
		updateBlocks();
		
		// Check for player collision
		for(int i=0; i<listBlock.size(); i++) {
			Block b = listBlock.get(i);
			if (player.collideTo(b)) {				
				if (b instanceof SkyBlock) {
					player.jumping = false;
					player.colliding = false;
					player.update();
					return;
				}
				
				if (b instanceof Star) {
					player.score++;
				} else if (b instanceof Rock) {
					player.x -= 20;
				} else if (b instanceof Grace) {
					this.win = true;
				}
				
				listBlock.remove(i);
			}
		}
		
		if (player.x < 0)
			lose = true;
		
		player.update();
	}

	private void updateBlocks() {		
		for(int i=0; i<listBlock.size(); i++) {
			Block b = listBlock.get(i);
			
			if (!b.inited) {
				b.inited = true;
				b.x = Game.WIDTH * Game.SCALE + b.w;
				
				if (b.y == 0)
					b.y = h-b.h;
			}
			
			if (i > 0) {
				if (listBlock.get(i-1).collideTo(b)) {
					listBlock.remove(i-1);
				}
			}
			
			b.x -= 2;
			
			if (b instanceof Grace) {
				if (b.x <= 0) {
					this.lose = true;
				}
			}
		}
	}

	private void generateBlocks() {
		Random r = new Random();
		int bp = r.nextInt(100);
		
		switch (bp)
		{
		case 12:
			listBlock.add(new Rock());
			break;
		
		case 26:
			listBlock.add(new Star());
			break;
		
		case 82:
			listBlock.add(new SkyBlock());
			break;
		}
	}

	public void draw(Graphics g) {
		Graphics2D g2D = (Graphics2D)g;
		
		if (win) {
			g.setColor(Color.WHITE);
			g2D.drawString("YOU WIN!", 10, 50);
			g2D.drawString("Score: " + player.score, 10, 20);			
		} else if (lose) {
			g.setColor(Color.RED);
			g2D.drawString("YOU LOSE!", 10, 50);
			g2D.drawString("Score: " + player.score, 10, 20);
		} else {
			g.setColor(Color.WHITE);
			g2D.drawLine(0, h, w, h);
			
			// draws all the blocks
			for(int i=0; i<listBlock.size(); i++)
				listBlock.get(i).draw(g);
			
			g.setColor(Color.WHITE);
			g2D.drawString("Score: " + player.score, 10, 20);
			
			player.draw(g);
		}
	}
}
