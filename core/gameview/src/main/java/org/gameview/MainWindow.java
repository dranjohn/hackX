package org.gameview;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.game.Game;
import org.game.Player;
import org.gameobject.PointF;
import org.mapsystem.MapSnippet;

public class MainWindow extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private GameResources resources;
	private Game game;
	private List<TexturePanel> textureLayers = new ArrayList<>();
	private PointF moveDelta = new PointF(5f, 5f);

	public MainWindow(GameResources resources, Game game) {
		this.resources = resources;
		this.game = game;
		this.addKeyListener(this);
		
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		renderGame(g);
		
		
		
	}
	
	@Override
	public void update(Graphics g) {
		paint(g);
	}
	
	
	private void renderGame(Graphics g) {
		textureLayers.clear();
		BufferedImage bg = resources.getImageById("background");
		TexturePanel bgPanel = new TexturePanel(bg, 0, 0);
		textureLayers.add(bgPanel);

		for (MapSnippet s : game.getVisibleMapSnippets()) {
			BufferedImage i = resources.getImageById(s.getId());

			Point p = convertToScreen(new PointF(0, 0), getWidth(), getHeight());
			TexturePanel panel = new TexturePanel(i, p.x, p.y);
			textureLayers.add(panel);
		}
		
		BufferedImage playerTexture = resources.getImageById("player_image");
		Point playerPosition = convertToScreen(game.getPlayer().getLocation(), getWidth(), getHeight());
		TexturePanel playerPanel = new TexturePanel(playerTexture, playerPosition.x, playerPosition.y);
		textureLayers.add(playerPanel);
		
		for (TexturePanel texture : textureLayers) {
			g.drawImage(texture.getImage(), texture.getX(), texture.getY(), this);
		}
	}
	
	

	/**
	 * SCALING NOT SUPPORTED AT THE MOMENT! 
	 * returns an simple int conversion from the float point
	 * @param pointF
	 * @param width
	 * @param height
	 * @return
	 */
	public Point convertToScreen(PointF pointF, float width, float height) {
		// int x = (int) ((getWidth() / width) * point[0]);
		// int y = (int) ((getHeight() / height) * point[1]);
		return new Point((int) pointF.getX(), (int) pointF.getY());
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyChar() == 'w') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setY(pos.getY() - moveDelta.getY());
			
		}
		
		if (e.getKeyChar() == 'a') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setX(pos.getX() - moveDelta.getX());
		}
		
		if (e.getKeyChar() == 's') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setY(pos.getY() + moveDelta.getY());
			
		}
		
		if (e.getKeyChar() == 'd') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setX(pos.getX() + moveDelta.getX());
			
		}
		
		repaint();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
