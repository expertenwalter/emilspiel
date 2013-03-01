package org.neuschwabenland.emilspiel.util;

import java.awt.Rectangle;
import java.io.File;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class LevelSpriteLoader {
	private Image[] sprites;

	public void load() throws SlickException {
		sprites = new Image[256];

		for (int i = 0; i < 256; i++)
			if (new File("res/level/" + i + ".png").exists())
				sprites[i] = new Image("res/level/" + i + ".png");
			else {
				sprites[i] = new Image(32, 32);
				sprites[i].getGraphics().setColor(new Color((i % 16) * 16, (i % 16) * 16, 255-((i % 16) * 16)));
				sprites[i].getGraphics().fillRect(0, 0, 32, 32);
				sprites[i].getGraphics().setColor(Color.white);
				sprites[i].getGraphics().drawString("" + i, 8, 8);
			}
	}

	public Image getSprite(char i) {
		return sprites[i];
	}
}
