package org.neuschwabenland.emilspiel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class PlayerObject extends GameObject {
	private Image playerImage;

	private boolean jumping = false;
	private float upspeed = 0.0f;

	public PlayerObject(float x, float y) throws SlickException {
		super(GameObject.ObjectType.TYPE_PLAYER, x, y);
		playerImage = new Image("res/player/player.png");
	}

	public void update(GameContainer container, StateBasedGame sbg,
			GameLevel level, int delta) {
		// Right
		if (container.getInput().isKeyDown(Input.KEY_RIGHT)) {
			xPos += delta / 10;

			if (xPos > (level.getLength() - 1) * 64)
				xPos = 0;
		}

		// Left
		if (container.getInput().isKeyDown(Input.KEY_LEFT)) {
			xPos -= delta / 10;

			if (xPos < 0)
				xPos = 0;
		}

		// Jump
		if (container.getInput().isKeyDown(Input.KEY_UP) && !jumping) {
			jumping = true;
			upspeed = 300.0f;
			yPos += 1;
		}

		int playerRow = level.getRows() - (int) (yPos / 32);

		System.out.println("xPos: " + xPos + " yPos: " + yPos + " block: "
				+ (int) level.getBlock((int) (xPos / 32), playerRow));

		// Check if we are standing on solid ground
		if (level.getBlock((int) (xPos / 32), playerRow) != 0) {
			jumping = false;
			upspeed = 0.0f;
			yPos = (level.getRows() - playerRow + 1) * 32;
		} else if(level.getBlock((int) (xPos / 32), playerRow - 1) != 0)
		{
			upspeed = 0;
			yPos = (level.getRows() - playerRow) * 32 - 1;
		}
		else
			upspeed -= (450 / 1000.0f * delta);

		yPos = yPos + (upspeed / 1000.0f * delta);
	}

	public void render(GameCamera camera, Graphics g) {
		g.drawImage(playerImage, xPos, 480 - yPos);
	}
}
