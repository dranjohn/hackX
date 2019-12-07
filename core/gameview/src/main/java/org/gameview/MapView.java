package org.gameview;

import java.awt.Color;

import javax.swing.JPanel;

import org.game.Game;

public class MapView extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameResources resources;
	private Game game;

	public MapView(GameResources resources, Game game) {
		this.game = game;
		this.resources = resources;
		this.setBackground(Color.GREEN);
	}
}
