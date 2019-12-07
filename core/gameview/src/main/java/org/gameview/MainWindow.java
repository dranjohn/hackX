package org.gameview;

import javax.swing.JFrame;

import org.game.Game;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameResources resources;
	private Game game;
	private MapView mapView;

	public MainWindow(GameResources resources, Game game) {
		this.resources = resources;
		this.game = game;
		this.mapView = new MapView(resources, game);

		initWindow();
	}

	private void initWindow() {
		this.add(mapView);
	}

}
