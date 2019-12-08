package org.gameview;

import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	private JTextField descriptionView = new JTextField();
	private JButton[] inventoryView = new JButton[] {};
	private LayoutManager layout;
	
	
	public Inventory(GameResources resources, Player player) {
		this.resources = resources;
		this.player = player;
		this.descriptionView.setEditable(false);
		this.add(descriptionView);
		this.descriptionView.setText("Inventory information");
		this.updateInventory();
		this.setSize(400, 700);
		this.setTitle("Inventory");
	}
	
	public void updateInventory() {
		if (player.getArtifactInventory().length == 0) {
			this.setVisible(false);
		}
		for (Component b : this.inventoryView) {
			this.remove(b);
		}
		this.inventoryView = new JButton[] {};
		Artifact[] artifacts = player.getArtifactInventory();
		this.layout = new FlowLayout();
		this.setLayout(layout);
		
		inventoryView = new JButton[artifacts.length];
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

