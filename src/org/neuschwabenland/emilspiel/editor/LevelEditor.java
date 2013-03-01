package org.neuschwabenland.emilspiel.editor;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class LevelEditor extends JFrame implements ActionListener {
	private static final long serialVersionUID = -8012744555949437892L;

	private JMenuBar menuBar;
	private JMenu fileMenu;
	private JMenuItem newMenuItem, saveMenuItem, openMenuItem, exitMenuItem;

	private LevelWidget levelWidget;

	public LevelEditor() {
	}

	private void createMenu(JFrame frame) {
		menuBar = new JMenuBar();

		// First menu: "File"
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);

		newMenuItem = new JMenuItem("New...", KeyEvent.VK_N);
		newMenuItem.addActionListener(this);
		fileMenu.add(newMenuItem);

		saveMenuItem = new JMenuItem("Save...", KeyEvent.VK_S);
		saveMenuItem.addActionListener(this);
		fileMenu.add(saveMenuItem);

		openMenuItem = new JMenuItem("Open...", KeyEvent.VK_O);
		openMenuItem.addActionListener(this);
		fileMenu.add(openMenuItem);

		fileMenu.addSeparator();

		exitMenuItem = new JMenuItem("Exit...", KeyEvent.VK_X);
		exitMenuItem.addActionListener(this);
		fileMenu.add(exitMenuItem);

		// Add menubar to frame
		frame.setJMenuBar(menuBar);
	}

	private void createLevelPane(JPanel panel) {
		levelWidget = new LevelWidget(null);

		JScrollPane levelScrollPane = new JScrollPane(levelWidget);
		panel.add(levelScrollPane, BorderLayout.CENTER);
	}

	private void createSpritePane(JPanel panel) {

	}

	public void start() {
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BorderLayout());
		this.getContentPane().add(centerPanel);

		createMenu(this);
		createLevelPane(centerPanel);
		createSpritePane(centerPanel);

		pack();
		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		LevelEditor editor = new LevelEditor();
		editor.start();
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		// Handle "New"
		if (ae.getSource() == newMenuItem) {

		}

		// Handle "Save"
		if (ae.getSource() == saveMenuItem) {

		}

		// Handle "Open"
		if (ae.getSource() == openMenuItem) {

		}

		// Handle "Exit"
		if (ae.getSource() == exitMenuItem) {
			System.exit(0);
		}
	}
}
