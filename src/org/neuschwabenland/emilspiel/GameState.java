package org.neuschwabenland.emilspiel;

import org.neuschwabenland.emilspiel.util.LevelSpriteLoader;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Music;
import org.newdawn.slick.MusicListener;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState implements MusicListener {
	public static final int ID = 3;
	public GameLevel level;
	public GameObject player;
	public GameCamera camera;
	LevelSpriteLoader loader;

	private void startLevel(int levelId) throws Exception {
		// level = LevelLoader.load("levels/" + levelId + ".lvl");
		level = new TestLevel();
		player = new PlayerObject(32, 48);
	}

	@Override
	public void init(GameContainer arg0, StateBasedGame arg1)
			throws SlickException {
		try {
			loader = new LevelSpriteLoader();
			loader.load();

			startLevel(1);
		} catch (Exception e) {
			throw new SlickException(e.getMessage());
		}
	}

	@Override
	public void render(GameContainer arg0, StateBasedGame arg1, Graphics g)
			throws SlickException {
		level.render(g, loader);
		player.render(g);

	}

	@Override
	public void update(GameContainer container, StateBasedGame sbg, int delta)
			throws SlickException {
		player.update(container, sbg, delta);
		level.update(container, sbg, delta);
	}

	@Override
	public void musicEnded(Music arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void musicSwapped(Music arg0, Music arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public int getID() {
		return ID;
	}

}
