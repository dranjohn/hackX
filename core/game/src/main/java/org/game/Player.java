package org.game;

import java.util.LinkedList;
import java.util.List;

import org.itemsystem.Artifact;
import org.itemsystem.Item;

public class Player {
	private float xPos = 0;
	private float yPos = 0;
	private float range;
	private List<Artifact> artifactInventory = new LinkedList<>();

	public Player(float range) {
		this.range = range;
	}

	public float[] getLocation(int... is) {
		return new float[] { xPos, yPos };
	}

	/**
	 * Collects an item and triggers its corresponding actions which for example can
	 * open a quiz. (Currently no events possible)
	 * 
	 * @param item
	 */
	public void collect(Item item) {
		if (item instanceof Artifact) {
			artifactInventory.add((Artifact) item);
		}
		item.triggerAllCollectionListeners();
	}

	/**
	 * 
	 * @return the range of the player object. If an item is in the range of a
	 *         player, it will visible for it.
	 */
	public float getRange() {
		return range;
	}

	public Artifact[] getArtifactInventory() {
		return (Artifact[]) artifactInventory.toArray();
	}
}
