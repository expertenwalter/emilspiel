package org.neuschwabenland.emilspiel;

import org.neuschwabenland.emilspiel.util.LevelSpriteLoader;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class GameLevel {
	private Color bgColor;
	private long length;
	private char[][] blocks;

	public GameLevel(Color bgColor, long length, char[][] blocks) {
		this.length = length;
		this.blocks = blocks;
	}

	public Color getBgColor() {
		return this.bgColor;
	}

	public long getLength() {
		return this.length;
	}
	
	public int getRows()
	{
		return this.blocks[0].length;
	}

	public char getBlock(int col, int row) {
		return blocks[col][row];
	}

	public void update(GameContainer container, StateBasedGame sbg, int delta) {

	}

	public void render(GameCamera camera, Graphics g, LevelSpriteLoader loader) {
		g.setColor(this.bgColor);
		g.fillRect(0, 0, 640, 480);

		for (int x = ((int) camera.getX()) / 32; x < length; x++)
			for (int y = 0; y < 15; y++)
				g.drawImage(loader.getSprite(blocks[x][y]),
						x * 32 - camera.getX(), y * 32);

	}
}
