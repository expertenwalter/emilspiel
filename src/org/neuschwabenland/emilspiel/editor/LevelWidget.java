package org.neuschwabenland.emilspiel.editor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JLabel;
import javax.swing.Scrollable;
import javax.swing.SwingConstants;

import org.neuschwabenland.emilspiel.GameLevel;

public class LevelWidget extends JLabel implements Scrollable,
		MouseMotionListener {
	private static final long serialVersionUID = -1104639999632069927L;

	private boolean missingLevel = false;
	private GameLevel level;

	public LevelWidget(GameLevel l) {
		super();
		if (l == null) {
			missingLevel = true;
			setText("No level loaded.");
			setHorizontalAlignment(CENTER);
			setOpaque(true);
			setBackground(Color.white);
		} else
			this.level = l;

		// Let the user scroll by dragging to outside the window.
		setAutoscrolls(true); // enable synthetic drag events
		addMouseMotionListener(this); // handle mouse drags
	}

	// Methods required by the MouseMotionListener interface:
	public void mouseMoved(MouseEvent e) {
	}

	public void mouseDragged(MouseEvent e) {
		// The user is dragging us, so scroll!
		Rectangle r = new Rectangle(e.getX(), e.getY(), 1, 1);
		scrollRectToVisible(r);
	}

	@Override
	public Dimension getPreferredSize() {
		if (missingLevel) {
			return new Dimension(640, 480);
		} else {
			return super.getPreferredSize();
		}
	}

	public Dimension getPreferredScrollableViewportSize() {
		return getPreferredSize();
	}

	public int getScrollableUnitIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		// Get the current position.
		int currentPosition = 0;
		if (orientation == SwingConstants.HORIZONTAL) {
			currentPosition = visibleRect.x;
		} else {
			currentPosition = visibleRect.y;
		}

		// Return the number of pixels between currentPosition
		// and the nearest tick mark in the indicated direction.
		if (direction < 0) {
			int newPosition = currentPosition - currentPosition;
			return (newPosition == 0) ? 1 : newPosition;
		} else {
			return (currentPosition + 1) - currentPosition;
		}
	}

	public int getScrollableBlockIncrement(Rectangle visibleRect,
			int orientation, int direction) {
		if (orientation == SwingConstants.HORIZONTAL) {
			return visibleRect.width - 1;
		} else {
			return visibleRect.height - 1;
		}
	}

	public boolean getScrollableTracksViewportWidth() {
		return false;
	}

	public boolean getScrollableTracksViewportHeight() {
		return false;
	}

	public void setLevel(GameLevel l) {
		this.level = l;
		update(null);
	}
}
