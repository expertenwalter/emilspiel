package org.neuschwabenland.emilspiel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameStateController extends StateBasedGame {
	public GameStateController() {
		super("EmilSpiel");
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		// addState(new LogoState());
		addState(new MenuState());
		addState(new CreditState());
		addState(new GameState());
		addState(new GameOverState());
	}
}
