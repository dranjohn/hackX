package org.gameview;

import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import org.game.Game;
import org.game.Player;
import org.gameobject.PointF;
import org.itemsystem.Item;
import org.mapsystem.MapSnippet;

public class MainWindow extends JFrame implements KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final int BUFFERS = 2;
	private BufferStrategy bufferStrategy;
	
	private GameResources resources;
	private Game game;
	private Inventory inventory;
	private List<TexturePanel> textureLayers = new ArrayList<>();
	private PointF moveDelta = new PointF(5f, 5f);
	private String title = "Komisches Spiel";

	public MainWindow(GameResources resources, Game game) {
		this.resources = resources;
		this.game = game;
		this.inventory = new Inventory(resources, game.getPlayer());
		inventory.setLocation(getX() + 900 + 20, getY());
		this.addKeyListener(this);
		this.setTitle(title);
	}

	@Override
	public void paint(Graphics g) {
		if (bufferStrategy == null) {
            this.createBufferStrategy(BUFFERS);
            this.bufferStrategy = this.getBufferStrategy();
        }
        for (int i = 0; i < BUFFERS; i++) {
            Graphics gBuffered = (Graphics) bufferStrategy.getDrawGraphics();
    		renderGame(gBuffered);
            bufferStrategy.show();
            gBuffered.dispose();
        }
	}
	
	
	private void renderGame(Graphics g) {
		textureLayers.clear();
		BufferedImage bg = resources.getImageById("background");
		TexturePanel bgPanel = new TexturePanel(bg, 0, 0);
		textureLayers.add(bgPanel);

		for (MapSnippet s : game.getMap().getMapSnippets()) {
			
			if (s.getVisibility()) {
				BufferedImage i = resources.getImageById(s.getId());

				Point p = convertToScreen(new PointF(0, 0), getWidth(), getHeight());
				TexturePanel panel = new TexturePanel(i, p.x, p.y);
				textureLayers.add(panel);
			}
			
			for (Item item : game.getVisibleItems()) {
				int itemX = (int) item.getLocation().getX();
				int itemY = (int) item.getLocation().getY();
				BufferedImage itemImage = resources.getImageById(item.getId());
				TexturePanel itemPanel = new TexturePanel(itemImage, itemX, itemY);
				textureLayers.add(itemPanel);
			}
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
			repaint();
		}
		
		if (e.getKeyChar() == 'a') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setX(pos.getX() - moveDelta.getX());
			repaint();
		}
		
		if (e.getKeyChar() == 's') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setY(pos.getY() + moveDelta.getY());
			repaint();
		}
		
		if (e.getKeyChar() == 'd') {
			Player player = game.getPlayer();
			PointF pos = player.getLocation();
			pos.setX(pos.getX() + moveDelta.getX());
			repaint();
		}
		
		if (e.getKeyChar() == 'e') {
			inventory.updateInventory();
			inventory.setVisible(true);
		}
		
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			Item[] collectables = game.getItemsInRangeOfPlayer();
			
			for (Item i : collectables) {
				game.getPlayer().collect(i, game.getMap());
			}

			repaint();
		}
		
		
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
