package org.game;

import java.util.LinkedList;
import java.util.List;

import org.gamestats.Stats;
import org.itemsystem.Artifact;
import org.itemsystem.Item;
import org.itemsystem.MapItem;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet;

public class Player {
	private float xPos = 0;
	private float yPos = 0;
	private float range;
	private List<Artifact> artifactInventory = new LinkedList<>();
	private List<MapItem> mapItemInventory = new LinkedList<>();
	private Stats stats;

	public Player(float range) {
		this.range = range;
		this.stats = new Stats();
	}

	public Stats getStats() {
		return stats;
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
	public void collect(Item item, Map map) {
		for (MapSnippet snippet : map.getMapSnippets()) {
			if (snippet.getItems().contains(item)) {
				snippet.removeItem(item);

				if (item instanceof Artifact) {
					artifactInventory.add((Artifact) item);
				}else if (item instanceof MapItem) {
					mapItemInventory.add((MapItem) item);
				}
				item.triggerAllCollectionListeners();
				break;
			}
		}

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
	
	public MapItem[] getMapItemInventory() {
		return (MapItem[]) mapItemInventory.toArray();
	}
}
