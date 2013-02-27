package org.neuschwabenland.emilspiel;

import java.io.File;

import org.lwjgl.LWJGLUtil;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class EmilGame extends BasicGame {
	public EmilGame()
	  {
	     super("Hello World");
	  }
	 
	  @Override
	  public void init(GameContainer gc) throws SlickException
	  {
	 
	  }
	 
	  @Override
	  public void update(GameContainer gc, int delta) throws SlickException
	  {
	  }
	 
	  @Override
	  public void render(GameContainer gc, Graphics g) throws SlickException
	  {
	     g.drawString("Hello World", 100, 100);
	  }
	 
	  public static void main(String[] args) throws SlickException
	  {
		  System.setProperty("org.lwjgl.librarypath", new File(new File(System.getProperty("user.dir"), "native"), LWJGLUtil.getPlatformName()).getAbsolutePath());
		  System.setProperty("net.java.games.input.librarypath", System.getProperty("org.lwjgl.librarypath"));
		  
	     AppGameContainer app = new AppGameContainer(new EmilGame());
	 
	     app.setDisplayMode(800, 600, false);
	     app.start();
	  }
}
