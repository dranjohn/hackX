package org.gameview;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.game.Game;
import org.mapsystem.MapSnippet;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameResources resources;
	private Game game;
	private List<TexturePanel> textureLayers = new ArrayList<>();

	public MainWindow(GameResources resources, Game game) {
		this.resources = resources;
		this.game = game;

		initWindow();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		textureLayers.clear();
		BufferedImage bg = resources.getImageById("background");
		TexturePanel bgPanel = new TexturePanel(bg, 0, 0);
		textureLayers.add(bgPanel);

		for (MapSnippet s : game.getVisibleMapSnippets()) {
			BufferedImage i = resources.getImageById(s.getId());
			System.out.println(s.getId());

			Point p = convertToScreen(s.getLocation(), i.getWidth(), getHeight());
			TexturePanel panel = new TexturePanel(i, p.x, p.y);
			textureLayers.add(panel);
		}

		for (TexturePanel texture : textureLayers) {
			g.drawImage(texture.getImage(), texture.getX(), texture.getY(), null);
		}
	}

	public Point convertToScreen(float[] point, float width, float height) {
		return new Point((int) point[0], (int) point[1]);
	}

	private void initWindow() {

	}

}
