package org.neuschwabenland.emilspiel;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class MainClass {
	public static void main(String args[]) throws SlickException {
		System.setProperty("org.lwjgl.librarypath",
				new File(new File(System.getProperty("user.dir"), "native"),
						LWJGLUtil.getPlatformName()).getAbsolutePath());
		System.setProperty("net.java.games.input.librarypath",
				System.getProperty("org.lwjgl.librarypath"));

		// Create app
		AppGameContainer app = new AppGameContainer(new GameStateController());

		app.setDisplayMode(640, 480, false);
		app.start();
	}
}
