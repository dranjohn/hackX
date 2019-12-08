package org.gameview;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import org.game.Player;
import org.itemsystem.Artifact;
import org.itemsystem.Description;

public class Inventory extends JFrame {
	private static final long serialVersionUID = 1L;
	private GameResources resources;
	private Player player;
	private JTextField descriptionView;
	
	
	public Inventory(GameResources resources, Player player) {
		this.resources = resources;
		this.player = player;
		this.updateInventory();
	}
	
	public void updateInventory() {
		this.removeAll();
		Artifact[] artifacts = player.getArtifactInventory();
		this.setLayout(new BorderLayout(artifacts.length, 1));
		
		JButton[] inventoryView = new JButton[artifacts.length];
		for (int i = 0; i <  inventoryView.length; i++) {
			ImageIcon artifactIcon = new ImageIcon(resources.getImageById(artifacts[i].getId()));
			inventoryView[i] = new JButton();
			inventoryView[i].setIcon(artifactIcon); 
			this.add(inventoryView[i]);
			ActionListener listener = new ActionListenerWithIndex(i) {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					Description d = player.getArtifactInventory()[this.index].getDescription();
					descriptionView.setText("Name: " + player.getArtifactInventory()[this.index].getName() + "\n\rAlter: " + d.getAge() + "\n\rBeschreibung:" + d.getText());
					repaint();
				}
			};
			
			
			
			inventoryView[i].addActionListener(listener);
		}
	}
	
	
	

	private abstract class ActionListenerWithIndex implements ActionListener {
		protected int index;
		public ActionListenerWithIndex(int index) {
			this.index = index;
		} 
	}
}

