package org.neuschwabenland.emilspiel;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class PlayerObject extends GameObject {
	private Image playerImage;

	public PlayerObject(float x, float y) throws SlickException {
		super(GameObject.ObjectType.TYPE_PLAYER, x, y);
		playerImage = new Image("res/player/player.png");
	}

}
