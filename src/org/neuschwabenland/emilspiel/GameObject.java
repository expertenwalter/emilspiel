package org.neuschwabenland.emilspiel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public abstract class GameObject {

	public enum ObjectType {
		TYPE_NEUTRAL, TYPE_PLAYER, TYPE_ENEMY
	};

	protected float xPos, yPos;
	protected ObjectType type;

	protected GameObject(ObjectType type, float xPos, float yPos) {

		this.xPos = xPos;
		this.yPos = yPos;
		this.type = type;
	}

	public float getX() {
		return this.xPos;
	}

	public float getY() {
		return this.yPos;
	}

	public void update(GameContainer container, StateBasedGame sbg, GameLevel level, int delta) {

	}

	public void render(GameCamera camera, Graphics g) {

	}
}
