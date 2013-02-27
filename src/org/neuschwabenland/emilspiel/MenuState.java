package org.neuschwabenland.emilspiel;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {
	public static final int ID = 2;
	private int menuIndex = 0;

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		// TODO Auto-generated method stub

	}

	@Override
	public void render(GameContainer container, StateBasedGame sbg, Graphics g) {
		// Draw Menu Items
		g.drawString("Play", 300, 400);
		g.drawString("Credits", 280, 430);
		g.drawString("Exit", 300, 460);

		// Draw Arrow
		g.drawString("->", 250, 400 + menuIndex * 30);

	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int arg2) {
		Input input = container.getInput();

		if (input.isKeyPressed(Input.KEY_ESCAPE))
			System.exit(0);

		// Menu selection
		if (input.isKeyPressed(Input.KEY_UP)) {
			menuIndex--;

			if (menuIndex < 0)
				menuIndex = 0;
		}

		if (input.isKeyPressed(Input.KEY_DOWN)) {
			menuIndex++;

			if (menuIndex > 2)
				menuIndex = 1;
		}

		if (input.isKeyPressed(Input.KEY_ENTER)) {
			if (menuIndex == 0)
				sbg.enterState(GameState.ID);

			if (menuIndex == 1)
				sbg.enterState(CreditState.ID);

			if (menuIndex == 2)
				System.exit(0);
		}
	}

	@Override
	public int getID() {
		return ID;
	}
}
