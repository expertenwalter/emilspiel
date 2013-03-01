package org.neuschwabenland.emilspiel;

import org.neuschwabenland.emilspiel.util.LevelSpriteLoader;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameLevel {
	private long length;
	private char[][] blocks;

	public GameLevel(long length, char[][] blocks) {
		this.length = length;
		this.blocks = blocks;
	}

	public long getLength() {
		return this.length;
	}

	public char getBlock(int col, int row) {
		return blocks[col][row];
	}
	
	public void update(GameContainer container, StateBasedGame sbg, int delta) {

	}
	
	public void render(Graphics g, LevelSpriteLoader loader)
	{
		for(int x = 0; x < length; x++)
			for (int y = 0; y < 15; y++)
				g.drawImage(loader.getSprite(blocks[x][y]), x * 32, y * 32);
		
	}
}
