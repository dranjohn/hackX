package org.game;

import java.util.LinkedList;
import java.util.List;

import org.gameobject.PointF;
import org.gamestats.Stats;
import org.itemsystem.Artifact;
import org.itemsystem.Item;
import org.itemsystem.MapItem;
import org.mapsystem.Map;
import org.mapsystem.MapSnippet;

public class Player {
	private PointF location;
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

	public PointF getLocation() {
		return location;
	}
	
	public void setLocation(PointF location) {
		this.location = location;
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
					((MapItem) item).unlockMapSnippets();
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
		Artifact[] arr = new Artifact[artifactInventory.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = artifactInventory.get(i);
		}
		return arr;
	}
	
	public MapItem[] getMapItemInventory() {
		MapItem[] arr = new MapItem[mapItemInventory.size()];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = mapItemInventory.get(i);
		}
		return arr;
	}
}
