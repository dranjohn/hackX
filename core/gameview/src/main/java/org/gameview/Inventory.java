package org.gameview;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.game.Player;
import org.itemsystem.Artifact;

public class Inventory extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameResources resources;
	private Player player;
	public Inventory(GameResources resources, Player player) {
		this.resources = resources;
		this.player = player;
		Artifact[] artifacts = player.getArtifactInventory();
		JButton[] inventoryView = new JButton[artifacts.length];
		for (int i = 0; i <  inventoryView.length; i++) {
			ImageIcon artifactIcon = new ImageIcon(resources.getImageById(artifacts[i].getId()));
			inventoryView[i] = new JButton();
			inventoryView[i].setIcon(artifactIcon);
			
		}
	}
}
