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

	public void update(GameContainer container, StateBasedGame sbg, int delta) {

	}

	public void render(Graphics g)
	{
		
	}
}
